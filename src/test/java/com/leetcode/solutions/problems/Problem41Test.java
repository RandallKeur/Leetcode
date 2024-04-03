package com.leetcode.solutions.problems;

import com.leetcode.solutions.problems.Problem41;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.BDDAssertions.then;

public class Problem41Test {

    private Problem41 serviceUnderTest;

    private static Stream<Arguments> TestCases() {
        return Stream.of(
                Arguments.of(new int[] {1,2,0}, 3),
                Arguments.of(new int[] {3,7,-1,1}, 2),
                Arguments.of(new int[] {7,8,9,11,12}, 1),
                Arguments.of(new int[] {1,5,-4,2,7,-9}, 3)
        );
    }

    @BeforeEach
    public void setup() { this.serviceUnderTest = new Problem41(); }

    @ParameterizedTest
    @MethodSource("TestCases")
    public void Problem41Tests(int[] input, int expected) {
        // given && when
        final var actual = serviceUnderTest.firstMissingPositive(input);

        // then
        then(actual).isEqualTo(expected);
    }
}
