package avl_trees

typealias Visitor<T> = (T) -> Unit

class AVLNode<T>(value: T) : TraversableBinaryNode<AVLNode<T>, T>(value){

    var height = 0

    val leftHeight: Int
        get() = leftChild?.height ?: - 1

    val rightHeight: Int
        get() = rightChild?.height ?: -1

    val balancedFactor: Int
        get() = leftHeight - rightHeight

    val min: AVLNode<T>
        get() = leftChild?.min ?: this

    override fun toString() = diagram(this)

    private fun diagram(node: AVLNode<T>?,
                        top: String = "",
                        root: String = "",
                        bottom: String = ""): String {
        return node?.let {
            if (node.leftChild == null && node.rightChild == null) {
                "$root${node.value}\n"
            } else {
                diagram(node.rightChild, "$top ", "$top┌──", "$top│ ") +
                        root + "${node.value}\n" + diagram(node.leftChild, "$bottom│ ", "$bottom└──", "$bottom ")
            }
        } ?: "${root}null\n"
    }
}
