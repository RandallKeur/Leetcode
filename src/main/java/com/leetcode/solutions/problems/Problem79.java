package com.leetcode.solutions.problems;

public class Problem79 {

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
}
