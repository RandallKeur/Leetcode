package com.leetcode.solutions.problems;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.BDDAssertions.then;

public class Problem2716Test {

    private Problem2716 serviceUnderTest;

    private static Stream<Arguments> TestCases() {
        return Stream.of(
                Arguments.of("aaabc", 3),
                Arguments.of("cbbd", 3),
                Arguments.of("dddaaa", 2)
        );
    }

    private static Stream<Arguments> WithoutAdjacentTestCases() {
        return Stream.of(
                Arguments.of("aaaabcd", 4),
                Arguments.of("aaabacd", 5),
                Arguments.of("aaab", 2),
                Arguments.of("aabbaabac", 6),
                Arguments.of("cbbdb", 4)
        );
    }


    @BeforeEach
    public void setup() {this.serviceUnderTest = new Problem2716();}

    @ParameterizedTest
    @MethodSource("TestCases")
    public void testSolution_withParameterizedInputs(String input, int expected) {
        //when
        final var actual = serviceUnderTest.minimizedStringLength(input);

        //then
        then(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("WithoutAdjacentTestCases")
    public void testWithoutAdjacentSolution_withParameterizedInputs(String input, int expected) {
        //when
        final var actual = serviceUnderTest.minimizedStringLengthWithoutAdjacentRepeatingCharacters(input);

        //then
        then(actual).isEqualTo(expected);
    }
}
