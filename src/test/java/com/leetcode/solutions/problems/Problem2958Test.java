package com.leetcode.solutions.problems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.BDDAssertions.then;

public class Problem2958Test {

    private Problem2958 serviceUnderTest;

    private static Stream<Arguments> TestCases() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 1, 2, 3, 1, 2}, 2, 6),
                Arguments.of(new int[]{1, 2, 1, 2, 1, 2, 1, 2}, 1, 2),
                Arguments.of(new int[]{5, 5, 5, 5, 5, 5, 5}, 4, 4),
                Arguments.of(new int[]{1, 2, 3, 1, 2, 3, 1, 2, 4, 5, 3, 4, 2, 3}, 3, 12)
        );
    }

    @BeforeEach
    public void setup() {
        this.serviceUnderTest = new Problem2958();
    }

    @ParameterizedTest
    @MethodSource("TestCases")
    public void testSolution_withParameterizedInputs(int[] nums, int max, int expected) {
        // given && when
        final var actual = serviceUnderTest.maxSubarrayLength(nums, max);

        // then
        then(actual).isEqualTo(expected);
    }
}
