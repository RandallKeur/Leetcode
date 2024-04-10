package com.leetcode.solutions.problems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.BDDAssertions.then;

public class Problem1614Test {

    private Problem1614 serviceUnderTest;

    private static Stream<Arguments> TestCases() {
        return Stream.of(
                Arguments.of("(1+(2*3)+((8)/4))+1", 3),
                Arguments.of("(1)+((2))+(((3)))", 3),
                Arguments.of("()", 1),
                Arguments.of("", 0)
        );
    }

    @BeforeEach
    public void setup() { this.serviceUnderTest = new Problem1614(); }

    @ParameterizedTest
    @MethodSource("TestCases")
    public void testSolution_withParameterizedInputs(String input, Integer expected) {
        // given && when
        final var actual = serviceUnderTest.maxDepth(input);

        // then
        then(actual).isEqualTo(expected);
    }
}
