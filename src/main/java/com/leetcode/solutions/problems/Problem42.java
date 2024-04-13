package com.leetcode.solutions.problems;

public class Problem42 {
    public int trap(int[] height) {
        int leftPeak = 0, rightPeak = height.length - 1, leftMax = 0, rightMax = 0, totalWater = 0;
        while (leftPeak < rightPeak) {
            if (height[leftPeak] < height[rightPeak]) {
                if (height[leftPeak] >= leftMax) {
                    leftMax = height[leftPeak];
                } else {
                    totalWater += leftMax - height[leftPeak];
                }
                leftPeak++;
            } else {
                if (height[rightPeak] >= rightMax) {
                    rightMax = height[rightPeak];
                } else {
                    totalWater += rightMax - height[rightPeak];
                }
                rightPeak--;
            }
        }
        return totalWater;
    }
}
