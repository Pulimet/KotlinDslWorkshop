package com.example.kotlindslworkshop.samples

@Suppress("MemberVisibilityCanBePrivate")
class S9LambdaWithReceiverType {

    init {
        buildCar {
            val car = Car()
            car.makeBody()
            car.addWheels()
            car.paint()
        }
    }

    fun buildCar(init:() -> Unit) {
            init()
    }
}

class Car {
    fun makeBody() {}
    fun addWheels() {}
    fun paint() {}
}