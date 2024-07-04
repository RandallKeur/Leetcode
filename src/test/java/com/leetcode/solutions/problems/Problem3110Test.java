package com.leetcode.solutions.problems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.BDDAssertions.then;

public class Problem3110Test {

    private Problem3110 serviceUnderTest;

    private static Stream<Arguments> TestCases() {
        return Stream.of(
                Arguments.of("hello", 13),
                Arguments.of("zaz", 50),
                Arguments.of("hh", 0),
                Arguments.of("rememberthetitans", 155)
        );
    }

    @BeforeEach
    public void setup() { this.serviceUnderTest = new Problem3110(); }

    @ParameterizedTest
    @MethodSource("TestCases")
    public void testSolution_withParameterizedTest(String input, Integer expected) {
        // given && when
        final var actual = serviceUnderTest.scoreOfString(input);

        // then
        then(actual).isEqualTo(expected);

    }
}
