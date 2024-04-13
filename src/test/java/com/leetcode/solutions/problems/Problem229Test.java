package com.leetcode.solutions.problems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.BDDAssertions.then;

public class Problem229Test {

    private Problem229 serviceUnderTest;

    private static Stream<Arguments> TestCases() {
        return Stream.of(
                Arguments.of(new Integer[]{3, 2, 3}, List.of(3)),
                Arguments.of(new Integer[] {1,2}, List.of(1,2)),
                Arguments.of(new Integer[] {1}, List.of(1)),
                Arguments.of(new Integer[] {1,2,3}, List.of()),
                Arguments.of(new Integer[] {1,2,3,1}, List.of(1)),
                Arguments.of(new Integer[] {1,2,1,2,3}, List.of(1,2)),
                Arguments.of(new Integer[] {1,2,3,1,2,3,1,2,3,3}, List.of(3)),
                Arguments.of(new Integer[] {1,2,3,4,2,3,4,2,3,4,2,3,4,2,3,4,2,3,4}, List.of())
        );
    }

    @BeforeEach
    public void setup() { this.serviceUnderTest = new Problem229(); }

    @ParameterizedTest
    @MethodSource("TestCases")
    public void testSolution_withParameterizedInputs(Integer[] input, List<Integer> expected) {
        // given & when
        final var actual = serviceUnderTest.majorityElement(input);

        // then
        then(actual).isEqualTo(expected);
    }
}
