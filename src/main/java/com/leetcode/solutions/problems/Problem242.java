package com.leetcode.solutions.problems;

import java.util.HashMap;

public class Problem242 {


    public boolean isAnagram(String firstWord, String secondWord) {
        var dictionary = new HashMap<Character, Integer>();
        countUpLetters(dictionary, firstWord.toLowerCase());
        countDownLetters(dictionary, secondWord.toLowerCase());
        return determineAnagram(dictionary);
    }


    private boolean determineAnagram(HashMap<Character, Integer> dictionary) {
        for (Integer value : dictionary.values()) {
            if (value != 0) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    private void countUpLetters(HashMap<Character, Integer> dictionary, String firstWord) {
        for (char letter : firstWord.toCharArray()) {
            dictionary.put(letter, dictionary.getOrDefault(letter, 0) + 1);
        }
    }

    private void countDownLetters(HashMap<Character, Integer> dictionary, String secondWord) {
        for (char letter : secondWord.toCharArray()) {
            dictionary.put(letter, dictionary.getOrDefault(letter, 0) - 1);
        }
    }
}
