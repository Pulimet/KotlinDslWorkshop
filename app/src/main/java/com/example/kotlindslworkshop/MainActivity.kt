package com.example.kotlindslworkshop

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

private val tag = "WORKSHOP_TAG"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvResult.text = query {
            Log.d(tag, "Lambda called")
        }.build()
    }
}

fun query(init: () -> Unit) : SqlBuilder {
    init()
    return SqlBuilder()
}

class SqlBuilder {

    fun printLog() {
        Log.d(tag, "printLog function called")
    }

    fun build() = "select * from my_table"
}
