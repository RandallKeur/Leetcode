package com.leetcode.solutions;

public class Problem7 {
    public int reverse(int input) {

        var result = 0;

        while (input != 0) {
            var remainder = input % 10;
            var temp = result * 10 + remainder;
            if (temp / 10 != result)
                return 0;
            result = temp;
            input /= 10;
        }

        return result;
    }
}
