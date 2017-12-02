package com.sheepdogdynamics.knapsack;

import java.util.ArrayList;

/**
 * Created by Nick on 12/1/2017.
 */
public class Knapsack01 {
    private int[][] grid;
    private Item[] items;
    private int capacity;

    ArrayList<Item> solution = new ArrayList<>();

    public Knapsack01(Item[] initItems, int initCapacity)
    {
        items = initItems;
        capacity = initCapacity;
    }

    public String knapsack()
    {
        grid = new int[items.length][capacity + 1];

        for(int itemIndex = 0; itemIndex < items.length; ++itemIndex)
        {
            for(int currentWeightCapacity = 0; currentWeightCapacity < capacity + 1; ++currentWeightCapacity)
            {
//                // The getRowIndex and getColIndex calls for the rows and cols of the grid ensure that no out of
                  //  bounds exceptions will occur on the processing of the first row, and allows it to be one loop
                grid[itemIndex][currentWeightCapacity] =
                        (currentWeightCapacity >= items[itemIndex].getWeight())         ?
                        Math.max( items[itemIndex].getValue() + grid[getRowIndex(itemIndex)][getColIndex(itemIndex, currentWeightCapacity)],
                                  grid[getRowIndex(itemIndex)][currentWeightCapacity] ) :
                        grid[getRowIndex(itemIndex)][currentWeightCapacity];
            }
        }

        return getSolution();
    }

    private int getRowIndex(int itemIndex) { return (itemIndex - 1) < 0 ? itemIndex : itemIndex - 1; }

    private int getColIndex(int itemIndex, int currentWeightCapacity) { return (itemIndex - 1 ) < 0 ? currentWeightCapacity : currentWeightCapacity - items[itemIndex].getWeight(); }

    private String getSolution()
    {
        solution.clear();
        int currentColumn = capacity;
        int currentRow = items.length - 1;
        while(currentColumn != 0)
        {
            // Check if the above element is different
            if(currentRow == 0 || grid[currentRow][currentColumn] != grid[currentRow - 1][currentColumn])
            {
                // If it is then the item at that row is part of the solution
                if(items[currentRow].getWeight() <= capacity)  solution.add(items[currentRow]);
                // Or if we're at the top row already, then the top row's item is also in the solution, set currentColumn
                //  to 0 to quit
                currentColumn = (currentRow == 0) ? 0 : currentColumn - items[currentRow].getWeight();
            }
            if(currentRow != 0) --currentRow;
        }
        return getStringFromSolutionList();
    }

    private String getStringFromSolutionList()
    {
        StringBuilder builder = new StringBuilder();
        if(!solution.isEmpty())
            for(Item item : solution)
                builder.append(item.toString() + "\n");
        else
            builder.append("NO ITEMS IN SOLUTION");
        return builder.toString();
    }


}
