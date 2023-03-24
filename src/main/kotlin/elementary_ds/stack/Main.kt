package elementary_ds.stack

import utils.example

fun main() {
    "using a stack" example {
        val stack = StackImpl<Int>().apply {
            push(1)
            push(2)
            push(3)
            push(4)
        }
        //  print(stack)
        val poppedElement = stack.pop()
        if (poppedElement != null) println("Popped: $poppedElement")
        // print(stack)
    }

    "initializing a stack from an array literal" example {
        val stack = stackOf(1.0, 2.0, 3.0, 4.0)
        print(stack)
        println("Popped: ${stack.pop()}")
    }

}