package com.example.kotlindslworkshop

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvResult.text = query {

        }.build()
    }
}

fun query(initializer: SqlBuilder.() -> Unit) = SqlBuilder().apply(initializer)

class SqlBuilder {
    fun build() = "select * from my_table"
}
