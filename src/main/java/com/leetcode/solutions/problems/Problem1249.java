package com.leetcode.solutions.problems;

import java.util.Stack;

public class Problem1249 {
    public String minRemoveToMakeValid(String input) {
        final var stack = new Stack<Integer>();
        for(var i = 0; i < input.length(); i++){
            if(input.charAt(i) == '(')
                stack.push(i);
            else if(input.charAt(i)==')'){
                if(!stack.isEmpty() && input.charAt(stack.peek()) == '('){
                    stack.pop();
                }
                else stack.push(i);
            }
        }
        return buildResult(stack, input);
    }

    private String buildResult(Stack<Integer> stack, String input) {
        final var result = new StringBuilder();
        for(var i = input.length()-1; i>=0; i--){
            if(!stack.isEmpty() && stack.peek() == i) {
                stack.pop();
            }
            else result.append(input.charAt(i));
        }
        return result.reverse().toString();
    }
}
