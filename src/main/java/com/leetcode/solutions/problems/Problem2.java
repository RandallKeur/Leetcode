package com.leetcode.solutions.problems;

import com.leetcode.solutions.customStructures.ListNode;

public class Problem2 {
    private Integer remainder = null;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (remainder == null){
            remainder = 0;
        }
        var sum = l1.val + l2.val;
        var resultListNode = new ListNode(sum + remainder, null);
        remainder = resultListNode.val >= 10 ? 1 : 0;
        resultListNode.val %= 10;
        if (l1.next != null || l2.next != null || remainder != 0){
            l1.next = l1.next == null ? new ListNode(0, null) : l1.next;
            l2.next = l2.next == null ? new ListNode(0, null) : l2.next;
            resultListNode.next = addTwoNumbers(l1.next, l2.next);
        }
        return resultListNode;
    }
}
