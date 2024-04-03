package com.leetcode.solutions.problems;



import com.leetcode.solutions.customStructures.TreeNode;
import com.leetcode.solutions.problems.Problem111;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.BDDAssertions.then;

public class Problem111Test {

    private Problem111 serviceUnderTest;

    private static Stream<Arguments> TestCases() {
        return Stream.of(
                Arguments.of(
                        new TreeNode(
                        3,
                        new TreeNode(9),
                        new TreeNode(
                                20,
                                new TreeNode(15),
                                new TreeNode(7))), 2),
                Arguments.of(
                        new TreeNode(
                                2,
                                null,
                                new TreeNode(
                                        3,
                                        null,
                                        new TreeNode(
                                                4,
                                                null,
                                                new TreeNode(
                                                        5,
                                                        null,
                                                        new TreeNode(6))))), 5)
        );
    }

    @BeforeEach
    public void Setup() { this.serviceUnderTest = new Problem111(); }

    @ParameterizedTest
    @MethodSource("TestCases")
    public void Problem111Tests(TreeNode input, Integer expected) {
        // given
        // when
        var actual = serviceUnderTest.minDepth(input);

        // then
        then(actual).isEqualTo(expected);
    }
}
