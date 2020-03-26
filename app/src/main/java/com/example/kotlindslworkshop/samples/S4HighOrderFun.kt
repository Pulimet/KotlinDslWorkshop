package com.example.kotlindslworkshop.samples

import android.util.Log

@Suppress("MemberVisibilityCanBePrivate")
class S4HighOrderFun {
    val functionPrintingHello: () -> Unit = {
        Log.d("TAG", "functionPrintingHello")
    }

    init {
        highOrderFunction1(functionPrintingHello)
    }

    fun highOrderFunction1(function: () -> Unit) {
        function()
    }
}