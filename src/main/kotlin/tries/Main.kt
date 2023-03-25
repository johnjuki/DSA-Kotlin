package tries

import utils.example

fun main() {
    "insert and contains" example {
        val trie = Trie<Char>()
        trie.insert("billionaire")
        if (trie.contains("billionaire")) {
            // println("billionaire is in the trie")
        }
    }

    "remove" example {
        val trie = Trie<Char>()
        trie.insert("cut")
        trie.insert("cute")

        println("\n*** Before removing ***")
        assert(trie.contains("cut"))
        println("\"cut\" is in the trie")
        assert(trie.contains("cute"))
        println("\"cute\" is in the trie")

        println("\n*** After removing cut ***")
        trie.remove("cut")
        assert(!trie.contains("cut"))
        assert(trie.contains("cute"))
        println("\"cute\" is still in the trie")
    }
}
