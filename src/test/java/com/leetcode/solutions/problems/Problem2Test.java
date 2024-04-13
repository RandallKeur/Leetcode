package com.leetcode.solutions.problems;

import com.leetcode.solutions.customStructures.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.BDDAssertions.then;

public class Problem2Test {
    private Problem2 serviceUnderTest;

    private static Stream<Arguments> TestCases() {
        return Stream.of(
                Arguments.of(new ListNode(2, new ListNode(4, new ListNode(3, null))),
                        new ListNode(5, new ListNode(6, new ListNode(4, null))),
                        new ListNode(7, new ListNode(0, new ListNode(8, null)))),
                Arguments.of(new ListNode(0, null),
                        new ListNode(0, null),
                        new ListNode(0, null)),
                Arguments.of(new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9,
                            new ListNode(9, new ListNode(9, new ListNode(9, null))))))),
                        new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, null)))),
                        new ListNode(8, new ListNode(9, new ListNode(9, new ListNode(9,
                                new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(1, null)))))))))
        );
    }

    @BeforeEach
    public void setup() { this.serviceUnderTest = new Problem2(); }

    @ParameterizedTest
    @MethodSource("TestCases")
    public void Problem2Tests(ListNode listNode1, ListNode listNode2, ListNode expected){
        // given & when
        var actual = serviceUnderTest.addTwoNumbers(listNode1, listNode2);

        // then
        then(actual).isInstanceOf(expected.getClass());
        then(actual.val).isEqualTo(expected.val);
        while (expected.next != null) {
            then(expected.val).isEqualTo(actual.val);
            expected = expected.next;
            actual = actual.next;
        }
    }
}
