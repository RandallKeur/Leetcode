package com.leetcode.solutions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.BDDAssertions.then;

public class Problem205Test {

    private Problem205 serviceUnderTest;

    public static Stream<Arguments> TestCases() {
        return Stream.of(
                Arguments.of("egg", "add", true),
                Arguments.of("foo","bar", false),
                Arguments.of("food", "eggs", true),
                Arguments.of("food", "acai", false),
                Arguments.of("paper", "title", true),
                Arguments.of("qwerasdfvcxz", "zxcvasdfqwer", true),
                Arguments.of("badc", "baba", false),
                Arguments.of("baba", "badc", false)
        );
    }


    @BeforeEach
    void Setup() { this.serviceUnderTest = new Problem205(); }

    @ParameterizedTest
    @MethodSource("TestCases")
    void Problem205TestCases(String input1, String input2, boolean expected) {
        // given and when
        final var actual = serviceUnderTest.isIsomorphic(input1, input2);

        // then
        then(actual).isEqualTo(expected);
    }
}
