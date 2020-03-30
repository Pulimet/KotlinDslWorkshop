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
            where {
                "col1" eq 4
                or {
                    "col2" eq 1
                    "col2" eq 9
                }
            }
        }.build()
    }
}

fun query(initializer: SqlBuilder.() -> Unit) = SqlBuilder().apply(initializer)

class SqlBuilder {
    private val columns = mutableListOf<String>()
    private lateinit var table: String
    private var condition: Condition? = null

    fun select(vararg columns: String) {
        this.columns.addAll(columns)
    }

    fun from(table: String) {
        this.table = table
    }

    fun where(initializer: Condition.() -> Unit) {
        condition = And().apply(initializer)
    }

    fun build(): String {
        val columnsToFetch =
            if (columns.isEmpty()) {
                "*"
            } else {
                columns.joinToString(", ")
            }
        val conditionString =
            if (condition == null) {
                ""
            } else {
                " where $condition"
            }
        return "select $columnsToFetch from $table$conditionString"
    }
}

abstract class Condition {
    protected abstract fun addCondition(condition: Condition)

    infix fun String.eq(value: Any?) {
        addCondition(Eq(this, value))
    }

    fun and(initializer: Condition.() -> Unit) {
        addCondition(And().apply(initializer))
    }

    fun or(initializer: Condition.() -> Unit) {
        addCondition(Or().apply(initializer))
    }
}

open class CompositeCondition(private val sqlOperator: String) : Condition() {
    private val conditions = mutableListOf<Condition>()

    override fun addCondition(condition: Condition) {
        conditions += condition
    }

    override fun toString(): String {
        return if (conditions.size == 1) {
            conditions.first().toString()
        } else {
            conditions.joinToString(prefix = "(", postfix = ")", separator = " $sqlOperator ")
        }
    }
}

class And : CompositeCondition("and")

class Or : CompositeCondition("or")

class Eq(private val column: String, private val value: Any?) : Condition() {

    override fun addCondition(condition: Condition) {}

    override fun toString(): String {
        return when (value) {
            null -> "$column is null"
            is String -> "$column = '$value'"
            else -> "$column = $value"
        }
    }
}