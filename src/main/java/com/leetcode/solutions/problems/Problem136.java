package com.leetcode.solutions.problems;

import java.util.HashMap;

public class Problem136 {

    public Integer singleNumber(Integer[] nums) {

        var dictionary = new HashMap<Integer, Integer>();

        for (var num : nums) {
            if (dictionary.get(num) == null)
                dictionary.put(num, 1);
            else
                dictionary.remove(num);
        }

        final var firstKey = dictionary.keySet().stream().findFirst();
        return firstKey.orElse(-1);
    }
}
