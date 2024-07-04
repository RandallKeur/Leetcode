package com.leetcode.solutions.problems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.BDDAssertions.then;

public class Problem242Test {

    private Problem242 serviceUnderTest;

    private static Stream<Arguments> TestCases() {
        return Stream.of(
                Arguments.of("anagram", "nagaram", Boolean.TRUE),
                Arguments.of("rat", "car", Boolean.FALSE),
                Arguments.of("Listen", "Silent", Boolean.TRUE),
                Arguments.of("Save", "Vase", Boolean.TRUE),
                Arguments.of("savvy", "Save", Boolean.FALSE)
                );
    }

    @BeforeEach
    public void setup() { this.serviceUnderTest = new Problem242(); }

    @ParameterizedTest
    @MethodSource("TestCases")
    public void testSolution_withParameterizedInputs(String firstWord, String secondWord, boolean expected) {
        // given & when
        final var actual = serviceUnderTest.isAnagram(firstWord, secondWord);
        
        // then
        then(actual).isEqualTo(expected);
    }
}
