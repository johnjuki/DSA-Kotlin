package heap

import utils.example

fun main() {
    "max-heap" example {
        val array = arrayListOf(1, 12, 3, 4, 1, 6, 8, 7)
        val priorityQueue = ComparableHeapImpl.create(array)
        while (!priorityQueue.isEmpty) {
            println(priorityQueue.remove())
        }
    }

//    "min-heap" example {
//        val array = arrayListOf(1, 12, 3, 4, 1, 6, 8, 7)
//        val inverseComparator = Comparator<Int> { o1, o2 ->
//            override fun compare(o1: Int, o2: Int) : Int = o2.compareTo(o1)
//        }
//        val minHeap = ComparatorHeapImpl.create(array, inverseComparator)
//        while (!minHeap.isEmpty) {
//            println(minHeap.remove())
//        }
//    }
}
