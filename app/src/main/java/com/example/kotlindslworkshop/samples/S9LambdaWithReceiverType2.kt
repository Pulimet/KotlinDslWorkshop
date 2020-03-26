package com.example.kotlindslworkshop.samples

@Suppress("MemberVisibilityCanBePrivate")
class S9LambdaWithReceiverType2 {

    init {
        buildCar {
            makeBody()
            addWheels()
            paint()
        }
    }

    fun buildCar(init: Car.() -> Unit) {
        val car = Car()
        car.init()
    }
}