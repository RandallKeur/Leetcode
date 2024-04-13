package com.leetcode.solutions.problems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.BDDAssertions.then;

public class Problem1047Test {

    private Problem1047 serviceUnderTest;

    private static Stream<Arguments> TestCases() {
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
    public void setup(){
        this.serviceUnderTest = new Problem1047();
    }

    @ParameterizedTest
    @MethodSource("TestCases")
    public void testSolution_withParameterizedInputs(String input, String expected) {

        //when
        final var actual = serviceUnderTest.removeDuplicates(input);

        //then
        then(actual).isEqualTo(expected);
    }
}
