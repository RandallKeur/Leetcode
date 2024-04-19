package com.leetcode.solutions.problems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.BDDAssertions.then;

public class Problem200Test {

    private Problem200 serviceUnderTest;

    private static Stream<Arguments> TestCases() {
        return Stream.of(
                Arguments.of(new char[][] {
                        {'1','1','1','1','0'},
                        {'1','1','0','1','0'},
                        {'1','1','0','0','0'},
                        {'0','0','0','0','0'}},
                        1),
                Arguments.of(new char[][] {
                        {'1','1','0','0','0'},
                        {'1','1','0','0','0'},
                        {'0','0','1','0','0'},
                        {'0','0','0','1','1'}},
                        3)
        );
    }

    @BeforeEach
    public void setup() { this.serviceUnderTest = new Problem200(); }

    @ParameterizedTest
    @MethodSource("TestCases")
    public void testSolution1_withParameterizedInputs(char[][] input, int expected) {
        // when && then
        final var actual = serviceUnderTest.numIslands(input);

        // then
        then(actual).isEqualTo(expected);
    }
}
