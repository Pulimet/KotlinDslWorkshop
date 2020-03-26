package com.example.kotlindslworkshop.samples

@Suppress("MemberVisibilityCanBePrivate")
class S1ConciseFun {
    init {
        sum(2,3)
        sum2(2,3)
        sum3(2,3)
    }

    // Function having two Int parameters with Int return type:
    fun sum(a: Int, b: Int): Int {
        return a + b
    }

    // Function with an expression body:
    fun sum2(a: Int, b: Int): Int = a + b

    // And here the return type is gathered from the function body:
    fun sum3(a: Int, b: Int) = a + b

}