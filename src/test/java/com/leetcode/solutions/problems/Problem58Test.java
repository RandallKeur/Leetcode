package com.leetcode.solutions.problems;

import com.leetcode.solutions.problems.Problem58;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.BDDAssertions.then;

public class Problem58Test {

    private Problem58 serviceUnderTest;

    private static Stream<Arguments> TestCases() {
        return Stream.of(
                Arguments.of("Hello World", 5),
                Arguments.of("   fly me   to   the moon  ", 4),
                Arguments.of("luffy is still joyboy", 6),
                Arguments.of("              ", 0)
        );
    }

    @BeforeEach
    public void setup() { this.serviceUnderTest = new Problem58(); }

    @ParameterizedTest
    @MethodSource("TestCases")
    public void testSolution_withParameterizedInputs(String input, int expected) {
        // given & when
        final var actual = serviceUnderTest.lengthOfLastWord(input);

        // then
        then(actual).isEqualTo(expected);
    }
}
