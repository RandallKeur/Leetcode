package com.leetcode.solutions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.BDDAssertions.then;

class Problem392Test {

    private Problem392 serviceUnderTest;
    private static Stream<Arguments> TestCases() {
        return Stream.of(
                Arguments.of("abc", "ahbgdc", true),
                Arguments.of("axc", "ahbgdc", false),
                Arguments.of("abbd", "adksjfdlkbdlsfkjdfbfe", false),
                Arguments.of("abbd", "asdfkjsdlfkbfsbfd", true),
                Arguments.of("abbbd", "abbbbbd", true),
                Arguments.of("abbbd", "abbd", false),
                Arguments.of("abbc", "aerebereb", false)
        );
    }

    @BeforeEach
    public void Setup() { this.serviceUnderTest = new Problem392(); }

    @ParameterizedTest
    @MethodSource("TestCases")
    public void Problem392TestsVersion1(String string1, String string2, Boolean expected) {
        // given and when
        final var actual = serviceUnderTest.isSubsequence(string1, string2);

        // then
        then(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("TestCases")
    public void Problem392TestsVersion2(String string1, String string2, Boolean expected) {
        // given and when
        final var actual = serviceUnderTest.isSubsequenceVersion2(string1, string2);

        // then
        then(actual).isEqualTo(expected);
    }
}
