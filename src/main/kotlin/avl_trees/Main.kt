package avl_trees

import utils.example

fun main() {
    "repeated insertions in sequence" example {
        val tree = AVLTree<Int>()
        (0..14).forEach { tree.insert(it) }
        // print(tree)
        tree.insert(15)
        tree.insert(16)
        tree.insert(18)
        print(tree)
        tree.remove(10)
        print(tree)
    }

}
