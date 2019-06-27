package com.hencoder.a34_generics.shop;

import com.hencoder.a34_generics.fruit.Fruit;

public interface NormalFruitShop extends NormalShop {
    Fruit buy();

    float refund(Fruit item);
}
