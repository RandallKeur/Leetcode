package com.leetcode.solutions.problems;

public class Problem200 {

    private int y;
    private int x;

    public int numIslands(char[][] grid) {
        int count = 0;
        y = grid.length;
        if (y == 0) return 0;
        x = grid[0].length;
        for (int i = 0; i < y; i++){
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
}
