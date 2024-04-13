package com.leetcode.solutions.problems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.BDDAssertions.then;

class Problem13Test {

    private Problem13 serviceUnderTest;
    private static Stream<Arguments> TestCases() {
        return Stream.of(
                Arguments.of("III", 3),
                Arguments.of("LVIII", 58),
                Arguments.of("MCMXCIV", 1994),
                Arguments.of("IV", 4),
                Arguments.of("LIV", 54)
        );
    }

    @BeforeEach
    public void setup() { this.serviceUnderTest = new Problem13(); }

    @ParameterizedTest
    @MethodSource("TestCases")
    public void testSolution_withParameterizedInputs(String input, Integer expected) {
        // given & when
        final var actual = serviceUnderTest.romanToInt(input);

        // then
        then(actual).isEqualTo(expected);
    }
}
