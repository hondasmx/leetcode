package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an input string s, reverse the order of the words.
 * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
 * Return a string of the words in reverse order concatenated by a single space.
 * Note that s may contain leading or trailing spaces or multiple spaces between two words.
 * The returned string should only have a single space separating the words. Do not include any extra spaces.
 */
public class ReverseWordsInAString_151 {

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue")); //"blue is sky the"
        System.out.println(reverseWords(" hello world  ")); //"world hello"
        System.out.println(reverseWords("a good   example")); //"example good a"
    }

    public static String reverseWords(String s) {
        var result = new ArrayList<String>();
        Arrays.stream(s.split(" "))
                            .map(String::trim)
                            .filter(el -> !el.isEmpty())
                            .forEach(el-> result.add(0, el));
        return String.join(" ", result);
    }
}
