package com.leetcode.solutions.problems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.BDDAssertions.then;

public class Problem678Test {

    private Problem678 serviceUnderTest;

    private static Stream<Arguments> TestCases() {
        return Stream.of(
                Arguments.of("()", true),
                Arguments.of("(*)", true),
                Arguments.of("(*))", true),
                Arguments.of("(***()))", true)
        );
    }

    @BeforeEach
    public void setup() { this.serviceUnderTest = new Problem678(); }

    @ParameterizedTest
    @MethodSource("TestCases")
    public void testSolution_withParameterizedInputs(String input, Boolean expected) {
        // given && when
        final var actual = serviceUnderTest.checkValidString(input);

        // then
        then(actual).isEqualTo(expected);
    }
}
