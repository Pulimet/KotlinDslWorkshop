package com.example.kotlindslworkshop.samples

import android.util.Log

@Suppress("MemberVisibilityCanBePrivate", "MoveLambdaOutsideParentheses")
class S8LambdaOutOfParentheses {

    init {
        val functionPrintsHello: () -> Unit = { Log.d("TAG", "Hello") }

        doSomething(functionPrintsHello)

        doSomething(
            { Log.d("TAG", "Hello") }
        )

        doSomething { Log.d("TAG", "Hello") }
    }

    fun doSomething(function: () -> Unit) {
        function()
    }
}