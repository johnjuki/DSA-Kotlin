package binary_trees

import java.lang.Integer.max

private typealias Visitor<T> = (T) -> Unit

class BinaryNode<T : Comparable<T>>(var value: T) {

    var leftChild: BinaryNode<T>? = null

    var rightChild: BinaryNode<T>? = null

    val min: BinaryNode<T>
        get() = leftChild?.min ?: this

    val isBinarySearchTree: Boolean
        get() = isBst(this, min = null, max = null)

    private fun diagram(
        node: BinaryNode<T>?,
        top: String = "",
        root: String = "",
        bottom: String = "",
    ): String {
        return node?.let {
            if (node.leftChild == null && node.rightChild == null) {
                "$root${node.value}\n"
            } else {
                diagram(node.rightChild, "$top ", "$top┌──", "$top│ ") +
                        root + "${node.value}\n" + diagram(
                    node.leftChild,
                    "$bottom│ ", "$bottom└──", "$bottom "
                )
            }
        } ?: "${root}null\n"
    }

    fun traverseInOrder(visit: Visitor<T>) {
        leftChild?.traverseInOrder(visit)
        visit(value)
        rightChild?.traverseInOrder(visit)
    }

    fun traversePreOrder(visit: Visitor<T>) {
        visit(value)
        leftChild?.traversePreOrder(visit)
        rightChild?.traversePreOrder(visit)
    }

    fun traversePostOrder(visit: Visitor<T>) {
        leftChild?.traversePostOrder(visit)
        rightChild?.traversePostOrder(visit)
        visit(value)
    }

    fun height(node: BinaryNode<T>? = this): Int {
        return node?.let { 1 + max(height(node.leftChild), height(node.rightChild)) } ?: -1
    }

    private fun isBst(tree: BinaryNode<T>?, min: T?, max: T?): Boolean {
        tree ?: return true
        if (min != null && tree.value <= min) {
            return false
        } else if (max != null && tree.value > max) {
            return false
        }
        return isBst(tree.leftChild, min, tree.value) && isBst(tree.rightChild, tree.value, max)
    }

    override fun toString() = diagram(this)

    override fun equals(other: Any?): Boolean {
        return if (other != null && other is BinaryNode<*>) {
            this.value == other.value
                    && this.leftChild == other.leftChild
                    && this.rightChild == other.rightChild
        } else {
            false
        }
    }

    // Not necessary in our implementations.
    // The compiler complained that it should be overriden because we've overriden equals
    override fun hashCode(): Int {
        var result = value.hashCode()
        result = 31 * result + (leftChild?.hashCode() ?: 0)
        result = 31 * result + (rightChild?.hashCode() ?: 0)
        return result
    }
}
