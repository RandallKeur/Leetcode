package com.leetcode.solutions.problems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.BDDAssertions.then;

public class Problem1470Test {
    private Problem1470 serviceUnderTest;

    private static Stream<Arguments> TestCases() {
        return Stream.of(
                Arguments.of(new int[]{1,2,3,4,5,6}, 3, new int[]{1,4,2,5,3,6}),
                Arguments.of(new int[]{1,3,5,7,2,4,6,8}, 4, new int[]{1,2,3,4,5,6,7,8}),
                Arguments.of(new int[]{1,2,3,4,4,3,2,1}, 4, new int[]{1,4,2,3,3,2,4,1})
        );
    }

    @BeforeEach
    public void setup() {
        this.serviceUnderTest = new Problem1470();
    }

    @ParameterizedTest
    @MethodSource("TestCases")
    public void testSolution_withParameterizedInputs(int[] nums, int n, int[] expected) {
        // when && then
        final var actual = serviceUnderTest.shuffle(nums, n);

        //then
        then(actual).isEqualTo(expected);
    }
}
