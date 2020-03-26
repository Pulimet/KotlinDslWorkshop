package com.example.kotlindslworkshop.samples

class S2TopLevelFun {
    init {
        topLevelFunction(2,3)
    }
}

fun topLevelFunction(a: Int, b: Int) = a + b