package elementary_ds.stack

import elementary_ds.linked_list.LinkedList
import utils.challenge

fun main() {
    /*
    1. Given a linked list, print the nodes in reverse order. You should not use recursion to
    solve this problem
     */
    "nodes in reverse order" challenge {
        val list = LinkedList<Int>()
        list.push(3).push(2).push(1)
        // println(list)

        // list.printInReverse()
    }

    /*
    2. Check for balanced parenthesis
     */
    "parentheses validation" challenge {
        println("h((e))llo(world)()".parenthesesValidation())
        println("(hello world".parenthesesValidation())
    }
}

// 1

private fun <T : Any> LinkedList<T>.printInReverse() {
    val stack = StackImpl<T>()
    for (node in this) {
        stack.push(node)
    }
    var node = stack.pop()
    while (node != null) {
        println(node)
        node = stack.pop()
    }
}

private fun String.parenthesesValidation(): Boolean {
    val stack = StackImpl<Char>()
    for (char in this) {
        when (char) {
            '(' -> stack.push(char)
            ')' -> if (stack.isEmpty) return false else stack.pop()
        }
    }
    return stack.isEmpty
}
