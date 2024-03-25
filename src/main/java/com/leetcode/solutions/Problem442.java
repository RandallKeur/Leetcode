package com.leetcode.solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Problem442 {
    public List<Integer> findDuplicates(int[] input) {

        final var dictionary = new HashSet<Integer>();
        final var duplicates = new ArrayList<Integer>();

        for (int i : input) {
            if (dictionary.contains(i))
                duplicates.add(i);
            else
                dictionary.add(i);
        }

        return duplicates;
    }
}
