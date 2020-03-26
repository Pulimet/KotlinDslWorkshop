package com.example.kotlindslworkshop.samples

import android.util.Log

@Suppress("MemberVisibilityCanBePrivate")
class S4HighOrderFun2 {
    val functionPrintingString: (string: String) -> Unit = {
        Log.d("TAG", it)
    }

    init {
        highOrderFunction2(functionPrintingString)
    }

    fun highOrderFunction2(function: (String) -> Unit) {
        function("highOrderFunction2")
    }
}