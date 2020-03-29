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
            from("my_table")
        }.build()
    }
}

fun query(initializer: SqlBuilder.() -> Unit) = SqlBuilder().apply(initializer)

class SqlBuilder {
    private val columns = mutableListOf<String>()
    private lateinit var table: String

    fun select(vararg columns: String) {
        this.columns.addAll(columns)
    }

    fun from(table: String) {
        this.table = table
    }

    fun build() : String {
        val columnsToFetch =
            if (columns.isEmpty()) {
                "*"
            } else {
                columns.joinToString(", ")
            }
        return "select $columnsToFetch from $table"
    }
}
