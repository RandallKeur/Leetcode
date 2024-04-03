package com.leetcode.solutions.problems;

import java.util.HashSet;

public class Problem2729 {
    public boolean isFascinating(int n) {

        //handle number too large
        if (n > 333)
            return false;

        //concat string
        final var concatenatedString = buildConcatenatedString(n);

        //check if a zero exists in the input
        if (String.format("%s", concatenatedString).contains("0"))
            return false;

        return isFascinatingString(concatenatedString);
    }

    private boolean isFascinatingString(String concatenatedString) {
        //check for duplication
        var duplicateArray = new HashSet<>();
        for (char num : concatenatedString.toCharArray()){
            if (duplicateArray.contains(num))
                return false;
            else
                duplicateArray.add(num);
        }

        return true;
    }

    private String buildConcatenatedString(int n){
        final var secondNumber = 2 * n;
        final var thirdNumber = 3 * n;
        return String.format("%s%s%s", n, secondNumber, thirdNumber);
    }
}
