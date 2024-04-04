package com.leetcode.solutions.problems;

public class Problem1614 {
    public int maxDepth(String input) {
        final var chars = input.toCharArray();
        int depth = 0, max = 0;
        for (var character : chars) {
            if (character == '(')
                max = Math.max(max, ++depth);
            if (character == ')')
                depth--;
        }
        return max;
    }
}
