package com.hencoder.a34_generics;

import java.util.Arrays;

public class HenCoderList<T> {
    Object[] instances = new Object[0];

    public T get(int index) {
        return (T) instances[index];
    }

    public void add(T instance) {
        instances = Arrays.copyOf(instances, instances.length + 1);
        instances[instances.length - 1] = instance;
    }
}
