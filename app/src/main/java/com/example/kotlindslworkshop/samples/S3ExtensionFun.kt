package com.example.kotlindslworkshop.samples

class S3ExtensionFun {
    init {
        val result = "My name it Kotlin".addDot()
        // result == "My name it Kotlin."
    }
}

fun String.addDot() = "$this."

