package general

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

fun main() {
    val merc = Car("Mercedes")
    val urus = Car("Lamborghini")
    merc.doors = 2
    urus.doors = 4

    fun printCar(car: Car?) {
        val isCoupe = car?.let2 { it.doors <= 2 }
        if (isCoupe!!) println("$car - Coupes are awesome") else println("$car - not coupe")
    }

    fun printCar2(car: Car?) {
        val isCoupe = car?.run2 { this.doors <= 2 }
        if (isCoupe!!) println("$car - Coupes are awesome") else println("$car - not coupe")
    }

    fun printCar3(car: Car?) {
        car?.also2 { it.doors = 64 }.let2 { if (it?.doors != null && it.doors <= 2) println("awesome") }
    }

    fun printCar4(car: Car?) {
        car?.apply { doors = 4 }.let { if (it?.doors != null && it.doors == 4) println("not coupe") }
    }

    // Time complexity
    val numbers = listOf(1, 3, 56, 66, 68, 80, 99, 105, 450)
    println(pseudoBinaryContains(451, numbers))
}

class Car(private val name: String) {

    var doors: Int = 0

    fun drive() = "driving"

    override fun toString() = name
}

fun Car.trying(): Int {
    return this.doors
}

@OptIn(ExperimentalContracts::class)
inline fun <T, R> T.let2(block: (T) -> R): R {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return block(this)
}

@OptIn(ExperimentalContracts::class)
inline fun <T> T.also2(block: (T) -> Unit): T {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    block(this)
    return this
}

@OptIn(ExperimentalContracts::class)
inline fun <T, R> T.run2(block: T.() -> R): R {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return block()
}

@OptIn(ExperimentalContracts::class)
inline fun <T> T.apply2(block: T.() -> Unit): T {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    block()
    return this
}

// Logarithmic time example
fun pseudoBinaryContains(value: Int, numbers: List<Int>): Boolean {
    if (numbers.isEmpty()) return false

    val middleIndex = numbers.size / 2

    if (value <= numbers[middleIndex]) {
        for (index in 0..middleIndex) {
            if (numbers[index] == value) return true
        }
    } else {
        for (index in middleIndex until numbers.size) {
            if (numbers[index] == value) return true
        }
    }
    return false
}
