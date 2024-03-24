package com.leetcode.solutions;

public class Problem9 {

    public boolean isPalindrome(int input) {
        if (input < 0) {
            return Boolean.FALSE;
        }

        long reversedNumber = 0L;
        long temp = input;

        while (temp != 0) {
            int remainder = (int) (temp % 10);
            reversedNumber = reversedNumber * 10 + remainder;
            temp /= 10;
        }

        return (reversedNumber == input);
    }
}
