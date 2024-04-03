package com.leetcode.solutions.problems;

import java.util.Arrays;

public class Problem2578 {
    public int splitNum(int num) {
        char[] chars = Integer.toString(num).toCharArray();
        Arrays.sort(chars);
        int[] arr = {0, 0};
        for (int i = 0; i < chars.length; ++i) {
            arr[i % 2] *= 10;
            arr[i % 2] += chars[i] - '0';
        }
        return Arrays.stream(arr).sum();
    }
}
