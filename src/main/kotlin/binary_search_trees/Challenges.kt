package binary_search_trees

import binary_trees.BinaryNode
import utils.challenge

fun main() {
    // 1. Create a function that checks if a binary tree is a binary search tree
    "is BST?" challenge {
        val zero = BinaryNode(0)
        val one = BinaryNode(1)
        val five = BinaryNode(5)
        val seven = BinaryNode(7)
        val eight = BinaryNode(8)
        val nine = BinaryNode(9)

        seven.leftChild = one
        one.leftChild = zero
        one.rightChild = five
        seven.rightChild = nine
        nine.leftChild = eight

         println(seven.isBinarySearchTree)
    }
}
