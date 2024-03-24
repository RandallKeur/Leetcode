package com.leetcode.solutions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.BDDAssertions.then;

public class Problem7Test {

    private Problem7 serviceUnderTest;

    private static Stream<Arguments> TestCases(){
        return Stream.of(
                Arguments.of(Integer.MAX_VALUE, 0),
                Arguments.of(Integer.MIN_VALUE, 0),
                Arguments.of(123, 321),
                Arguments.of(-123, -321),
                Arguments.of(120, 21)
        );
    }

    @BeforeEach
    public void setup() { this.serviceUnderTest = new Problem7(); }

    @ParameterizedTest
    @MethodSource("TestCases")
    public void Problem7Tests(int input, int expected)
    {
        // given & when
        final var actual = serviceUnderTest.reverse(input);

        // then
        then(actual).isEqualTo(expected);
    }
}
