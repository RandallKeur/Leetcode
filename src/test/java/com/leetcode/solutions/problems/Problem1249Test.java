package com.leetcode.solutions.problems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.BDDAssertions.then;

public class Problem1249Test {

    private Problem1249 serviceUnderTest;

    private static Stream<Arguments> TestCases() {
        return Stream.of(
                Arguments.of("lee(t(c)o)de", "lee(t(c)o)de"),
                Arguments.of("a)b(c)d", "ab(c)d"),
                Arguments.of("))((", "")
        );
    }

    @BeforeEach
    public void setup() { this.serviceUnderTest = new Problem1249(); }

    @ParameterizedTest
    @MethodSource("TestCases")
    public void testSolution_withParameterizedInputs(String input, String expected) {
        // when && then
        final var actual = serviceUnderTest.minRemoveToMakeValid(input);

        //then
        then(actual).isEqualTo(expected);
    }
}
