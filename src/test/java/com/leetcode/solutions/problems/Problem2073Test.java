package com.leetcode.solutions.problems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.BDDAssertions.then;

public class Problem2073Test {

    private Problem2073 serviceUnderTest;


    private static Stream<Arguments> TestCases() {
        return Stream.of(
                Arguments.of(new int[] {2,3,2}, 2, 6),
                Arguments.of(new int[] {5,1,1,1}, 0, 8),
                Arguments.of( new int[] {5,1,1,1}, 1, 2),
                Arguments.of( new int[] {5,1,2,2,1}, 3, 8)
        );
    }
    @BeforeEach
    public void setup() { this.serviceUnderTest = new Problem2073(); }

    @ParameterizedTest
    @MethodSource("TestCases")
    public void testSolution_withParameterizedInputs(int[] tickets, int position, int expected) {
        // given && when
        final var actual = serviceUnderTest.timeRequiredToBuy(tickets, position);

        // then
        then(actual).isEqualTo(expected);
    }
}
