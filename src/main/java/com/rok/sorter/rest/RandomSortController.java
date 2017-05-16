package com.rok.sorter.rest;

import org.springframework.web.bind.annotation.*;

import java.util.*;


/**
 * Created by roman.kulikov on 5/16/2017.
 * All rights reserved =D
 */

@RestController
public class RandomSortController {

    @RequestMapping(value = "/eval/{numbers}", method = RequestMethod.GET)
    @ResponseBody
    public String eval(@PathVariable List<Double> numbers) {

        int length = numbers.size();
        Random random = new Random();
        int changesOfPositionsCount = 0;
        Double[] numbersAsArray = new Double[length];
        numbersAsArray = numbers.toArray(numbersAsArray);

        double min = Collections.min(numbers);
        double max = Collections.max(numbers);
        System.out.println(min + ", " + max);
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

        while (!arrayIsSorted(numbersAsArray, min, max)) {
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
        
        return Arrays.toString(numbersAsArray) + "; count: " + changesOfPositionsCount;
    }

    private boolean arrayIsSorted(Double[] numbersAsArray, double min, double max) {
        int length = numbersAsArray.length;
        if (numbersAsArray[0] != min || numbersAsArray[length - 1] != max) {
            return false;
        }

        for (int i = 1; i < length - 1; i++) {
            if (numbersAsArray[i] < numbersAsArray[i - 1]) {
                return false;
            }
        }

        return true;
    }
}
