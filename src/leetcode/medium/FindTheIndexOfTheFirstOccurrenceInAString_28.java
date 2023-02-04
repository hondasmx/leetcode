package leetcode.medium;

/**
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack,
 * or -1 if needle is not part of haystack.
 */

public class FindTheIndexOfTheFirstOccurrenceInAString_28 {

    public static void main(String[] args) {
        System.out.println(strStr("sadbutsad", "sad"));
        System.out.println(strStr("leetcode", "leeto"));
        System.out.println(strStr("a", "a"));
        System.out.println(strStr("abc", "c"));
    }

    public static int strStr(String haystack, String needle) {
        var length = needle.length();
        var firstLetter = needle.charAt(0);
        for (int i = 0; i < haystack.length() - length + 1; i++) {
            var currentChar = haystack.charAt(i);
            if (firstLetter == currentChar) {
                var substring = haystack.substring(i, i + length);
                if (substring.equals(needle)) {
                    return i;
                }
            }
        }
        return -1;
    }
}
