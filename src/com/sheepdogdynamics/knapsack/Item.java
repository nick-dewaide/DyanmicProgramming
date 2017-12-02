package com.sheepdogdynamics.knapsack;

/**
 * Created by Nick on 12/1/2017.
 */
public class Item {

    private String name;
    private int weight;
    private int value;

    public Item(String initName, int initWeight, int initValue)
    {
        name = initName;
        weight = initWeight;
        value = initValue;
    }

    @Override
    public String toString()
    {
        return name + " weight: " + weight + ", " + name + " value: " + value;
    }

    public int getWeight() { return weight; }
    public int getValue() { return value; }
}
