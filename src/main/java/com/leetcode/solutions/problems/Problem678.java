package com.leetcode.solutions.problems;

public class Problem678 {
    public Boolean checkValidString(String input) {
        int min = 0, max = 0;
        for (var letter : input.toCharArray()) {
            if (letter == '(') {
                min++;
                max++;
            } else if (letter == ')') {
                min--;
                max--;
            } else if (letter == '*') {
                min--;
                max++;
            }
            if (max < 0)
                return false;

            min = Math.max(min, 0);
        }
        return min == 0;
    }
}
