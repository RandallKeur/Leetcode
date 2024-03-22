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
        if (root.left != null){
            depth++;
            minDepth(root.left);
        }
        // Explore the right node
        if (root.right != null){
            depth++;
            minDepth(root.right);
        }

        // Detect if the node is a leaf
        if (root.right == null && root.left == null) {
            if (depth < minDepth){
                minDepth = depth;
                depth--;
            }
            return minDepth;
        }

        return minDepth;
    }
}
