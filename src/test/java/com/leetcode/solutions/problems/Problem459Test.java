package com.leetcode.solutions.problems;

import com.leetcode.solutions.problems.Problem459;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

import static org.assertj.core.api.BDDAssertions.then;

public class Problem459Test {

    private Problem459 serviceUnderTest;

    private static Stream<Arguments> TestCases() {
        return Stream.of(
                Arguments.of("abab", true),
                Arguments.of("aba", false),
                Arguments.of("abcabcabcabc", true),
                Arguments.of("aa", true),
                Arguments.of("a", false)
        );
    }

    @BeforeEach
    public void Setup() { this.serviceUnderTest = new Problem459(); }

    @ParameterizedTest
    @MethodSource("TestCases")
    public void Problem459Tests(String input, boolean expected){
        // given & when
        final var actual = serviceUnderTest.repeatedSubstringPattern(input);

        // then
        then(actual).isEqualTo(expected);
    }
}
