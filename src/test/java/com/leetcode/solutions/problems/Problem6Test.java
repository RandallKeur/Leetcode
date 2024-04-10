package com.leetcode.solutions.problems;

import com.leetcode.solutions.problems.Problem6;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.BDDAssertions.then;

public class Problem6Test {

    private Problem6 serviceUnderTest;


    private static Stream<Arguments> TestCases() {
        return Stream.of(
                Arguments.of("PAYPALISHIRING", 3, "PAHNAPLSIIGYIR"),
                Arguments.of("PAYPALISHIRING", 4, "PINALSIGYAHRPI"),
                Arguments.of("A", 1, "A"),
                Arguments.of("PAYPALISHIRING", 6, "PRAIIYHNPSGAIL"),
                Arguments.of("PAYPALISHIRINGDEVELOPERS", 8, "PDAGEYNVPIEARLLIOSIHPRSE")
        );
    }
    @BeforeEach
    public void setup() { this.serviceUnderTest = new Problem6(); }

    @ParameterizedTest
    @MethodSource("TestCases")
    public void testSolution_withParameterizedInputs(String input, int numberOfRows, String expected) {
        // given & when
        final var actual = serviceUnderTest.convert(input, numberOfRows);

        // then
        then(actual).isEqualTo(expected);
    }
}
