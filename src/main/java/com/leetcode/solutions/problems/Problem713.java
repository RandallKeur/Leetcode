package com.leetcode.solutions.problems;

public class Problem713 {
    public int numSubarrayProductLessThanK(int[] nums, int max) {
        if (max <= 1)
            return 0;

        int left = 0, right = 0, count = 0, product = 1;

        while (right < nums.length) {
            product *= nums[right];
            while (product >= max) {
                product /= nums[left++];
            }
            count += 1 + (right - left);
            right++;
        }

        return count;
    }
}
