package com.leetcode.solutions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.BDDAssertions.then;

class Problem2729Test {

    private Problem2729 serviceUnderTest;

    public static Stream<Arguments> provideIsFascinatingTestCases() {
        return Stream.of(
                Arguments.of(123, false),
                Arguments.of(190, false),
                Arguments.of(334, false),
                Arguments.of(192, true),
                Arguments.of(327, true));
    }

    @BeforeEach
    void Setup(){
        this.serviceUnderTest = new Problem2729();
    }

    @ParameterizedTest
    @MethodSource("provideIsFascinatingTestCases")
    void IsFascinating_TestCases(Integer input, boolean expected) {

        //when
        final var actual = serviceUnderTest.isFascinating(input);

        //then
        then(actual).isEqualTo(expected);
    }

}
