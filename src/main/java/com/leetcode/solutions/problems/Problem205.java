package com.leetcode.solutions.problems;

import java.util.HashMap;

public class Problem205 {
    public boolean isIsomorphic(String input1, String input2) {

        var map = new HashMap<Character, Character>();
        var length = input1.length();

        for (var i = 0; i < length; i++) {
            var record = map.get(input1.charAt(i));
            var valueExists = map.containsValue(input2.charAt(i));
            if (record == null)
            {
                if (valueExists) return Boolean.FALSE;
                map.put(input1.charAt(i), input2.charAt(i));
            }
            else {
                if (!record.equals(input2.charAt(i)))
                    return Boolean.FALSE;
            }
        }

        return Boolean.TRUE;
    }
}
