package com.leetcode.solutions.problems;

import static java.lang.Math.abs;

public class Problem3110 {

    public int scoreOfString(String input) {
        var score = 0;
        for (var i = 0; i < input.length() - 1; i++) {
            score += abs((int) input.charAt(i) - (int) input.charAt(i+1));
        }
        return score;
    }
}
