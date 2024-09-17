package com.leetcode.solutions.classes;

import com.leetcode.solutions.customStructures.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.BDDAssertions.then;

public class CalculatorTest {
    private Calculator serviceUnderTest;

    private static Stream<Arguments> AddTwoNumbersTestCases() {
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

    private static Stream<Arguments> ConvertTempTestCases() {
        return Stream.of(
                Arguments.of(36.50, new double[]{309.65000, 97.70000}),
                Arguments.of(122.11, new double[]{395.26000, 251.79800}),
                Arguments.of(1.32, new double[]{274.47000, 34.37600}),
                Arguments.of(453.11, new double[]{726.26000, 847.59800})
        );
    }

    @BeforeEach
    public void setup() {
        this.serviceUnderTest = new Calculator();
    }

    @ParameterizedTest
    @MethodSource("AddTwoNumbersTestCases")
    public void Problem2Tests(ListNode listNode1, ListNode listNode2, ListNode expected) {
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

    @ParameterizedTest
    @MethodSource("ConvertTempTestCases")
    public void testConvertTemp_withParameterizedInputs(double input, double[] expected) {
        // given && when
        final var actual = serviceUnderTest.convertTemperature(input);

        // then
        then(actual).isEqualTo(expected);
    }
}
