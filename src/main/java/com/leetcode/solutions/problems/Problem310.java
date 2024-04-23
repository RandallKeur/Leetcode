package com.leetcode.solutions.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return List.of(0);

        final var adjacent = buildTree(n, edges);
        var leaves = buildLeaves(n, adjacent);

        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int i : leaves) {
                int j = adjacent.get(i).iterator().next();
                adjacent.get(j).remove(i);
                if (adjacent.get(j).size() == 1) newLeaves.add(j);
            }
            leaves = newLeaves;
        }
        return leaves;
    }

    private List<Set<Integer>> buildTree(int n, int[][] edges) {
        List<Set<Integer>> adjacent = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) adjacent.add(new HashSet<>());
        for (int[] edge : edges) {
            adjacent.get(edge[0]).add(edge[1]);
            adjacent.get(edge[1]).add(edge[0]);
        }
        return adjacent;
    }

    private List<Integer> buildLeaves(int n, List<Set<Integer>> adjacent) {
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; ++i)
            if (adjacent.get(i).size() == 1) leaves.add(i);
        return leaves;
    }
}
