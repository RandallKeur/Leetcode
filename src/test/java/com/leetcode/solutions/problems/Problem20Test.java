package com.leetcode.solutions.problems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.BDDAssertions.then;

public class Problem20Test {

    private Problem20 serviceUnderTest;

    private static Stream<Arguments> TestCases() {
        return Stream.of(
                Arguments.of("{}[]()", Boolean.TRUE),
                Arguments.of("{]", Boolean.FALSE),
                Arguments.of("{[()]]", Boolean.FALSE),
                Arguments.of("[", Boolean.FALSE)
        );
    }

    @BeforeEach
    public void setup() { this.serviceUnderTest = new Problem20(); }

    @ParameterizedTest
    @MethodSource("TestCases")
    public void testSolution_withParameterizedInputs(String input, Boolean expected) {
        // given && when
        final var actual = serviceUnderTest.isValid(input);

        // then
        then(actual).isEqualTo(expected);
    }
}
