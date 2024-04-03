package com.leetcode.solutions.problems;

public class Problem58 {
    public int lengthOfLastWord(String input) {

        final var array = input.split(" ");
        var lastWord = "";

        for (var text : array) {
            lastWord = text;
        }

        return lastWord.length();
    }
}
