package com.hencoder.a34_generics.shop;

import com.hencoder.a34_generics.sim.Sim;

public interface SimShop<T, S extends Sim> extends Shop<T> {
    S buySim(String name, String id);
}
