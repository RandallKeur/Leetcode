package com.leetcode.solutions;

import java.util.Stack;
import java.util.stream.Collectors;

public class Problem1047 {

    public String removeDuplicates(String s) {
        var resultStack = new Stack<Character>();
        var sCharArray = s.toCharArray();
        for (char c : sCharArray) {
            if (resultStack.empty()
            ) {
                resultStack.push(c);
            } else if (resultStack.peek() == c) {
                resultStack.pop();
            } else {
                resultStack.push(c);
            }
        }
        return convertStackToString(resultStack);
    }

    private String convertStackToString(Stack<Character> input){
        return input.stream().map(Object::toString).collect(Collectors.joining(""));
    }

    public String removeDuplicatesRecursion(String s) {

        var inputAsCharArray = s.toCharArray();
        var i = 0;

        while (i < inputAsCharArray.length -1) {
            if (inputAsCharArray[i] == inputAsCharArray[i+1]) {
                var newString = buildNewString(i, s);
                return removeDuplicatesRecursion(newString);
            }
            else i++;
        }

        return s;
    }

    private String buildNewString(Integer index, String s){
        if (index == 0){
            return s.substring(2);
        }
        if (index + 2 > s.length()) {
            return s.substring(0,index);
        }
        var left = s.substring(0,index);
        var right = s.substring(index+2);
        return left.concat(right);
    }
}
