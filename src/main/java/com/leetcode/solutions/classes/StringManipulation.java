package com.leetcode.solutions.classes;

import java.util.*;
import java.util.stream.Collectors;

public class StringManipulation {
    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }

    public String convertToZigZag(String input, int numberOfRows) {
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
                    diagonalDiff = columnDiff - 2 * i;
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

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String prefix = strs[0];
        for (String s : strs)
            while (s.indexOf(prefix) != 0)
                prefix = prefix.substring(0, prefix.length() - 1);
        return prefix;
    }

    public Boolean isValid(String input) {
        var stack = new Stack<Character>();
        for (var character : input.toCharArray()) {
            if (character == '(')
                stack.push(')');
            else if (character == '[')
                stack.push(']');
            else if (character == '{')
                stack.push('}');
            else if (stack.empty() || stack.pop() != character)
                return Boolean.FALSE;
        }
        return stack.isEmpty();
    }

    public int lengthOfLastWord(String input) {

        final var array = input.split(" ");
        var lastWord = "";

        for (var text : array) {
            lastWord = text;
        }

        return lastWord.length();
    }

    public boolean isIsomorphic(String input1, String input2) {

        var map = new HashMap<Character, Character>();
        var length = input1.length();

        for (var i = 0; i < length; i++) {
            var record = map.get(input1.charAt(i));
            var valueExists = map.containsValue(input2.charAt(i));
            if (record == null) {
                if (valueExists) return Boolean.FALSE;
                map.put(input1.charAt(i), input2.charAt(i));
            } else {
                if (!record.equals(input2.charAt(i)))
                    return Boolean.FALSE;
            }
        }

        return Boolean.TRUE;
    }

    public boolean isAnagram(String firstWord, String secondWord) {
        var dictionary = new HashMap<Character, Integer>();
        countUpLetters(dictionary, firstWord.toLowerCase());
        countDownLetters(dictionary, secondWord.toLowerCase());
        return determineAnagram(dictionary);
    }


    private boolean determineAnagram(HashMap<Character, Integer> dictionary) {
        for (Integer value : dictionary.values()) {
            if (value != 0) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    private void countUpLetters(HashMap<Character, Integer> dictionary, String firstWord) {
        for (char letter : firstWord.toCharArray()) {
            var currentCount = dictionary.getOrDefault(letter, 0);
            dictionary.put(letter, currentCount + 1);
        }
    }

    private void countDownLetters(HashMap<Character, Integer> dictionary, String secondWord) {
        for (char letter : secondWord.toCharArray()) {
            var currentCount = dictionary.getOrDefault(letter, 0);
            dictionary.put(letter, currentCount - 1);
        }
    }

    public Boolean isSubsequence(String subsequence, String stringToCheck) {
        var subsequenceCharArray = subsequence.toCharArray();
        var startingIndex = 0;
        var newIndex = 0;
        for (char c : subsequenceCharArray) {
            if (stringToCheck.length() < startingIndex + 1) {
                return false;
            }
            newIndex = stringToCheck.indexOf(c, startingIndex);
            if (newIndex == -1) {
                return false;
            }
            startingIndex = newIndex + 1;
        }
        return true;
    }

    public Boolean isSubsequenceV2(String subsequence, String stringToCheck) {
        var subsequenceCharArray = subsequence.toCharArray();
        for (char c : subsequenceCharArray) {
            var indexOfCharacter = stringToCheck.indexOf(c);
            if (indexOfCharacter == -1) {
                return false;
            }
            stringToCheck = stringToCheck.substring(indexOfCharacter + 1);
        }
        return true;
    }

    public boolean repeatedSubstringPattern(String s) {
        final var charArray = s.toCharArray();
        var workingString = new StringBuilder();
        var repeats = 0;
        var stringToTest = "";
        final var stringLength = s.length();
        if (s.length() == 1) {
            return Boolean.FALSE;
        }
        for (char c : charArray) {
            workingString.append(c);

            if (stringLength % workingString.length() != 0)
                continue;

            if (workingString.length() > stringLength / 2)
                return false;

            repeats = stringLength / workingString.length();
            stringToTest = workingString.toString().repeat(repeats);
            if (stringToTest.equals(s))
                return true;
        }
        return false;
    }

    public Boolean checkValidString(String input) {
        int min = 0, max = 0;
        for (var letter : input.toCharArray()) {
            if (letter == '(') {
                min++;
                max++;
            } else if (letter == ')') {
                min--;
                max--;
            } else if (letter == '*') {
                min--;
                max++;
            }
            if (max < 0)
                return false;

            min = Math.max(min, 0);
        }
        return min == 0;
    }

    public String removeDuplicates(String s) {
        var resultStack = new Stack<Character>();
        var sCharArray = s.toCharArray();
        for (char c : sCharArray) {
            if (resultStack.empty()
            ) {
                resultStack.push(c);
            } else if (resultStack.peek() == c) {
                resultStack.pop();
            } else {
                resultStack.push(c);
            }
        }
        return convertStackToString(resultStack);
    }

    private String convertStackToString(Stack<Character> input) {
        return input.stream().map(Object::toString).collect(Collectors.joining(""));
    }

    public String removeDuplicatesRecursion(String s) {

        var inputAsCharArray = s.toCharArray();
        var i = 0;

        while (i < inputAsCharArray.length - 1) {
            if (inputAsCharArray[i] == inputAsCharArray[i + 1]) {
                var newString = buildNewString(i, s);
                return removeDuplicatesRecursion(newString);
            } else i++;
        }

        return s;
    }

    private String buildNewString(Integer index, String s) {
        if (index == 0) {
            return s.substring(2);
        }
        if (index + 2 > s.length()) {
            return s.substring(0, index);
        }
        var left = s.substring(0, index);
        var right = s.substring(index + 2);
        return left.concat(right);
    }

    public String minRemoveToMakeValid(String input) {
        final var stack = new Stack<Integer>();
        for (var i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(')
                stack.push(i);
            else if (input.charAt(i) == ')') {
                if (!stack.isEmpty() && input.charAt(stack.peek()) == '(') {
                    stack.pop();
                } else stack.push(i);
            }
        }
        return buildResult(stack, input);
    }

    private String buildResult(Stack<Integer> stack, String input) {
        final var result = new StringBuilder();
        for (var i = input.length() - 1; i >= 0; i--) {
            if (!stack.isEmpty() && stack.peek() == i) {
                stack.pop();
            } else result.append(input.charAt(i));
        }
        return result.reverse().toString();
    }

    public String makeGood(String s) {

        final var CHAR_CONSTANT = 32;

        Stack<Character> stack = new Stack<>();

        for (char character : s.toCharArray()) {
            if (!stack.isEmpty() && Math.abs(character - stack.peek()) == CHAR_CONSTANT) {
                stack.pop();
            } else {
                stack.push(character);
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }

        return result.toString();
    }

    public int minimizedStringLength(String s) {
        return buildUniqueCharacterSet(s).size();
    }

    private HashSet<Character> buildUniqueCharacterSet(String s) {
        var inputAsCharArray = s.toCharArray();
        var uniqueChars = new HashSet<Character>();
        for (char c : inputAsCharArray) {
            uniqueChars.add(c);
        }
        return uniqueChars;
    }

    public int minimizedStringLengthWithoutAdjacentRepeatingCharacters(String s) {
        var inputAsCharArray = s.toCharArray();
        var returnList = buildUniqueAdjacentCharacterList(inputAsCharArray);
        return returnList.size();
    }

    private ArrayList<Character> buildUniqueAdjacentCharacterList(char[] input) {
        var resultList = new ArrayList<Character>();
        resultList.add(input[0]);
        var i = 1;
        var previousCharacter = input[0];

        while (i < input.length) {
            if (input[i] != previousCharacter) {
                resultList.add(input[i]);
                previousCharacter = input[i];
            }
            i++;
        }

        return resultList;
    }

    public int scoreOfString(String input) {
        var score = 0;
        for (var i = 0; i < input.length() - 1; i++) {
            score += Math.abs(getAsciiValue(input.charAt(i)) - getAsciiValue(input.charAt(i + 1)));
        }
        return score;
    }

    private int getAsciiValue(char character) {
        return character;
    }

    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < words.length; i++){
            if(words[i].indexOf(x) != -1) {
                result.add(i);
            }
        }
        return result;
    }
}
