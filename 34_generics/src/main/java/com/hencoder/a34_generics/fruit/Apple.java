package com.hencoder.a34_generics.fruit;

import java.util.List;

public class Apple implements Fruit {
    @Override
    public float getWeight() {
        return 1;
    }

    public void addMeToList(List<? super Apple> list) {
        list.add(this);
    }
}
