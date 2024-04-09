package com.leetcode.solutions.problems;

import java.util.LinkedList;

public class Problem1700 {
    public int countStudents(int[] students, int[] sandwiches) {
        var queue = new LinkedList<Integer>();
        int top = 0, count = 0;

        for(int e : students)
            queue.add(e);

        while(!queue.isEmpty() && count != queue.size()){
            if(queue.peek() == sandwiches[top]) {
                count = 0;
                top++;
                queue.poll();
            } else {
                queue.add(queue.poll());
                count++;
            }
        }
        return queue.size();
    }
}
