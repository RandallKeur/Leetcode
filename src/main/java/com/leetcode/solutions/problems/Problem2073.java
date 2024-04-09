package com.leetcode.solutions.problems;

public class Problem2073 {
    public int timeRequiredToBuy(int[] tickets, int position) {
        var time = 0;

        for (var i = 0; i < tickets.length; i++) {
            if (i <= position) {
                time += Math.min(tickets[i], tickets[position]);
            } else {
                time += Math.min(tickets[i], tickets[position] - 1);
            }
        }
        return time;
    }
}
