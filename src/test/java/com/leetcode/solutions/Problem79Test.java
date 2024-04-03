package com.leetcode.solutions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.BDDAssertions.then;

public class Problem79Test {

    private Problem79 serviceUnderTest;

    private static Stream<Arguments> TestCases() {
        return Stream.of(
                Arguments.of(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCED", true),
                Arguments.of(new char[][] {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "SEE", true),
                Arguments.of(new char[][] {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCB", false)
        );
    }
    @BeforeEach
    public void setup() { this.serviceUnderTest = new Problem79(); }

    @ParameterizedTest
    @MethodSource("TestCases")
    public void Problem79Tests(char[][] board, String word, boolean expected) {
        // given && when
        final var actual = serviceUnderTest.exist(board, word);

        // then
        then(actual).isEqualTo(expected);
    }
}
