package com.leetcode.solutions.problems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.BDDAssertions.then;

public class Problem713Test {

    private Problem713 serviceUnderTest;

    private static Stream<Arguments> TestCases(){
        return Stream.of(
                Arguments.of(new int[] {10,5,2,6}, 100, 8),
                Arguments.of(new int[] {1,2,3}, 0, 0 ),
                Arguments.of(new int[] {1,2,3,4,5,6}, 60, 14),
                Arguments.of(new int[] {1,5,2,6}, 70, 10),
                Arguments.of(new int[] {2,2,2,2}, 9, 9)
        );
    }

    @BeforeEach
    public void setup() { this.serviceUnderTest = new Problem713(); }

    @ParameterizedTest
    @MethodSource("TestCases")
    public void testSolution_withParameterizedInputs(int[] numbers, int max, int expected) {
        // given & when
        final var actual = serviceUnderTest.numSubarrayProductLessThanK(numbers, max);

        // then
        then(actual).isEqualTo(expected);
    }

}
