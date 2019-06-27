package com.hencoder.a34_generics;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.reflect.TypeToken;
import com.hencoder.a34_generics.fruit.Apple;
import com.hencoder.a34_generics.fruit.Fruit;
import com.hencoder.a34_generics.fruit.Watermelon;
import com.hencoder.a34_generics.shop.FruitShop;
import com.hencoder.a34_generics.shop.NormalShop;
import com.hencoder.a34_generics.shop.Shop;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Shop<Apple>> appleShopList = new ArrayList<Shop<Apple>>(){};

type projection
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Shop<?>[] objects = new Shop<?>[10];
        TypeToken<List<String>> listTypeToken = new TypeToken<List<String>>(){};
        List<? extends Fruit> fruits = new ArrayList<Apple>();
        List<? super Apple> apples = new ArrayList<Fruit>();
    }

    float totalWeight(List<? extends Fruit> fruits) {
        float weight = 0;
        for (Fruit fruit : fruits) {
            weight += fruit.getWeight();
        }
        return weight;
    }
}
