package com.leetcode.solutions.classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.BDDAssertions.then;

public class NumberOperatorTest {
    private NumberOperator serviceUnderTest;

    private static Stream<Arguments> ReverseTestCases() {
        return Stream.of(
                Arguments.of(Integer.MAX_VALUE, 0),
                Arguments.of(Integer.MIN_VALUE, 0),
                Arguments.of(123, 321),
                Arguments.of(-123, -321),
                Arguments.of(120, 21)
        );
    }

    private static Stream<Arguments> IsPalindromeTestCases() {
        return Stream.of(
                Arguments.of(121, Boolean.TRUE),
                Arguments.of(-121, Boolean.FALSE),
                Arguments.of(10, Boolean.FALSE),
                Arguments.of(11, Boolean.TRUE),
                Arguments.of(12321, Boolean.TRUE),
                Arguments.of(123321, Boolean.TRUE),
                Arguments.of(-1234321, Boolean.FALSE)
        );
    }

    private static Stream<Arguments> FirstMissingPositiveTestCases() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 0}, 3),
                Arguments.of(new int[]{3, 7, -1, 1}, 2),
                Arguments.of(new int[]{7, 8, 9, 11, 12}, 1),
                Arguments.of(new int[]{1, 5, -4, 2, 7, -9}, 3)
        );
    }

    private static Stream<Arguments> SingleNumberTestCases() {
        return Stream.of(
                Arguments.of(new Integer[]{2, 2, 1}, 1),
                Arguments.of(new Integer[]{4, 1, 2, 1, 2}, 4),
                Arguments.of(new Integer[]{1}, 1),
                Arguments.of(new Integer[]{4, 1, 2, 2, 1}, 4),
                Arguments.of(new Integer[]{1, 2, 4, 2, 1}, 4)
        );
    }

    private static Stream<Arguments> MajorityElementsTestCases() {
        return Stream.of(
                Arguments.of(new Integer[]{3, 2, 3}, List.of(3)),
                Arguments.of(new Integer[]{1, 2}, List.of(1, 2)),
                Arguments.of(new Integer[]{1}, List.of(1)),
                Arguments.of(new Integer[]{1, 2, 3}, List.of()),
                Arguments.of(new Integer[]{1, 2, 3, 1}, List.of(1)),
                Arguments.of(new Integer[]{1, 2, 1, 2, 3}, List.of(1, 2)),
                Arguments.of(new Integer[]{1, 2, 3, 1, 2, 3, 1, 2, 3, 3}, List.of(3)),
                Arguments.of(new Integer[]{1, 2, 3, 4, 2, 3, 4, 2, 3, 4, 2, 3, 4, 2, 3, 4, 2, 3, 4}, List.of())
        );
    }

    private static Stream<Arguments> FindDuplicatesTestCases() {
        return Stream.of(
                Arguments.of(new int[]{4, 3, 2, 7, 8, 2, 3, 1}, List.of(2, 3)),
                Arguments.of(new int[]{1, 1, 2}, List.of(1)),
                Arguments.of(new int[]{1}, List.of()),
                Arguments.of(new int[]{1, 2, 3, 4, 3, 2}, List.of(3, 2))
        );
    }

    private static Stream<Arguments> CheckPerfectNumberTestCases() {
        return Stream.of(
                Arguments.of(28, true),
                Arguments.of(7, false),
                Arguments.of(100, false),
                Arguments.of(127, false),
                Arguments.of(8128, true),
                Arguments.of(6, true),
                Arguments.of(16, false),
                Arguments.of(1, false)
        );
    }

    private static Stream<Arguments> NumSubarrayLessThanKTestCases() {
        return Stream.of(
                Arguments.of(new int[]{10, 5, 2, 6}, 100, 8),
                Arguments.of(new int[]{1, 2, 3}, 0, 0),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6}, 60, 14),
                Arguments.of(new int[]{1, 5, 2, 6}, 70, 10),
                Arguments.of(new int[]{2, 2, 2, 2}, 9, 9)
        );
    }

    private static Stream<Arguments> ShuffleTestCases() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6}, 3, new int[]{1, 4, 2, 5, 3, 6}),
                Arguments.of(new int[]{1, 3, 5, 7, 2, 4, 6, 8}, 4, new int[]{1, 2, 3, 4, 5, 6, 7, 8}),
                Arguments.of(new int[]{1, 2, 3, 4, 4, 3, 2, 1}, 4, new int[]{1, 4, 2, 3, 3, 2, 4, 1})
        );
    }

    private static Stream<Arguments> SplitNumTestCases() {
        return Stream.of(
                Arguments.of(4325, 59),
                Arguments.of(687, 75),
                Arguments.of(987, 87)
        );
    }

    private static Stream<Arguments> MaxSubarrayLengthTestCases() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 1, 2, 3, 1, 2}, 2, 6),
                Arguments.of(new int[]{1, 2, 1, 2, 1, 2, 1, 2}, 1, 2),
                Arguments.of(new int[]{5, 5, 5, 5, 5, 5, 5}, 4, 4),
                Arguments.of(new int[]{1, 2, 3, 1, 2, 3, 1, 2, 4, 5, 3, 4, 2, 3}, 3, 12)
        );
    }

    private static Stream<Arguments> IsFascinatingTestCases() {
        return Stream.of(
                Arguments.of(123, false),
                Arguments.of(190, false),
                Arguments.of(334, false),
                Arguments.of(192, true),
                Arguments.of(327, true));
    }

    private static Stream<Arguments> RomanToIntTestCases() {
        return Stream.of(
                Arguments.of("III", 3),
                Arguments.of("LVIII", 58),
                Arguments.of("MCMXCIV", 1994),
                Arguments.of("IV", 4),
                Arguments.of("LIV", 54)
        );
    }

    public static Stream<Arguments> KidsWithCandiesTestCases() {
        return Stream.of(
                Arguments.of(new int[]{2, 3, 5, 1, 3}, 3, List.of(true, true, true, false, true)),
                Arguments.of(new int[]{4, 2, 1, 1, 2}, 1, List.of(true, false, false, false, false)),
                Arguments.of(new int[]{12, 1, 12}, 10, List.of(true, false, true)),
                Arguments.of(new int[]{12, 1, 11, 13, 14, 45, 93, 100}, 49, List.of(false, false, false, false, false, false, true, true))
        );
    }

    @BeforeEach
    public void setup() {
        this.serviceUnderTest = new NumberOperator();
    }

    @ParameterizedTest
    @MethodSource("ReverseTestCases")
    public void testReverse_withParameterizedInputs(int input, int expected) {
        // given & when
        final var actual = serviceUnderTest.reverse(input);

        // then
        then(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("IsPalindromeTestCases")
    public void testIsPalindrome_withParameterizedInputs(Integer input, Boolean expected) {
        // given & when
        final var actual = serviceUnderTest.isPalindrome(input);

        // then
        then(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("FirstMissingPositiveTestCases")
    public void testFirstMissingPositive_withParameterizedInputs(int[] input, int expected) {
        // given && when
        final var actual = serviceUnderTest.firstMissingPositive(input);

        // then
        then(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("SingleNumberTestCases")
    public void testSingleNumber_withParameterizedInputs(Integer[] input, Integer expected) {
        // given and when
        final var actual = serviceUnderTest.singleNumber(input);

        // then
        then(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("MajorityElementsTestCases")
    public void testMajorityElements_withParameterizedInputs(Integer[] input, List<Integer> expected) {
        // given & when
        final var actual = serviceUnderTest.majorityElement(input);

        // then
        then(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("FindDuplicatesTestCases")
    public void testFindDuplicates_withParameterizedInputs(int[] input, List<Integer> expected) {
        // given & when
        final var actual = serviceUnderTest.findDuplicates(input);

        // then
        then(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("CheckPerfectNumberTestCases")
    public void testCheckPerfectNumber_withParameterizedInputs(Integer input, boolean expected) {
        // given & when
        final var actual = serviceUnderTest.checkPerfectNumber(input);

        // then
        then(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("NumSubarrayLessThanKTestCases")
    public void testNumSubarrayProductLessThanK_withParameterizedInputs(int[] numbers, int max, int expected) {
        // given & when
        final var actual = serviceUnderTest.numSubarrayProductLessThanK(numbers, max);

        // then
        then(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("ShuffleTestCases")
    public void testShuffle_withParameterizedInputs(int[] nums, int n, int[] expected) {
        // when && then
        final var actual = serviceUnderTest.shuffle(nums, n);

        //then
        then(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("SplitNumTestCases")
    public void testSplitNum_withParameterizedInputs(int input, int expected) {
        // given && when
        final var actual = serviceUnderTest.splitNum(input);

        // then
        then(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("MaxSubarrayLengthTestCases")
    public void testMaxSubarrayLength_withParameterizedInputs(int[] nums, int max, int expected) {
        // given && when
        final var actual = serviceUnderTest.maxSubarrayLength(nums, max);

        // then
        then(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("IsFascinatingTestCases")
    public void testIsFascinating_withParameterizedInputs(Integer input, boolean expected) {

        //when
        final var actual = serviceUnderTest.isFascinating(input);

        //then
        then(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("RomanToIntTestCases")
    public void testRomanToInt_withParameterizedInputs(String input, Integer expected) {
        // given & when
        final var actual = serviceUnderTest.romanToInt(input);

        // then
        then(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("KidsWithCandiesTestCases")
    public void testKidsWithCandies_withParameterizedInputs(int[] candies, Integer extraCandies, List<Boolean> expected) {
        // given & when
        final var actual = serviceUnderTest.kidsWithCandies(candies, extraCandies);

        // then
        then(actual).isEqualTo(expected);
    }
}
