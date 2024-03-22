package com.leetcode.solutions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.BDDAssertions.then;

public class Problem1047Test {

    private Problem1047 serviceUnderTest;

    public static Stream<Arguments> removeDuplicatesTestCases() {
        return Stream.of(
                Arguments.of("abbaca", "ca"),
                Arguments.of("azxxzy", "ay"),
                Arguments.of("bbacbbddc", "a"),
                Arguments.of("baabcbbaabbc", ""),
                Arguments.of("abbacabcddcba", "c"),
                Arguments.of("abb", "a"),
                Arguments.of("bba", "a")
        );
    }

    @BeforeEach
    void Setup(){
        this.serviceUnderTest = new Problem1047();
    }

    @ParameterizedTest
    @MethodSource("removeDuplicatesTestCases")
    void RemoveDuplicates_TestCases(String input, String expected) {

        //when
        final var actual = serviceUnderTest.removeDuplicates(input);

        //then
        then(actual).isEqualTo(expected);
    }
}
