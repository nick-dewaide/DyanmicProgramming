package com.sheepdogdynamics.fibonacci;

import java.util.ArrayList;

/**
 * Created by Gladys on 12/1/2017.
 */
public class Fibonacci {
    private static ArrayList<Integer> currentSequence = new ArrayList<>();

    /**
     * Dynamic programming solution to finding a particular position of the fibonacci sequence, memoizes previous
     *  calculations, will retrieve previously calculated positions without calculating them again
     *
     * @param position - the desired position of the fibonacci sequence to find
     * @return fibonacci number at specified position, -1 if position is <= 0
     */
    public static int numberAtPosition(int position) {
        if(position < 1) { return -1; }

        if (currentSequence.isEmpty()) {
            currentSequence.add(1);
            currentSequence.add(1);
        }

        if (position <= currentSequence.size())
        {
            return currentSequence.get(position - 1);
        }
        else
        {
            for(int index = currentSequence.size(); index < position; ++index) {
                currentSequence.add(currentSequence.get(currentSequence.size() - 1 ) +
                                    currentSequence.get(currentSequence.size() - 2));
            }
        }
        return currentSequence.get(position - 1);


    }
}
