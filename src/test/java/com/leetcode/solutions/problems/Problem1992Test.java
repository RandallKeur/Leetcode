package com.leetcode.solutions.problems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.BDDAssertions.then;

public class Problem1992Test {
    private Problem1992 serviceUnderTest;

    private static Stream<Arguments> TestCases() {
        return Stream.of(
                Arguments.of(new int[][]{{1, 0, 0}, {0, 1, 1}, {0, 1, 1}},
                        new int[][]{{0, 0, 0, 0}, {1, 1, 2, 2}}),
                Arguments.of(new int[][]{{1, 1}, {1, 1}},
                        new int[][]{{0, 0, 1, 1}}),
                Arguments.of(new int[][]{{0}},
                        new int[][]{})
        );
    }

    @BeforeEach
    public void setup() {
        this.serviceUnderTest = new Problem1992();
    }

    @ParameterizedTest
    @MethodSource("TestCases")
    public void testSolution_withParameterizedInputs(int[][] input, int[][] expected) {
        // given && when
        final var actual = serviceUnderTest.findFarmland(input);

        // then
        then(actual).isEqualTo(expected);
    }
}
