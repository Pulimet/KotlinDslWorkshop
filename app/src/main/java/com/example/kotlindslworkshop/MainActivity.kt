package com.example.kotlindslworkshop

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sqlString = SqlBuilder().build()
        tvResult.text = sqlString
    }
}

class SqlBuilder {
    fun build() = "select * from my_table"
}
