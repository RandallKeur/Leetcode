package com.leetcode.solutions;

import java.util.ArrayList;
import java.util.HashSet;

public class Problem2716 {
    public int minimizedStringLength(String s) {
        return buildUniqueCharacterSet(s).size();
    }

    private HashSet<Character> buildUniqueCharacterSet(String s) {
        var inputAsCharArray = s.toCharArray();
        var uniqueChars = new HashSet<Character>();
        for (char c : inputAsCharArray){
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
}
