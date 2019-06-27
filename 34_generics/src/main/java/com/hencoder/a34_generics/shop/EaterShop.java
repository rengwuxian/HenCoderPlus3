package com.hencoder.a34_generics.shop;

import com.hencoder.a34_generics.food.Eater;
import com.hencoder.a34_generics.food.Food;
import com.hencoder.a34_generics.sim.Sim;

import java.util.List;

public interface EaterShop<F extends Food, T extends Eater<F>> extends Shop<T> {
}