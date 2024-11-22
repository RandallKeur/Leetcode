package com.leetcode.solutions.problems;

import com.leetcode.solutions.classes.ListOperator;
import com.leetcode.solutions.customStructures.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.BDDAssertions.then;

public class ListOperatorTest {

    private ListOperator serviceUnderTest;

    private static Stream<Arguments> TestCases() {
        return Stream.of(
                Arguments.of(null, new ListNode(0, null), new ListNode(0, null)),
                Arguments.of(new ListNode(1, new ListNode(2, new ListNode(4, null))),
                        new ListNode(1, new ListNode(3, new ListNode(4))),
                        new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3,
                                new ListNode(4, new ListNode(4, null))))))),
                Arguments.of(new ListNode(1, new ListNode(4, null)),
                        new ListNode(2, new ListNode(2, new ListNode(3, null))),
                        new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(3,
                                new ListNode(4, null))))))
        );
    }

    @BeforeEach
    public void setup() {
        this.serviceUnderTest = new ListOperator();
    }

    @ParameterizedTest
    @MethodSource("TestCases")
    public void testSolution_withParameterizedInputs(ListNode list1, ListNode list2, ListNode expected) {
        // given && when
        var actual = serviceUnderTest.mergeTwoLists(list1, list2);

        // then
        then(actual).isInstanceOf(expected.getClass());
        while (expected.next != null) {
            then(expected.val).isEqualTo(actual.val);
            expected = expected.next;
            actual = actual.next;
        }
    }
}
