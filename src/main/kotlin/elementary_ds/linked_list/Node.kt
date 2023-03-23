package elementary_ds.linked_list

// Note: Unit T: Any to set an upper bound for the type parameter ensures that T will always be a non-nullable type.
data class Node<T: Any>(var value: T, var next: Node<T>? = null) {
    override fun toString(): String {
        return if (next != null) {
            "$value -> ${next.toString()}"
        } else {
            "$value"
        }
    }
}
