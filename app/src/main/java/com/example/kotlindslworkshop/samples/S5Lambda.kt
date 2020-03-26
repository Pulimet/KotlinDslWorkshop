package com.example.kotlindslworkshop.samples

class S5Lambda {
    val sum: (Int, Int) -> Int = { x: Int, y: Int -> x + y }
    val x = sum(2, 3)

    val sum2 = { x: Int, y: Int -> x + y }
    val y = sum2(2, 3)
}