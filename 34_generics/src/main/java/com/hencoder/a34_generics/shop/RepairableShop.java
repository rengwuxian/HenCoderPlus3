package com.hencoder.a34_generics.shop;

public interface RepairableShop<T> {
    T buy();
    float refund(T item);
}
