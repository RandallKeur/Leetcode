package com.leetcode.solutions.problems;

import java.util.Stack;

public class Problem20 {
    public Boolean isValid(String input) {
        var stack = new Stack<Character>();
        for (var character : input.toCharArray())
        {
            if (character == '(')
                stack.push(')');
            else if (character == '[')
                stack.push(']');
            else if (character == '{')
                stack.push('}');
            else if (stack.empty() || stack.pop() != character)
                return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
