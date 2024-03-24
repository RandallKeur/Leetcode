package com.leetcode.solutions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.BDDAssertions.then;

public class Problem136Test {

    private Problem136 serviceUnderTest;

    private static Stream<Arguments> TestCases() {
        return Stream.of(
                Arguments.of(new Integer[] {2,2,1}, 1),
                Arguments.of(new Integer[] {4,1,2,1,2}, 4),
                Arguments.of(new Integer[] {1}, 1),
                Arguments.of(new Integer[] {4,1,2,2,1}, 4),
                Arguments.of(new Integer[] {1,2,4,2,1}, 4)
        );
    }

    @BeforeEach
    public void Setup() { this.serviceUnderTest = new Problem136(); }

    @ParameterizedTest
    @MethodSource("TestCases")
    public void Problem136Tests(Integer[] input, Integer expected){
        // given and when
        final var actual = serviceUnderTest.singleNumber(input);

        // then
        then(actual).isEqualTo(expected);
    }
}
