package elementary_ds.linked_list

import utils.example

fun main() {
    "removing elements" example {
        val list: MutableCollection<Int> = LinkedList()
        list.add(3)
        list.add(2)
        list.add(1)

        println(list)
        list.remove(1)
        println(list)
    }
    "retaining elements" example {
        val list: MutableCollection<Int> = LinkedList()
        list.add(3)
        list.add(2)
        list.add(1)
        list.add(4)
        list.add(5)

        println(list)
        list.retainAll(listOf(3, 4, 5))
        println(list)
    }
    "remove all elements" example {
        val list: MutableCollection<Int> = LinkedList()
        list.add(3)
        list.add(2)
        list.add(1)
        list.add(4)
        list.add(5)

        println(list)
        list.removeAll(listOf(3, 4, 5))
        println(list)
    }
}
