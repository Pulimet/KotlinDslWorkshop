package com.example.kotlindslworkshop.samples

@Suppress("MemberVisibilityCanBePrivate")
class S6OperatorsOverloading {

    val point = Point(10, 20)

    init {
        println(-point)  // prints "Point(x=-10, y=-20)"
    }
}

data class Point(val x: Int, val y: Int)

operator fun Point.unaryMinus() = Point(-x, -y)