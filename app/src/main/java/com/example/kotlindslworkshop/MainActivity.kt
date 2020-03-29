package com.example.kotlindslworkshop

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvResult.text = query {
            select("col1", "col2")
        }.build()
    }
}

fun query(initializer: SqlBuilder.() -> Unit) = SqlBuilder().apply(initializer)

class SqlBuilder {
    private val columns = mutableListOf<String>()

    fun select(vararg columns: String) {
        this.columns.addAll(columns)
    }

    fun build() = "select * from my_table"
}
