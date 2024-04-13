package com.leetcode.solutions.problems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.BDDAssertions.then;

public class Problem14Test {

    private Problem14 serviceUnderTest;

    private static Stream<Arguments> TestCases() {
        return Stream.of(
                Arguments.of(new String[] {"flower","flow","flight"}, "fl"),
                Arguments.of(new String[] {"dog","racecar","car"}, ""),
                Arguments.of(new String[] {"test","tes","testing", "tested"}, "tes")
        );
    }

    @BeforeEach
    public void setup() { this.serviceUnderTest = new Problem14(); }

    @ParameterizedTest
    @MethodSource("TestCases")
    public void testSolution_withParameterizedInputs(String[] input, String expected) {
        // given && when
        final var actual = serviceUnderTest.longestCommonPrefix(input);

        // then
        then(actual).isEqualTo(expected);
    }
}
