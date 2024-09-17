package com.leetcode.solutions.problems;

import com.leetcode.solutions.customStructures.TreeNode;

import java.util.*;

import static java.lang.Math.min;

public class DFS {
    private static final char VISITED = '*';

    public boolean exist(char[][] board, String word) {
        char[] wordArray = word.toCharArray();
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, directions, i, j, wordArray, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int[][] directions, int x, int y, char[] word, int start) {
        if (start == word.length) return true;
        if (x < 0 || y < 0 || x == board.length || y == board[0].length) return false;
        if (board[x][y] == VISITED || board[x][y] != word[start]) return false;

        boolean res = false;
        char currentChar = board[x][y];
        board[x][y] = VISITED;

        if (findPath(board, directions, x, y, word, start, res)) return true;

        board[x][y] = currentChar;
        return false;
    }

    private boolean findPath(char[][] board, int[][] directions, int x, int y, char[] word, int start, boolean result) {
        for (int[] dir : directions) {
            int newRow = x + dir[0], newCol = y + dir[1];
            result |= dfs(board, directions, newRow, newCol, word, start + 1);
            if (result) return true;
        }
        return false;
    }

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
        return min(leftDepth, rightDepth) + 1;
    }

    public int sumNumbers(TreeNode input) {
        return dfs(input, 0);
    }

    private int dfs(TreeNode root, int sum) {
        if (root == null) return 0;

        var total = 10 * sum + root.val;

        if (root.left == null && root.right == null) {
            return total;
        }

        return dfs(root.left, total) + dfs(root.right, total);
    }

    private int y;
    private int x;

    public int numIslands(char[][] grid) {
        int count = 0;
        y = grid.length;
        if (y == 0) return 0;
        x = grid[0].length;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++)
                if (grid[i][j] == '1') {
                    DFSMarking(grid, i, j);
                    ++count;
                }
        }
        return count;
    }

    private void DFSMarking(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= y || j >= x || grid[i][j] != '1') return;
        grid[i][j] = '0';
        DFSMarking(grid, i + 1, j);
        DFSMarking(grid, i - 1, j);
        DFSMarking(grid, i, j + 1);
        DFSMarking(grid, i, j - 1);
    }

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

    public String smallestFromLeaf(TreeNode root) {
        StringBuilder smallest = new StringBuilder();
        dfs(root, new StringBuilder(), smallest);
        return smallest.toString();
    }

    private void dfs(TreeNode node, StringBuilder path, StringBuilder smallest) {
        if (node == null) return;

        path.append((char) ('a' + node.val));

        if (node.left == null && node.right == null) {
            String currentString = path.reverse().toString();
            if (smallest.length() == 0 || currentString.compareTo(smallest.toString()) < 0) {
                smallest.setLength(0);
                smallest.append(currentString);
            }
            path.reverse();
        }

        dfs(node.left, path, smallest);
        dfs(node.right, path, smallest);

        path.setLength(path.length() - 1);
    }

    public int maxDepth(String input) {
        final var chars = input.toCharArray();
        int depth = 0, max = 0;
        for (var character : chars) {
            if (character == '(')
                max = Math.max(max, ++depth);
            if (character == ')')
                depth--;
        }
        return max;
    }

    public int[][] findFarmland(int[][] land) {
        int rows = land.length;
        int cols = land[0].length;
        Set<String> visited = new HashSet<>();
        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (land[i][j] == 1 && !visited.contains(i + "," + j)) {
                    int[] bounds = dfs(land, visited, i, j);
                    result.add(bounds);
                }
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    private int[] dfs(int[][] land, Set<String> visited, int x, int y) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x, y});
        visited.add(x + "," + y);

        int minRow = x, minCol = y;
        int maxRow = x, maxCol = y;

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int currentX = current[0], currentY = current[1];

            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            for (int[] dir : directions) {
                int nx = currentX + dir[0];
                int ny = currentY + dir[1];

                if (nx >= 0 && nx < land.length && ny >= 0 && ny < land[0].length &&
                        land[nx][ny] == 1 && !visited.contains(nx + "," + ny)) {
                    visited.add(nx + "," + ny);
                    stack.push(new int[]{nx, ny});
                    minRow = Math.min(minRow, nx);
                    minCol = Math.min(minCol, ny);
                    maxRow = Math.max(maxRow, nx);
                    maxCol = Math.max(maxCol, ny);
                }
            }
        }

        return new int[]{minRow, minCol, maxRow, maxCol};
    }
}
