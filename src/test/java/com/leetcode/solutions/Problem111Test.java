package com.leetcode.solutions;

import com.leetcode.solutions.CustomStructures.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.stream.*;

import static org.assertj.core.api.BDDAssertions.then;

public class Problem111Test {

    private Problem111 serviceUnderTest;

    public static Stream<Arguments> TestCases() {
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
    void Setup() { this.serviceUnderTest = new Problem111(); }

    @ParameterizedTest
    @MethodSource("TestCases")
    void Problem11TestCases(TreeNode input, Integer expected) {
        // given
        var treeNode = new TreeNode(
                3,
                new TreeNode(9),
                new TreeNode(
                        20,
                        new TreeNode(15),
                        new TreeNode(7)));

        // when
        var actual = serviceUnderTest.minDepth(treeNode);

        // then
        then(actual).isEqualTo(expected);
    }
}
