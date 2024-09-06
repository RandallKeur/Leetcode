package com.leetcode.solutions.problems;

public class Problem1470 {
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[nums.length];
        var i = 0;
        var j = 0;

        while (n < nums.length) {
            result[j++] = nums[i++];
            result[j++] = nums[n++];
        }
        return result;
    }
}
