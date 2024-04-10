package com.leetcode.solutions.problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Problem950 {
    public int[] deckRevealedIncreasing(int[] deck) {
        final var queue = buildQueue(deck);
        final var result = new int[deck.length];
        for (int card : deck) {
            result[queue.poll()] = card;
            queue.add(queue.poll());
        }
        return result;
    }

    private Queue<Integer> buildQueue(int[] deck) {
        Arrays.sort(deck);
        final var queue = new LinkedList<Integer>();
        for (int i = 0; i < deck.length; i++) queue.add(i);
        return queue;
    }
}
