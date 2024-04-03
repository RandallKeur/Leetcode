package com.leetcode.solutions.problems;

import java.util.HashMap;

public class Problem2958 {
    public int maxSubarrayLength(int[] nums, int max) {
        var dictionary = new HashMap<Integer, Integer>();
        int left = 0, result = 0;

        for (var right = 0; right < nums.length; right++) {
            var rightKey = nums[right];
            var rightValue = dictionary.getOrDefault(rightKey, 0);
            dictionary.put(rightKey, rightValue + 1);
            while (dictionary.get(rightKey) > max) {
                var leftKey = nums[left];
                var leftValue = dictionary.get(leftKey);
                dictionary.put(leftKey, leftValue - 1);
                left++;
            }
            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}
