package com.leetcode.solutions.problems;

public class Problem6 {
    public String convert(String input, int numberOfRows) {
        if (numberOfRows == 1)
            return input;

        StringBuilder result = new StringBuilder();
        int length = input.length();
        int columnDiff = 2 * (numberOfRows - 1);
        int diagonalDiff, diagonalIndex, columnIndex;
        for (int i = 0; i < numberOfRows; i++) {
            columnIndex = i;

            while (columnIndex < length) {
                result.append(input.charAt(columnIndex));
                if (i != 0 && i != numberOfRows - 1) {
                    diagonalDiff = columnDiff -2*i;
                    diagonalIndex = columnIndex + diagonalDiff;

                    if (diagonalIndex < length) {
                        result.append(input.charAt(diagonalIndex));
                    }
                }
                columnIndex += columnDiff;
            }
        }

        return result.toString();
    }
}
