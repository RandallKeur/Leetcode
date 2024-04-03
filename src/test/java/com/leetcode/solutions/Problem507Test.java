package com.leetcode.solutions;

import com.leetcode.solutions.problems.Problem507;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.BDDAssertions.then;

public class Problem507Test {

    private Problem507 serviceUnderTest;

    private static Stream<Arguments> TestCases() {
        return Stream.of(
                Arguments.of(28, true),
                Arguments.of(7, false),
                Arguments.of(100, false),
                Arguments.of(127, false),
                Arguments.of(8128, true),
                Arguments.of(6, true),
                Arguments.of(16, false),
                Arguments.of(1, false)
        );
    }

    @BeforeEach
    public void Setup() { this.serviceUnderTest = new Problem507(); }

    @ParameterizedTest
    @MethodSource("TestCases")
    public void Problem507Tests(Integer input, boolean expected) {
        // given & when
        final var actual = serviceUnderTest.checkPerfectNumber(input);

        // then
        then(actual).isEqualTo(expected);
    }
}
