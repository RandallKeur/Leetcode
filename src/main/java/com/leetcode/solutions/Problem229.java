package com.leetcode.solutions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem229 {
    public List<Integer> majorityElement(Integer[] input) {
        var dictionary = new HashMap<Integer, Integer>();
        var totalInputValues = input.length;
        for (var i : input) {
            if (dictionary.containsKey(i)) {
                dictionary.put(i, dictionary.get(i) + 1);
            }
            else {
                dictionary.put(i, 1);
            }
        }
        return dictionary.entrySet().stream()
                .filter(entry -> entry.getValue() > totalInputValues/3)
                .map(Map.Entry::getKey)
                .toList();
    }
}
