package com.leetcode.solutions.problems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.BDDAssertions.then;

public class Problem14Test {

    private Problem14 serviceUnderTest;

    private static Stream<Arguments> TestCases() {
        return Stream.of(
                Arguments.of(List.of("flower","flow","flight"), "fl"),
                Arguments.of(List.of("dog","racecar","car"), "")
        );
    }

    @BeforeEach
    public void setup() { this.serviceUnderTest = new Problem14(); }

    @ParameterizedTest
    @MethodSource("TestCases")
    public void Problem14Test(String[] input, String expected) {
        // given && when
        final var actual = serviceUnderTest.longestCommonPrefix(input);

        // then
        then(actual).isEqualTo(expected);
    }
}
