package com.leetcode.solutions.problems;

public class Problem41 {
    public int firstMissingPositive(int[] numbers) {
        orderList(numbers);
        return firstMissingPositiveInOrderedList(numbers);
    }

    private void orderList(int[] numbers) {
        int i = 0;
        while(i < numbers.length){
            if(numbers[i] == i+1 || numbers[i] <= 0 || numbers[i] > numbers.length) {
                i++;
            }
            else if(numbers[numbers[i]-1] != numbers[i]) {
                swap(numbers, i, numbers[i] - 1);
            }
            else i++;
        }
    }

    private void swap(int[] numbers, int i, int j){
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    private int firstMissingPositiveInOrderedList(int[] numbers) {
        int i = 0;
        while(i < numbers.length && numbers[i] == i+1) {
            i++;
        }
        return i+1;
    }
}
