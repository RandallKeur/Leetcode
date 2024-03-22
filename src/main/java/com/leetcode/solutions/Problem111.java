package com.leetcode.solutions;

import com.leetcode.solutions.CustomStructures.TreeNode;

public class Problem111 {

    private int depth = 1;
    private int minDepth = 1;

    public int minDepth(TreeNode root) {

        // Empty root
        if (root == null)
            return 0;

        // Explore the left node
        var leftDepth = minDepth(root.left);
        // Explore the right node
        var rightDepth = minDepth(root.right);

        // Detect if the node is a leaf
        if (root.right == null && root.left == null) {
            return 1;
        }

        if (root.left == null)
            return rightDepth + 1;

        if (root.right == null)
            return leftDepth + 1;

        return Math.min(leftDepth, rightDepth) + 1;
    }
}
