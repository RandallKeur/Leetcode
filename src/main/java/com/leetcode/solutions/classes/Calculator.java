package com.leetcode.solutions.classes;

import com.leetcode.solutions.customStructures.ListNode;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculator {
    private Integer remainder = null;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (remainder == null) {
            remainder = 0;
        }
        var sum = l1.val + l2.val;
        var resultListNode = new ListNode(sum + remainder, null);
        remainder = resultListNode.val >= 10 ? 1 : 0;
        resultListNode.val %= 10;
        if (l1.next != null || l2.next != null || remainder != 0) {
            l1.next = l1.next == null ? new ListNode(0, null) : l1.next;
            l2.next = l2.next == null ? new ListNode(0, null) : l2.next;
            resultListNode.next = addTwoNumbers(l1.next, l2.next);
        }
        return resultListNode;
    }

    public double[] convertTemperature(double input) {
        final var kelvin = input + 273.15;
        final var fahrenheit = input * 1.80 + 32.00;
        return new double[]{
                roundToDecimalPlaces(kelvin, 5),
                roundToDecimalPlaces(fahrenheit, 5)
        };
    }

    private double roundToDecimalPlaces(double value, int decimalPlaces) {
        return BigDecimal
                .valueOf(value)
                .setScale(decimalPlaces, RoundingMode.HALF_UP)
                .doubleValue();
    }
}
