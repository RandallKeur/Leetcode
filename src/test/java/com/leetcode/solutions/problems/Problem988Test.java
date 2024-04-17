package com.leetcode.solutions.problems;

import com.leetcode.solutions.customStructures.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.BDDAssertions.then;

public class Problem988Test {

    private Problem988 serviceUnderTest;

    private static Stream<Arguments> TestCases() {
        return Stream.of(
                Arguments.of(new TreeNode(0,
                        new TreeNode(1,
                                new TreeNode(3), new TreeNode(4)),
                        new TreeNode(2,
                                new TreeNode(3), new TreeNode(4))),
                        "dba"),
                Arguments.of(new TreeNode(25,
                        new TreeNode(1,
                                new TreeNode(1), new TreeNode(3)),
                        new TreeNode(3,
                                new TreeNode(0), new TreeNode(2))),
                        "adz"),
                Arguments.of(new TreeNode(2,
                        new TreeNode(2,
                                null, new TreeNode(1,
                                null, new TreeNode(0))),
                        new TreeNode(1,
                                null, new TreeNode(0))),
                        "abc")
        );
    }

    @BeforeEach
    public void setup() { this.serviceUnderTest = new Problem988(); }

    @ParameterizedTest
    @MethodSource("TestCases")
    public void testSolution_withParameterizedInputs(TreeNode input, String expected) {
        // when && then
        final var actual = serviceUnderTest.smallestFromLeaf(input);

        // then
        then(actual).isEqualTo(expected);
    }
}
