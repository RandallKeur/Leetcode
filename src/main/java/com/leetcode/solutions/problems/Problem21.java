package com.leetcode.solutions.problems;

import com.leetcode.solutions.customStructures.ListNode;

public class Problem21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        var resultPointer = new ListNode();
        var result = resultPointer;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                result.next = list1;
                list1 = list1.next;
            } else {
                result.next = list2;
                list2 = list2.next;
            }
            result = result.next;
        }

        result.next = list1 == null ? list2 : list1;

        return resultPointer.next;
    }
}
