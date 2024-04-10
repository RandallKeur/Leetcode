package com.leetcode.solutions.problems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.BDDAssertions.then;

public class Problem2578Test {

    private Problem2578 serviceUnderTest;

    private static Stream<Arguments> TestCases() {
        return Stream.of(
                Arguments.of(4325, 59),
                Arguments.of(687, 75),
                Arguments.of(987, 87)
        );
    }

    @BeforeEach
    public void setup() { this.serviceUnderTest = new Problem2578(); }

    @ParameterizedTest
    @MethodSource("TestCases")
    public void testSolution_withParameterizedInputs(int input, int expected) {
        // given && when
        final var actual = serviceUnderTest.splitNum(input);

        // then
        then(actual).isEqualTo(expected);
    }
}
