package com.leetcode.solutions.problems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.BDDAssertions.then;

public class Problem950Test {

    private Problem950 serviceUnderTest;

    private static Stream<Arguments> TestCases() {
        return Stream.of(
                Arguments.of(new int[]{17, 13, 11, 2, 3, 5, 7}, new int[]{2, 13, 3, 11, 5, 17, 7}),
                Arguments.of(new int[]{1, 1000}, new int[]{1, 1000}),
                Arguments.of(new int[]{1, 43, 23, 12, 8, 9, 1000}, new int[]{1, 43, 8, 23, 9, 1000, 12})
        );
    }

    @BeforeEach
    public void setup() {
        this.serviceUnderTest = new Problem950();
    }

    @ParameterizedTest
    @MethodSource("TestCases")
    public void testSolution_withParameterizedInputs(int[] input, int[] expected) {
        // given && when
        final var actual = serviceUnderTest.deckRevealedIncreasing(input);

        // then
        then(actual).isEqualTo(expected);
    }
}
