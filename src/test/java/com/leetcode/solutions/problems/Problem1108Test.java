package com.leetcode.solutions.problems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.BDDAssertions.then;

public class Problem1108Test {


    private Problem1108 serviceUnderTest;

    private static Stream<Arguments> TestCases() {
        return Stream.of(
                Arguments.of("1.1.1.1", "1[.]1[.]1[.]1"),
                Arguments.of("255.100.50.0", "255[.]100[.]50[.]0")
        );
    }

    @BeforeEach
    public void setup() {
        this.serviceUnderTest = new Problem1108();
    }

    @ParameterizedTest
    @MethodSource("TestCases")
    public void testSolution_withParameterizedInputs(String input, String expected) {

        //when
        final var actual = serviceUnderTest.defangIPaddr(input);

        //then
        then(actual).isEqualTo(expected);
    }
}
