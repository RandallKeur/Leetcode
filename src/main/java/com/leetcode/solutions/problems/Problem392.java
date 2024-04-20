package com.leetcode.solutions.problems;

public class Problem392 {
    public Boolean isSubsequence(String subsequence, String stringToCheck) {
        var subsequenceCharArray = subsequence.toCharArray();
        var startingIndex = 0;
        var newIndex = 0;
        for (char c : subsequenceCharArray) {
            if (stringToCheck.length() < startingIndex + 1) {
                return false;
            }
            newIndex = stringToCheck.indexOf(c, startingIndex);
            if (newIndex == -1) {
                return false;
            }
            startingIndex = newIndex + 1;
        }
        return true;
    }

    public Boolean isSubsequenceVersion2(String subsequence, String stringToCheck) {
        var subsequenceCharArray = subsequence.toCharArray();
        for (char c : subsequenceCharArray) {
            var indexOfCharacter = stringToCheck.indexOf(c);
            if (indexOfCharacter == -1) {
                return false;
            }
            stringToCheck = stringToCheck.substring(indexOfCharacter + 1);
        }
        return true;
    }
}
