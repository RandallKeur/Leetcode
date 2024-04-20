package com.leetcode.solutions.problems;

public class Problem459 {

    public boolean repeatedSubstringPattern(String s) {
        final var charArray = s.toCharArray();
        var workingString = new StringBuilder();
        var repeats = 0;
        var stringToTest = "";
        final var stringLength = s.length();
        if (s.length() == 1) {
            return Boolean.FALSE;
        }
        for (char c : charArray) {
            workingString.append(c);

            if (stringLength % workingString.length() != 0)
                continue;

            if (workingString.length() > stringLength / 2)
                return false;

            repeats = stringLength / workingString.length();
            stringToTest = workingString.toString().repeat(repeats);
            if (stringToTest.equals(s))
                return true;
        }
        return false;
    }
}
