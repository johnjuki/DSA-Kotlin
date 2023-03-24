package binary_search_trees

import utils.example

fun main() {
    "building a BST" example {
        val bst = BinarySearchTree<Int>()
        (0..4).forEach { bst.insert(it) }
        // println(bst)
    }

    val balancedTree = BinarySearchTree<Int>().apply {
        insert(3)
        insert(1)
        insert(4)
        insert(0)
        insert(2)
        insert(5)
    }

    "building a balanced bst" example {
        // println(balancedTree)
    }

    "finding a node" example {
        if (balancedTree.contains(5)) {
            // println("Found 5!")
        } else {
            // println("Couldn't find 5")
        }
    }

    "removing a node" example {
        println("Tree before removal:")
        println(balancedTree)
        balancedTree.remove(3)
        println("Tree after removing root:")
        println(balancedTree)
    }
}
