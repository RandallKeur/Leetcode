package com.leetcode.solutions.problems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.BDDAssertions.then;

public class Problem310Test {

    private Problem310 serviceUnderTest;

    private static Stream<Arguments> TestCases() {
        return Stream.of(
                Arguments.of(4, new int[][]{{1, 0}, {1, 2}, {1, 3}}, List.of(1)),
                Arguments.of(6, new int[][]{{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}}, List.of(3, 4))
        );
    }

    @BeforeEach
    public void setup() {
        this.serviceUnderTest = new Problem310();
    }

    @ParameterizedTest
    @MethodSource("TestCases")
    public void testSolution_withParameterizedInputs(int n, int[][] edges, List<Integer> expected) {
        // given && when
        final var actual = serviceUnderTest.findMinHeightTrees(n, edges);

        // then
        then(actual).isEqualTo(expected);
    }
}
