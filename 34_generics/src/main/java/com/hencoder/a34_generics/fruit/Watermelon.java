package com.hencoder.a34_generics.fruit;

import java.util.List;

public class Watermelon implements Fruit {
    @Override
    public float getWeight() {
        return 1;
    }

    public boolean hasSeed() {
        return true;
    }
}
