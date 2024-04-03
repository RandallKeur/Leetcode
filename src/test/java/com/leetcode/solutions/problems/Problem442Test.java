package com.leetcode.solutions.problems;

import com.leetcode.solutions.problems.Problem442;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.BDDAssertions.then;

public class Problem442Test {

    private Problem442 serviceUnderTest;

    private static Stream<Arguments> TestCases() {
        return Stream.of(
                Arguments.of(new int[] { 4,3,2,7,8,2,3,1 }, List.of(2,3)),
                Arguments.of(new int[] { 1,1,2 }, List.of(1)),
                Arguments.of(new int[] { 1 }, List.of()),
                Arguments.of(new int[] { 1,2,3,4,3,2 }, List.of(3, 2))
        );
    }

    @BeforeEach
    public void setup() { this.serviceUnderTest = new Problem442(); }

    @ParameterizedTest
    @MethodSource("TestCases")
    public void Problem442Tests(int[] input, List<Integer> expected) {
        // given & when
        final var actual = serviceUnderTest.findDuplicates(input);

        // then
        then(actual).isEqualTo(expected);
    }
}
