package com.leetcode.solutions.problems;

import com.leetcode.solutions.problems.Problem9;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.BDDAssertions.then;

public class Problem9Test {

    private Problem9 serviceUnderTest;

    private static Stream<Arguments> TestCases() {
        return Stream.of(
                Arguments.of(121, Boolean.TRUE),
                Arguments.of(-121, Boolean.FALSE),
                Arguments.of(10, Boolean.FALSE),
                Arguments.of(11, Boolean.TRUE),
                Arguments.of(12321, Boolean.TRUE),
                Arguments.of(123321, Boolean.TRUE),
                Arguments.of(-1234321, Boolean.FALSE)
        );
    }

    @BeforeEach
    public void Setup() { this.serviceUnderTest = new Problem9(); };

    @ParameterizedTest
    @MethodSource("TestCases")
    public void Problem9Tests(Integer input, Boolean expected) {
        // given & when
        final var actual = serviceUnderTest.isPalindrome(input);

        // then
        then(actual).isEqualTo(expected);
    }

}
