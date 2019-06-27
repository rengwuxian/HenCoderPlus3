package com.hencoder.a34_generics.shop;

import com.hencoder.a34_generics.fruit.Apple;

public class AppleShop implements Shop<Apple> {
    @Override
    public Apple buy() {
        return null;
    }

    @Override
    public float refund(Apple item) {
        return 0;
    }
}
