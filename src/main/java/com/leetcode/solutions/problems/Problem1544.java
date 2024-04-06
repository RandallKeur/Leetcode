package com.leetcode.solutions.problems;

import java.util.Stack;

public class Problem1544 {

    public String makeGood(String s) {

        final var CHAR_CONSTANT = 32;

        Stack<Character> stack = new Stack<>();

        for (char character : s.toCharArray()) {
            if (!stack.isEmpty() && Math.abs(character - stack.peek()) == CHAR_CONSTANT) {
                stack.pop();
            } else {
                stack.push(character);
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }

        return result.toString();
    }
}
