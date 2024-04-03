package com.leetcode.solutions.problems;

import java.util.HashMap;

public class Problem13 {
    public int romanToInt(String s) {
        // Setup
        final var sCharArray = s.toCharArray();
        final var romanDictionary = buildRomanDictionary();
        var runningTotal = 0;
        // Loop
        for (var currentIndex = 0; currentIndex < sCharArray.length; currentIndex++) {
            var nextIndex = currentIndex;
            if (currentIndex != sCharArray.length -1){
                nextIndex = currentIndex + 1;
            }
            // Lookup values
            var currentInteger = romanDictionary.get(sCharArray[currentIndex]);
            var nextInteger = romanDictionary.get(sCharArray[nextIndex]);
            // Handle odd case
            if (nextInteger > currentInteger){
                runningTotal = runningTotal + (nextInteger - currentInteger);
                currentIndex++;
            }
            // Handle normal case
            else {
                runningTotal = runningTotal + currentInteger;
            }
        }

        return runningTotal;
    }

    private static HashMap<Character, Integer> buildRomanDictionary(){
        var dictionary = new HashMap<Character, Integer>();
        dictionary.put('I', 1);
        dictionary.put('V', 5);
        dictionary.put('X', 10);
        dictionary.put('L', 50);
        dictionary.put('C', 100);
        dictionary.put('D', 500);
        dictionary.put('M', 1000);
        return dictionary;
    }
}
