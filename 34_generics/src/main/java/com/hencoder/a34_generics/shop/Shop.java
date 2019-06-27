package com.hencoder.a34_generics.shop;

import com.hencoder.a34_generics.sim.Sim;

import java.util.List;

public interface Shop<T> {
    T buy();
    float refund(T item);

//    <E extends Shop & Sim> void someMethod(E item);
//    <R> void addToList(R item, List<? super R> list);
    // Shop<Apple>
    // Apple buy();
    // float refund(Apple item);
}
