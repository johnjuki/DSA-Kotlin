package elementary_ds.linked_list

import utils.challenge

fun main() {
    /*
    Challenge 1.

    Create an extension function that prints out the elements of a linked list in reverse
    order. Given a linked list, print the nodes in reverse order.
     */
    "nodes in reverse order" challenge {
        val list = LinkedList<Int>()
        list.push(3).push(2).push(1)
        // println(list)

        // list.printInReverse()
    }

    /*
    Challenge 2.
    Given a linked list, find the middle node of the list.
     */
    "middle node" challenge {
        val list = LinkedList<Int>()
        list.push(4).push(3).push(2).push(1)
        // println(list)

        // list.printMiddleNode()
        // println(list.getMiddle()?.value)
    }

    /*
    Challenge 3
    Reverse a linked list.
    - To reverse a list is to manipulate the nodes so that the nodes of the list are linked in
    the opposite direction
     */
    "reverse list" challenge {
        val list = LinkedList<Int>()
        list.add(3)
        list.add(2)
        list.add(1)
        list.add(4)
        list.add(5)

        // println("Original: $list")
        // println("Reversed: ${list.reversedLinkedList()}")
    }

    /*
   Challenge 4
   Create a function that takes two sorted linked lists and merges them into a single
   sorted linked list.
    */
    "merge lists" challenge {
        val list = LinkedList<Int>()
        list.add(1)
        list.add(2)
        list.add(3)
        list.add(4)
        list.add(5)
        val other = LinkedList<Int>()
        other.add(-1)
        other.add(0)
        other.add(2)
        other.add(2)
        other.add(7)

        println("Left: $list")
        println("Right: $other")
        println("Merged: ${list.mergeSorted(other)}")
        println("Time Complexity -> O(m+n), where m is the # of nodes in the first list, and n is the # of nodes in the second list")
    }

}

// 1

fun <T : Any> LinkedList<T>.printInReverse() {
    this.nodeAt(0)?.printInReverse()
}

fun <T : Any> Node<T>.printInReverse() {
    this.next?.printInReverse()
    if (this.next != null) {
        print(" <- ")
    }
    print(this.value.toString())
}

// 2

fun <T : Any> LinkedList<T>.printMiddleNode() {
    val middleIndex = this.size / 2
    val middleNode = this.nodeAt(middleIndex)?.value
    println(middleNode)
}

// Runner technique
fun <T : Any> LinkedList<T>.getMiddle(): Node<T>? {
    var slow = this.nodeAt(0)
    var fast = this.nodeAt(0)

    while (fast != null) {
        fast = fast.next
        if (fast != null) {
            fast = fast.next
            slow = slow?.next
        }
    }
    return slow
}

// 3

private fun <T : Any> addInReverse(list: LinkedList<T>, node: Node<T>) {
    val next = node.next
    if (next != null) {
        addInReverse(list, next)
    }
    list.append(node.value)
}

fun <T : Any> LinkedList<T>.reversedLinkedList(): LinkedList<T> {
    val result = LinkedList<T>()
    val head = this.nodeAt(0)
    if (head != null) {
        addInReverse(result, head)
    }
    return result
}

// 4

fun <T : Comparable<T>> LinkedList<T>.mergeSorted(otherList: LinkedList<T>): LinkedList<T> {
    if (this.isEmpty()) return otherList
    if (otherList.isEmpty()) return this

    val result = LinkedList<T>()
    var left = nodeAt(0)
    var right = otherList.nodeAt(0)

    while (left != null && right != null) {
        if (left.value < right.value) {
            left = append(result, left)
        } else {
            right = append(result, right)
        }
    }

    while (left != null) {
        left = append(result, left)
    }

    while (right != null) {
        right = append(result, right)
    }

    return result
}

private fun <T : Comparable<T>> append(result: LinkedList<T>, node: Node<T>): Node<T>? {
    result.append(node.value)
    return node.next
}
