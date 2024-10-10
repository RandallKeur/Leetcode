package com.leetcode.solutions.classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.BDDAssertions.then;

public class StringManipulationTest {


    private StringManipulation serviceUnderTest;

    private static Stream<Arguments> DefangIpAddressTestCases() {
        return Stream.of(
                Arguments.of("1.1.1.1", "1[.]1[.]1[.]1"),
                Arguments.of("255.100.50.0", "255[.]100[.]50[.]0")
        );
    }

    private static Stream<Arguments> ConvertZigZagTestCases() {
        return Stream.of(
                Arguments.of("PAYPALISHIRING", 3, "PAHNAPLSIIGYIR"),
                Arguments.of("PAYPALISHIRING", 4, "PINALSIGYAHRPI"),
                Arguments.of("A", 1, "A"),
                Arguments.of("PAYPALISHIRING", 6, "PRAIIYHNPSGAIL"),
                Arguments.of("PAYPALISHIRINGDEVELOPERS", 8, "PDAGEYNVPIEARLLIOSIHPRSE")
        );
    }

    private static Stream<Arguments> LongestCommonPrefixTestCases() {
        return Stream.of(
                Arguments.of(new String[]{"flower", "flow", "flight"}, "fl"),
                Arguments.of(new String[]{"dog", "racecar", "car"}, ""),
                Arguments.of(new String[]{"test", "tes", "testing", "tested"}, "tes")
        );
    }

    private static Stream<Arguments> IsValidParenthesisTestCases() {
        return Stream.of(
                Arguments.of("{}[]()", Boolean.TRUE),
                Arguments.of("{]", Boolean.FALSE),
                Arguments.of("{[()]]", Boolean.FALSE),
                Arguments.of("[", Boolean.FALSE)
        );
    }

    private static Stream<Arguments> LengthOfLastWordTestCases() {
        return Stream.of(
                Arguments.of("Hello World", 5),
                Arguments.of("   fly me   to   the moon  ", 4),
                Arguments.of("luffy is still joyboy", 6),
                Arguments.of("              ", 0)
        );
    }

    private static Stream<Arguments> IsIsomorphicTestCases() {
        return Stream.of(
                Arguments.of("egg", "add", true),
                Arguments.of("foo", "bar", false),
                Arguments.of("food", "eggs", true),
                Arguments.of("food", "acai", false),
                Arguments.of("paper", "title", true),
                Arguments.of("qwerasdfvcxz", "zxcvasdfqwer", true),
                Arguments.of("badc", "baba", false),
                Arguments.of("baba", "badc", false)
        );
    }

    private static Stream<Arguments> IsAnagramTestCases() {
        return Stream.of(
                Arguments.of("anagram", "nagaram", Boolean.TRUE),
                Arguments.of("rat", "car", Boolean.FALSE),
                Arguments.of("Listen", "Silent", Boolean.TRUE),
                Arguments.of("Save", "Vase", Boolean.TRUE),
                Arguments.of("savvy", "Save", Boolean.FALSE)
        );
    }

    private static Stream<Arguments> IsSubsequenceTestCases() {
        return Stream.of(
                Arguments.of("abc", "ahbgdc", true),
                Arguments.of("axc", "ahbgdc", false),
                Arguments.of("abbd", "adksjfdlkbdlsfkjdfbfe", false),
                Arguments.of("abbd", "asdfkjsdlfkbfsbfd", true),
                Arguments.of("abbbd", "abbbbbd", true),
                Arguments.of("abbbd", "abbd", false),
                Arguments.of("abbc", "aerebereb", false)
        );
    }

    private static Stream<Arguments> RepeatedSubstringPatternTestCases() {
        return Stream.of(
                Arguments.of("abab", true),
                Arguments.of("aba", false),
                Arguments.of("abcabcabcabc", true),
                Arguments.of("aa", true),
                Arguments.of("a", false)
        );
    }

    private static Stream<Arguments> CheckValidStringTestCases() {
        return Stream.of(
                Arguments.of("()", true),
                Arguments.of("(*)", true),
                Arguments.of("(*))", true),
                Arguments.of("(***()))", true)
        );
    }

    private static Stream<Arguments> RemoveDuplicatesTestCases() {
        return Stream.of(
                Arguments.of("abbaca", "ca"),
                Arguments.of("azxxzy", "ay"),
                Arguments.of("bbacbbddc", "a"),
                Arguments.of("baabcbbaabbc", ""),
                Arguments.of("abbacabcddcba", "c"),
                Arguments.of("abb", "a"),
                Arguments.of("bba", "a")
        );
    }

    private static Stream<Arguments> MinRemoveToMakeValidTestCases() {
        return Stream.of(
                Arguments.of("lee(t(c)o)de", "lee(t(c)o)de"),
                Arguments.of("a)b(c)d", "ab(c)d"),
                Arguments.of("))((", "")
        );
    }

    private static Stream<Arguments> MakeGoodTestCases() {
        return Stream.of(
                Arguments.of("leEeetcode", "leetcode"),
                Arguments.of("abBAcC", ""),
                Arguments.of("s", "s")
        );
    }

    private static Stream<Arguments> MinimizedStringLengthTestCases() {
        return Stream.of(
                Arguments.of("aaabc", 3),
                Arguments.of("cbbd", 3),
                Arguments.of("dddaaa", 2)
        );
    }

    private static Stream<Arguments> WithoutAdjacentTestCases() {
        return Stream.of(
                Arguments.of("aaaabcd", 4),
                Arguments.of("aaabacd", 5),
                Arguments.of("aaab", 2),
                Arguments.of("aabbaabac", 6),
                Arguments.of("cbbdb", 4)
        );
    }

