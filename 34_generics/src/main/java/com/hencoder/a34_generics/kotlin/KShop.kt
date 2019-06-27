package com.hencoder.a34_generics.kotlin

import com.hencoder.a34_generics.fruit.Apple

interface KShop<out T> {
    fun buy(): T
}