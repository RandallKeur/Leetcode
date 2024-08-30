package com.leetcode.solutions.problems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.BDDAssertions.then;

public class Problem2469Test {

    private Problem2469 serviceUnderTest;


    private static Stream<Arguments> TestCases() {
        return Stream.of(
                Arguments.of(36.50, new double[]{309.65000,97.70000}),
                Arguments.of(122.11, new double[]{395.26000,251.79800}),
                Arguments.of(1.32, new double[]{274.47000,34.37600}),
                Arguments.of(453.11, new double[]{726.26000,847.59800})
        );
    }

    @BeforeEach
    public void setup() {
        this.serviceUnderTest = new Problem2469();
    }

    @ParameterizedTest
    @MethodSource("TestCases")
    public void testSolution_withParameterizedInputs(double input, double[] expected) {
        // given && when
        final var actual = serviceUnderTest.convertTemperature(input);

        // then
        then(actual).isEqualTo(expected);
    }
}
