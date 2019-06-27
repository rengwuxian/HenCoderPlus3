package com.hencoder.a34_generics.kotlin

interface Huggable<in T> {
    fun hug(person: T)
}