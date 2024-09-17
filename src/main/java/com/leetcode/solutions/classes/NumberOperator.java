package com.leetcode.solutions.classes;

import java.util.*;

public class NumberOperator {
    public int reverse(int input) {

        var result = 0;

        while (input != 0) {
            var remainder = input % 10;
            var temp = result * 10 + remainder;
            if (temp / 10 != result)
                return 0;
            result = temp;
            input /= 10;
        }

        return result;
    }

    public boolean isPalindrome(int input) {
        if (input < 0) {
            return Boolean.FALSE;
        }

        long reversedNumber = 0L;
        long temp = input;

        while (temp != 0) {
            int remainder = (int) (temp % 10);
            reversedNumber = reversedNumber * 10 + remainder;
            temp /= 10;
        }

        return (reversedNumber == input);
    }

    public int firstMissingPositive(int[] numbers) {
        orderList(numbers);
        return firstMissingPositiveInOrderedList(numbers);
    }

    private void orderList(int[] numbers) {
        int i = 0;
        while (i < numbers.length) {
            if (numbers[i] == i + 1 || numbers[i] <= 0 || numbers[i] > numbers.length) {
                i++;
            } else if (numbers[numbers[i] - 1] != numbers[i]) {
                swap(numbers, i, numbers[i] - 1);
            } else i++;
        }
    }

    private void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    private int firstMissingPositiveInOrderedList(int[] numbers) {
        int i = 0;
        while (i < numbers.length && numbers[i] == i + 1) {
            i++;
        }
        return i + 1;
    }

    public Integer singleNumber(Integer[] nums) {

        var dictionary = new HashMap<Integer, Integer>();

        for (var num : nums) {
            if (dictionary.get(num) == null)
                dictionary.put(num, 1);
            else
                dictionary.remove(num);
        }

        final var firstKey = dictionary.keySet().stream().findFirst();
        return firstKey.orElse(-1);
    }

    public List<Integer> majorityElement(Integer[] input) {
        var dictionary = new HashMap<Integer, Integer>();
        var totalInputValues = input.length;
        for (var i : input) {
            if (dictionary.containsKey(i)) {
                dictionary.put(i, dictionary.get(i) + 1);
            } else {
                dictionary.put(i, 1);
            }
        }
        return dictionary.entrySet().stream()
                .filter(entry -> entry.getValue() > totalInputValues / 3)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<Integer> findDuplicates(int[] input) {

        final var dictionary = new HashSet<Integer>();
        final var duplicates = new ArrayList<Integer>();

        for (int i : input) {
            if (dictionary.contains(i))
                duplicates.add(i);
            else
                dictionary.add(i);
        }

        return duplicates;
    }

    public boolean checkPerfectNumber(Integer input) {
        if (input == 1)
            return false;

        final var set = buildSetOfDivisors(input);

        final var sum = set.stream().reduce(0, Integer::sum);
        return sum.equals(input);
    }

    private HashSet<Integer> buildSetOfDivisors(Integer input) {
        final var set = new HashSet<Integer>() {
        };
        set.add(1);

        var iterator = 2;
        while (iterator <= Math.sqrt(input)) {
            if (input % iterator == 0) {
                set.add(iterator);
                set.add(input / iterator);
            }
            iterator++;
        }
        return set;
    }

    public int numSubarrayProductLessThanK(int[] nums, int max) {
        if (max <= 1)
            return 0;

        int left = 0, right = 0, count = 0, product = 1;

        while (right < nums.length) {
            product *= nums[right];
            while (product >= max) {
                product /= nums[left++];
            }
            count += 1 + (right - left);
            right++;
        }

        return count;
    }

    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[nums.length];
        var i = 0;
        var j = 0;

        while (n < nums.length) {
            result[j++] = nums[i++];
            result[j++] = nums[n++];
        }
        return result;
    }

    public int splitNum(int num) {
        char[] chars = Integer.toString(num).toCharArray();
        Arrays.sort(chars);
        int[] arr = {0, 0};
        for (int i = 0; i < chars.length; ++i) {
            arr[i % 2] *= 10;
            arr[i % 2] += chars[i] - '0';
        }
        return Arrays.stream(arr).sum();
    }

    public int maxSubarrayLength(int[] nums, int max) {
        var dictionary = new HashMap<Integer, Integer>();
        int left = 0, result = 0;

        for (var right = 0; right < nums.length; right++) {
            var rightKey = nums[right];
            var rightValue = dictionary.getOrDefault(rightKey, 0);
            dictionary.put(rightKey, rightValue + 1);
            while (dictionary.get(rightKey) > max) {
                var leftKey = nums[left];
                var leftValue = dictionary.get(leftKey);
                dictionary.put(leftKey, leftValue - 1);
                left++;
            }
            result = Math.max(result, right - left + 1);
        }

        return result;
    }

    public boolean isFascinating(int n) {

        //handle number too large
        if (n > 333)
            return false;

        //concat string
        final var concatenatedString = buildConcatenatedString(n);

        //check if a zero exists in the input
        if (String.format("%s", concatenatedString).contains("0"))
            return false;

        return isFascinatingString(concatenatedString);
    }

    private boolean isFascinatingString(String concatenatedString) {
        //check for duplication
        var duplicateArray = new HashSet<>();
        for (char num : concatenatedString.toCharArray()) {
            if (duplicateArray.contains(num))
                return false;
            else
                duplicateArray.add(num);
        }

        return true;
    }

    private String buildConcatenatedString(int n) {
        final var secondNumber = 2 * n;
        final var thirdNumber = 3 * n;
        return String.format("%s%s%s", n, secondNumber, thirdNumber);
    }
}
