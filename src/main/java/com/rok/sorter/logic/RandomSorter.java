package com.rok.sorter.logic;

import com.rok.sorter.model.SortResult;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by roman.kulikov on 5/16/2017.
 * All rights reserved =D
 */
public class RandomSorter {
    private final int length;
    private Double[] numbersAsArray;
    private double min;
    private double max;

    public RandomSorter(Double[] numbersAsArray) {
        this.numbersAsArray = numbersAsArray;
        this.length = numbersAsArray.length;
    }

    public SortResult sort(){
        List<Double> arrayAsList = Arrays.asList(this.numbersAsArray);
        min = Collections.min(arrayAsList);
        max = Collections.max(arrayAsList);
        //in case of really large amounts of numbers better to look min & max manually, both at once
        /*int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (Integer number : numbersAsArray) {
            if (number < min) {
                min = number;
            }
            if (number > max) {
                max = number;
            }
        }*/

        int firstIndex, secondIndex;
        double firstNumber, secondNumber;
        long timeEstimatedNs = System.nanoTime();
        int changesOfPositionsCount = 0;
        Random random = new Random();
        while (!arrayIsSorted()) {
            firstIndex = random.nextInt(length);
            secondIndex = random.nextInt(length);

            if (secondIndex == firstIndex) {
                secondIndex = (firstIndex == length - 1) ? secondIndex - 1 : secondIndex + 1;
            }


            firstNumber = numbersAsArray[firstIndex];
            secondNumber = numbersAsArray[secondIndex];
            boolean firstIndexLessFirstNumberGreater = (firstIndex < secondIndex) && (firstNumber > secondNumber);
            boolean firstIndexGreaterFirstNumberLess = (firstIndex > secondIndex) && (firstNumber < secondNumber);
            if (firstIndexLessFirstNumberGreater || firstIndexGreaterFirstNumberLess) {
                numbersAsArray[firstIndex] = secondNumber;
                numbersAsArray[secondIndex] = firstNumber;
                changesOfPositionsCount++;
            }
        }
        timeEstimatedNs = System.nanoTime() - timeEstimatedNs;

        String timeEstimated = adjustTime(timeEstimatedNs);
        return new SortResult(Arrays.toString(numbersAsArray), changesOfPositionsCount, timeEstimated);
    }

    private String adjustTime(long timeEstimatedNs) {
        if (timeEstimatedNs < 1000000) {
            return timeEstimatedNs + " ns";
        }
        if (timeEstimatedNs >= 1000000 && timeEstimatedNs < 1000000000) {
            return timeEstimatedNs/1000000 + " ms";
        }
        if (timeEstimatedNs >= 1000000000 && timeEstimatedNs < 60000000000L) {
            return timeEstimatedNs/1000000000 + " s";
        }
        if (timeEstimatedNs >= 60000000000L && timeEstimatedNs < 3600000000000L) {
            return timeEstimatedNs/60000000000L + " min";
        }
        return timeEstimatedNs/3600000000000L + " hours";
    }

    private boolean arrayIsSorted() {
        if (this.numbersAsArray[0] != this.min ||
                this.numbersAsArray[this.length - 1] != this.max) {
            return false;
        }

        for (int i = 1; i < this.length - 1; i++) {
            if (this.numbersAsArray[i] < this.numbersAsArray[i - 1]) {
                return false;
            }
        }

        return true;
    }
}
