package com.sheepdogdynamics;

import com.sheepdogdynamics.fibonacci.Fibonacci;
import com.sheepdogdynamics.knapsack.Item;
import com.sheepdogdynamics.knapsack.Knapsack01;

public class Main {

    public static void main(String[] args) {
        System.out.println(Fibonacci.numberAtPosition(5));
        System.out.println(Fibonacci.numberAtPosition(8));
        System.out.println(Fibonacci.numberAtPosition(2));

        // 1 1, 3 4, 4 5, 5 7
        Item eggs = new Item("Eggs", 2, 25);
        Item sword = new Item("Sword", 3, 6);
        Item mug = new Item("Mug",6, 2);
        Item pants = new Item("Pants", 1, 7);

        Knapsack01 sack = new Knapsack01(new Item[] { eggs, sword, mug, pants }, 7);

        System.out.println(sack.knapsack());

    }
}
