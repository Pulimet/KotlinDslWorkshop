package com.example.kotlindslworkshop.samples

import android.util.Log

class S7InfixFun {
    init {
        val x = 2 times 5
        Log.d("TAG", "$x")
    }
}

infix fun Int.times(x: Int): Int {
    return x * this
}