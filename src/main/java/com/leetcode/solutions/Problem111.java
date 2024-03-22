package com.leetcode.solutions;

import com.leetcode.solutions.CustomStructures.TreeNode;

public class Problem111 {

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

        // If the left tree is empty, return depth of the right.
        if (root.left == null)
            return rightDepth + 1;

        // If the right tree is empty, return depth of the left.
        if (root.right == null)
            return leftDepth + 1;

        // Return the minimum of the depths, adding 1 to account for the current node
        return Math.min(leftDepth, rightDepth) + 1;
    }
}