    private static Stream<Arguments> ScoreOfStringTestCases() {
        return Stream.of(
                Arguments.of("hello", 13),
                Arguments.of("zaz", 50),
                Arguments.of("hh", 0),
                Arguments.of("rememberthetitans", 155)
        );
    }

    public static Stream<Arguments> FindWordsContainingTestCases() {
        return Stream.of(
                Arguments.of(new String[]{"leet", "code"}, "e", List.of(0, 1)),
                Arguments.of(new String[]{"abc", "bcd", "aaaa", "cbc"}, "a", List.of(0, 2)),
                Arguments.of(new String[]{"abc", "bcd", "aaaa", "cbc"}, "z", List.of())
        );
    }

    public static Stream<Arguments> CountCharactersTestCases() {
        return Stream.of(
                Arguments.of(new String[]{"cat","bt","hat","tree"}, "atach", 6),
                Arguments.of(new String[] {"hello","world","leetcode"}, "welldonehoneyr", 10),
                Arguments.of(new String[] {"hello","world","leetcode"}, "weldonehoneyr", 5)
        );
    }

    @BeforeEach
    public void setup() {
        this.serviceUnderTest = new StringManipulation();
    }

    @ParameterizedTest
    @MethodSource("DefangIpAddressTestCases")
    public void testDefangIpAddress_withParameterizedInputs(String input, String expected) {

        //when
        final var actual = serviceUnderTest.defangIPaddr(input);

        //then
        then(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("ConvertZigZagTestCases")
    public void testConvertZigZag_withParameterizedInputs(String input, int numberOfRows, String expected) {
        // given & when
        final var actual = serviceUnderTest.convertToZigZag(input, numberOfRows);

        // then
        then(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("LongestCommonPrefixTestCases")
    public void testLongestCommonPrefix_withParameterizedInputs(String[] input, String expected) {
        // given && when
        final var actual = serviceUnderTest.longestCommonPrefix(input);

        // then
        then(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("IsValidParenthesisTestCases")
    public void testIsValidParenthesis_withParameterizedInputs(String input, Boolean expected) {
        // given && when
        final var actual = serviceUnderTest.isValid(input);

        // then
        then(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("LengthOfLastWordTestCases")
    public void testLengthOfLastWord_withParameterizedInputs(String input, int expected) {
        // given & when
        final var actual = serviceUnderTest.lengthOfLastWord(input);

        // then
        then(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("IsIsomorphicTestCases")
    public void testIsomorphic_withParameterizedInputs(String input1, String input2, boolean expected) {
        // given and when
        final var actual = serviceUnderTest.isIsomorphic(input1, input2);

        // then
        then(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("IsAnagramTestCases")
    public void testAnagram_withParameterizedInputs(String firstWord, String secondWord, boolean expected) {
        // given & when
        final var actual = serviceUnderTest.isAnagram(firstWord, secondWord);

        // then
        then(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("IsSubsequenceTestCases")
    public void testIsSubsequence_withParameterizedInputs(String string1, String string2, Boolean expected) {
        // given and when
        final var actual = serviceUnderTest.isSubsequence(string1, string2);

        // then
        then(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("IsSubsequenceTestCases")
    public void testIsSubsequenceV2_withParameterizedInputs(String string1, String string2, Boolean expected) {
        // given and when
        final var actual = serviceUnderTest.isSubsequenceV2(string1, string2);

        // then
        then(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("RepeatedSubstringPatternTestCases")
    public void testRepeatedSubstringPattern_withParameterizedInputs(String input, boolean expected) {
        // given & when
        final var actual = serviceUnderTest.repeatedSubstringPattern(input);

        // then
        then(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("CheckValidStringTestCases")
    public void testCheckValidString_withParameterizedInputs(String input, Boolean expected) {
        // given && when
        final var actual = serviceUnderTest.checkValidString(input);

        // then
        then(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("RemoveDuplicatesTestCases")
    public void testRemoveDuplicates_withParameterizedInputs(String input, String expected) {

        //when
        final var actual = serviceUnderTest.removeDuplicates(input);

        //then
        then(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("MinRemoveToMakeValidTestCases")
    public void testMinRemoveToMakeValid_withParameterizedInputs(String input, String expected) {
        // when && then
        final var actual = serviceUnderTest.minRemoveToMakeValid(input);

        //then
        then(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("MakeGoodTestCases")
    public void testMakeGood_withParameterizedInputs(String input, String expected) {
        // given && when
        final var actual = serviceUnderTest.makeGood(input);

        // then
        then(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("MinimizedStringLengthTestCases")
    public void testMinimizedStringLength_withParameterizedInputs(String input, int expected) {
        //when
        final var actual = serviceUnderTest.minimizedStringLength(input);

        //then
        then(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("WithoutAdjacentTestCases")
    public void testWithoutAdjacentSolution_withParameterizedInputs(String input, int expected) {
        //when
        final var actual = serviceUnderTest.minimizedStringLengthWithoutAdjacentRepeatingCharacters(input);

        //then
        then(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("ScoreOfStringTestCases")
    public void testScoreOfString_withParameterizedTest(String input, Integer expected) {
        // given && when
        final var actual = serviceUnderTest.scoreOfString(input);

        // then
        then(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("FindWordsContainingTestCases")
    public void testFindWordsContaining_withParameterizedInputs(String[] word, Character character, List<Integer> expected) {
        // given && when
        final var actual = serviceUnderTest.findWordsContaining(word, character);

        // then
        then(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("CountCharactersTestCases")
    public void testCountCharacters_withParameterizedTest(String[] words, String chars, Integer expected) {
        // given && when
        final var actual = serviceUnderTest.countCharacters(words, chars);

        // then
        then(actual).isEqualTo(expected);
    }
}
