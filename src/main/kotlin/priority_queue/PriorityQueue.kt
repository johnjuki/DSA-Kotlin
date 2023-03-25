package priority_queue

abstract class AbstractPriorityQueue<T: Any> : Queue<T> {

    abstract val heap: Heap<T>

    override fun enqueue(element: T): Boolean {
        heap.insert(element)
        return true
    }

    override fun dequeue() = heap.remove()

    override val count: Int
        get() = heap.count

    override fun peek() = heap.peek()

}

class ComparablePriorityQueueImpl<T: Comparable<T>> : AbstractPriorityQueue<T>() {
    override val heap = ComparableHeapImpl<T>()
}

class ComparatorPriorityQueueImpl<T: Any>(private val comparator: Comparator<T>) : AbstractPriorityQueue<T>() {
    override val heap: Heap<T>
        get() = ComparatorHeapImpl(comparator)
}
