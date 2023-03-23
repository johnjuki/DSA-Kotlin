package elementary_ds.linked_list

import java.lang.IndexOutOfBoundsException

class LinkedList<T : Any> : MutableCollection<T> {

    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    override var size = 0
        private set

    override fun isEmpty(): Boolean = size == 0

    fun push(value: T): LinkedList<T> = apply {
        head = Node(value = value, next = head)
        if (tail == null) tail = head
        size++
    }

    fun append(value: T) : LinkedList<T> = apply {
        if (isEmpty()) {
            push(value)
            return@apply
        }
        val newNode = Node(value = value)
        tail!!.next = newNode
        tail = newNode
        size ++
    }

    fun nodeAt(index: Int) : Node<T>? {
        var currentNode = head
        var currentIndex = 0

        while (currentNode != null && currentIndex < index) {
            currentNode = currentNode.next
            currentIndex++
        }
        return currentNode
    }

    fun insert(value: T, afterNode: Node<T>) : Node<T> {
        if (tail == afterNode) {
            append(value)
            return tail!!
        }
        val newNode = Node(value = value, next = afterNode.next)
        afterNode.next = newNode
        size++
        return newNode
    }

    fun pop() : T? {
        if (isEmpty()) return null
        val result = head?.value
        head = head?.next
        size--
        if (isEmpty()) tail = null
        return result
    }

    fun removeLast() : T? {
        val head = head ?: return null
        if (head.next == null) return pop()
        size--

        var prev = head
        var current = head
        var next = current.next
        while (next != null) {
            prev = current
            current = next
            next = current.next
        }
        prev.next = null
        tail = prev
        return current.value
    }

    fun removeAfter(node: Node<T>) : T? {
        val result = node.next?.value
        if (node.next == tail) tail = node
        if (node.next != null) size--
        node.next = node.next?.next
        return result
    }

    override fun contains(element: T): Boolean {
        for (item in this) {
            if (item == element) return true
        }
        return false
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        for (searched in elements) {
            if (!(contains(searched))) return false
        }
        return true
    }

    override fun iterator(): MutableIterator<T> {
        return LinkedListIterator(this)
    }

    override fun retainAll(elements: Collection<T>): Boolean {
        var result = false
        val iterator = this.iterator()
        while (iterator.hasNext()) {
            val item = iterator.next()
            if (!elements.contains(item)) {
                iterator.remove()
                result = true
            }
        }
        return  result
    }

    override fun add(element: T): Boolean {
        append(element)
        return true
    }

    override fun addAll(elements: Collection<T>): Boolean {
        for (element in elements) {
            append(element)
        }
        return true
    }

    override fun remove(element: T): Boolean {
        val iterator = iterator()
        while (iterator.hasNext()) {
            val item = iterator.next()
            if (item == element) {
                iterator.remove()
                return true
            }
        }
        return false
    }

    override fun removeAll(elements: Collection<T>): Boolean {
        var result = false
        for (item in elements) {
            result = remove(item) || result
        }
        return result
    }

    override fun clear() {
        head = null
        tail = null
        size = 0
    }

    override fun toString(): String {
        return if (isEmpty()) "Empty list" else head.toString()
    }
}

class LinkedListIterator<T: Any>(private val list: LinkedList<T>) : MutableIterator<T> {
    private var index = 0
    private var lastNode: Node<T>? = null

    override fun next(): T {
        if (index >= list.size ) throw IndexOutOfBoundsException()
        lastNode = if (index == 0) list.nodeAt(0) else lastNode?.next
        index++
        return lastNode!!.value
    }

    override fun remove() {
        if (index == 1) {
            list.pop()
        } else {
            val prevNode = list.nodeAt(index - 2) ?: return
            list.removeAfter(prevNode)
            lastNode = prevNode
        }
        index--
    }

    override fun hasNext(): Boolean {
        return index < list.size
    }
}
