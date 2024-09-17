package com.leetcode.solutions.classes;

import com.leetcode.solutions.customStructures.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.BDDAssertions.then;

public class DFSTest {
    private DFS serviceUnderTest;

    private static Stream<Arguments> ExistTestCases() {
        return Stream.of(
                Arguments.of(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED", true),
                Arguments.of(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "SEE", true),
                Arguments.of(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCB", false)
        );
    }

    private static Stream<Arguments> MinDepthTestCases() {
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

    private static Stream<Arguments> SumNumbersTestCases() {
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

    private static Stream<Arguments> NumIslandsTestCases() {
        return Stream.of(
                Arguments.of(new char[][]{
                                {'1', '1', '1', '1', '0'},
                                {'1', '1', '0', '1', '0'},
                                {'1', '1', '0', '0', '0'},
                                {'0', '0', '0', '0', '0'}},
                        1),
                Arguments.of(new char[][]{
                                {'1', '1', '0', '0', '0'},
                                {'1', '1', '0', '0', '0'},
                                {'0', '0', '1', '0', '0'},
                                {'0', '0', '0', '1', '1'}},
                        3)
        );
    }

    private static Stream<Arguments> MinHeightTreesTestCases() {
        return Stream.of(
                Arguments.of(4, new int[][]{{1, 0}, {1, 2}, {1, 3}}, List.of(1)),
                Arguments.of(6, new int[][]{{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}}, List.of(3, 4))
        );
    }

    private static Stream<Arguments> SmallestFromLeafTestCases() {
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

    private static Stream<Arguments> MaxDepthTestCases() {
        return Stream.of(
                Arguments.of("(1+(2*3)+((8)/4))+1", 3),
                Arguments.of("(1)+((2))+(((3)))", 3),
                Arguments.of("()", 1),
                Arguments.of("", 0)
        );
    }

    private static Stream<Arguments> FindFarmlandTestCases() {
        return Stream.of(
                Arguments.of(new int[][]{{1, 0, 0}, {0, 1, 1}, {0, 1, 1}},
                        new int[][]{{0, 0, 0, 0}, {1, 1, 2, 2}}),
                Arguments.of(new int[][]{{1, 1}, {1, 1}},
                        new int[][]{{0, 0, 1, 1}}),
                Arguments.of(new int[][]{{0}},
                        new int[][]{})
        );
    }

    @BeforeEach
    public void setup() {
        this.serviceUnderTest = new DFS();
    }

    @ParameterizedTest
    @MethodSource("ExistTestCases")
    public void testExist_withParameterizedInputs(char[][] board, String word, boolean expected) {
        // given && when
        final var actual = serviceUnderTest.exist(board, word);

        // then
        then(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("MinDepthTestCases")
    public void testMinDepth_withParameterizedInputs(TreeNode input, Integer expected) {
        // given
        // when
        var actual = serviceUnderTest.minDepth(input);

        // then
        then(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("SumNumbersTestCases")
    public void testSumNumbers_withParameterizedInputs(TreeNode input, int expected) {
        // given && when
        final var actual = serviceUnderTest.sumNumbers(input);

        // then
        then(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("NumIslandsTestCases")
    public void testNumIslands_withParameterizedInputs(char[][] input, int expected) {
        // when && then
        final var actual = serviceUnderTest.numIslands(input);

        // then
        then(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("MinHeightTreesTestCases")
    public void testMinHeightTrees_withParameterizedInputs(int n, int[][] edges, List<Integer> expected) {
        // given && when
        final var actual = serviceUnderTest.findMinHeightTrees(n, edges);

        // then
        then(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("SmallestFromLeafTestCases")
    public void testSmallestFromLeaf_withParameterizedInputs(TreeNode input, String expected) {
        // when && then
        final var actual = serviceUnderTest.smallestFromLeaf(input);

        // then
        then(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("MaxDepthTestCases")
    public void testMaxDepth_withParameterizedInputs(String input, Integer expected) {
        // given && when
        final var actual = serviceUnderTest.maxDepth(input);

        // then
        then(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("FindFarmlandTestCases")
    public void testFindFarmland_withParameterizedInputs(int[][] input, int[][] expected) {
        // given && when
        final var actual = serviceUnderTest.findFarmland(input);

        // then
        then(actual).isEqualTo(expected);
    }
}
