package com.hencoder.a34_generics.shop;

import com.hencoder.a34_generics.fruit.Apple;
import com.hencoder.a34_generics.sim.ChinaUnicomSim;

public class UnicomSimShop implements SimShop<Apple, ChinaUnicomSim> {
    @Override
    public ChinaUnicomSim buySim(String name, String id) {
        return new ChinaUnicomSim();
    }

    @Override
    public Apple buy() {
        return new Apple();
    }

    @Override
    public float refund(Apple item) {
        return 10;
    }
}
