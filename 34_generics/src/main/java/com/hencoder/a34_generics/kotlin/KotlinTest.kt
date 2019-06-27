package com.hencoder.a34_generics.kotlin

import com.hencoder.a34_generics.fruit.Apple
import com.hencoder.a34_generics.fruit.Fruit

class KotlinTest {
    fun main() {
        var fruits: Array<out Fruit> = Array<Apple>(10, {Apple()})
        var apples: Array<in Apple> = Array<Fruit>(10, {Fruit()})
    }
}