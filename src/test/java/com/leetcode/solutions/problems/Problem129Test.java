package com.leetcode.solutions.problems;

import com.leetcode.solutions.customStructures.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.BDDAssertions.then;

public class Problem129Test {

    private Problem129 serviceUnderTest;

    private static Stream<Arguments> TestCases() {
        return Stream.of(
                Arguments.of(new TreeNode(1,
                        new TreeNode(2),
                        new TreeNode(3)),
                        25),
                Arguments.of(new TreeNode(4,
                        new TreeNode(9,
                                new TreeNode(5),
                                new TreeNode(1)
                        ), new TreeNode(0)),
                        1026)
        );
    }

    @BeforeEach
    public void setup() { this.serviceUnderTest = new Problem129(); }

    @ParameterizedTest
    @MethodSource("TestCases")
    public void testSolution_withParameterizedInputs(TreeNode input, int expected) {
        // given && when
        final var actual = serviceUnderTest.sumNumbers(input);

        // then
        then(actual).isEqualTo(expected);
    }
}
