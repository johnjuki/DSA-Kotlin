package heap

import java.util.*

interface Heap<T : Any> : Collection<T> {
    fun peak(): T?
}

abstract class AbstractHeap<T : Any>() : Heap<T> {

    var elements: ArrayList<T> = ArrayList<T>()

    override val count: Int
        get() = elements.size


    abstract fun compare(a: T, b: T): Int

    override fun peak(): T? = elements.firstOrNull()

    private fun leftChildIndex(index: Int) = (2 * index) + 1

    private fun rightChildIndex(index: Int) = (2 * index ) + 2

    private fun parentIndex(index: Int) = (index - 1) / 2

    private fun index(element : T, i: Int) : Int? {
        if (i >= count) return null
        if (compare(element, elements[i]) > 0 ) return null
        if (element == elements[i]) return i
        val leftChildIndex = index(element, leftChildIndex(i))
        if (leftChildIndex != null) return leftChildIndex
        val rightChildIndex = index(element, rightChildIndex(i))
        if (rightChildIndex != null) return rightChildIndex
        return null
    }

    protected fun heapify(values: ArrayList<T>) {
        elements = values
        if (elements.isNotEmpty()) {
            (count / 2 downTo 0).forEach { siftDown(it) }
        }
    }

    override fun insert(element: T) {
        elements.add(element)
        siftUp(count - 1)
    }

    override fun remove(): T? {
        if (isEmpty) return null
        Collections.swap(elements, 0, count - 1)
        val item = elements.removeAt(count - 1)
        siftDown(0)
        return item
    }

    override fun remove(index: Int): T? {
        if (index >= count) return null
        return if (index == count - 1) {
            elements.removeAt(count - 1)
        } else {
            Collections.swap(elements, index, count - 1)
            val item = elements.removeAt(count - 1)
            siftDown(index)
            siftUp(index)
            item
        }
    }

    private fun siftUp(index: Int) {
        var child = index
        var parent = parentIndex(child)
        while (child > 0 && compare(elements[child], elements[parent]) > 0) {
            Collections.swap(elements, child, parent)
            child = parent
            parent = parentIndex(child)
        }
    }

    private fun siftDown(index: Int) {
        var parent = index //1
        while (true) { //2
            val left = leftChildIndex(parent) //3
            val right = rightChildIndex(parent)
            var candidate = parent //4
            if (left < count && compare(elements[left], elements[candidate]) > 0) {
                candidate = left //5
            }
            if (right < count && compare(elements[right], elements[candidate]) > 0) {
                candidate = right //6
            }
            if (candidate == parent) return //7
            Collections.swap(elements, parent, candidate) //8
            parent = candidate
        }
    }
}

class ComparableHeapImpl<T : Comparable<T>>() : AbstractHeap<T>() {

    override fun compare(a: T, b: T) = a.compareTo(b)

    companion object {
        fun <T: Comparable<T>> create(elements: ArrayList<T>) : Heap<T> {
            val heap = ComparableHeapImpl<T>()
            heap.heapify(elements)
            return heap
        }
    }
}

class ComparatorHeapImpl<T : Any>(private val comparator: Comparator<T>) : AbstractHeap<T>() {

    override fun compare(a: T, b: T) = comparator.compare(a, b)

    companion object {
        fun <T: Any> create(
            elements: ArrayList<T>,
            comparator: Comparator<T>,
        ): Heap<T> {
            val heap = ComparatorHeapImpl(comparator)
            heap.heapify(elements)
            return heap
        }
    }
}
