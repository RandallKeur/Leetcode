package com.leetcode.solutions.problems;

import com.leetcode.solutions.customStructures.TreeNode;

public class Problem129 {

    public int sumNumbers(TreeNode input) {
        return DFS(input, 0);
    }

    private int DFS(TreeNode root, int sum) {
        if (root == null) return 0;

        var total = 10 * sum + root.val;

        if (root.left == null && root.right == null) {
            return total;
        }

        return DFS(root.left, total) + DFS(root.right, total);
    }
}
