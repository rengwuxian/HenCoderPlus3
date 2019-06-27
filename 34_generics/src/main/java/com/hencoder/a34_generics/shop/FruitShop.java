package com.hencoder.a34_generics.shop;

import com.hencoder.a34_generics.fruit.Fruit;

public interface FruitShop<T extends Fruit> extends Shop<T> {
}