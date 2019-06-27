package com.hencoder.a34_generics.food;

public class Eater<T extends Food> {
    public void eat(T food) {
        food.eaten();
    }
}
