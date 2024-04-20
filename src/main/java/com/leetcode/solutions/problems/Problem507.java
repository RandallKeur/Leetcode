package com.leetcode.solutions.problems;

import java.util.HashSet;

public class Problem507 {
    public boolean checkPerfectNumber(Integer input) {
        if (input == 1)
            return false;

        final var set = buildSetOfDivisors(input);

        final var sum = set.stream().reduce(0, Integer::sum);
        return sum.equals(input);
    }

    private HashSet<Integer> buildSetOfDivisors(Integer input) {
        final var set = new HashSet<Integer>() {
        };
        set.add(1);

        var iterator = 2;
        while (iterator <= Math.sqrt(input)) {
            if (input % iterator == 0) {
                set.add(iterator);
                set.add(input / iterator);
            }
            iterator++;
        }
        return set;
    }
}
