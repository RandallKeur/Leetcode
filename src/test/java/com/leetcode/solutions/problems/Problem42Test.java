package com.leetcode.solutions.problems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.BDDAssertions.then;

public class Problem42Test {

    private Problem42 serviceUnderTest;

    private static Stream<Arguments> TestCases() {
        return Stream.of(
                Arguments.of(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}, 6),
                Arguments.of(new int[] {4,2,0,3,2,5}, 9)
        );
    }

    @BeforeEach
    public void setup() { this.serviceUnderTest = new Problem42(); }

    @ParameterizedTest
    @MethodSource("TestCases")
    public void testSolution_withParameterizedInputs(int[] input, int expected) {
        // given && when
        final var actual = serviceUnderTest.trap(input);

        // then
        then(actual).isEqualTo(expected);
    }
}
