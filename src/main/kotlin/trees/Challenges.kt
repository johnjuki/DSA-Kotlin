package trees

fun main() {
    /*
    1. Print the values in a tree in an order based on their level. Nodes belonging to the
    same level should be printed on the same line
     */
    val tree = makeBeverageTree()
    tree.printEachLevel()
}

