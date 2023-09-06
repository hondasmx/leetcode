package leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.lang.System.out;

/**
 * You are given a string s and an array of strings words. All the strings of words are of the same length.
 * A concatenated substring in s is a substring that contains all the strings of any permutation of words concatenated.
 * For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab" are
 * all concatenated strings.
 * "acdbef" is not a concatenated substring because it is not the concatenation of any permutation of words.
 * Return the starting indices of all the concatenated substrings in s. You can return the answer in any order.
 */
public class SubstringWithConcatenationOfAllWords_30 {

    public static void main(String[] args) {
        out.println(findSubstring("barfoothefoobarman", new String[]{"foo", "bar"})); //[0,9]
        out.println(findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "word"})); //[]
        out.println(findSubstring("barfoofoobarthefoobarman", new String[]{"bar", "foo", "the"})); //[6,9,12]
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        var length = words[0].length();
        var result = new ArrayList<Integer>();
        var startIndex = 0;
        var endIndex = length * words.length;
        var counts = new HashMap<String, Integer>();
        for (String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }
        while (endIndex <= s.length()) {
            var substring = s.substring(startIndex, endIndex);
            if (isConcatString(substring, counts, length)) {
                result.add(startIndex);
            }
            startIndex++;
            endIndex++;
        }
        return result;
    }

    private static boolean isConcatString(String substring, HashMap<String, Integer> words, int wordLength) {
        var result = new HashMap<String, Integer>();
        for (int i = 0; i < substring.length(); i+= wordLength) {
            var substr = substring.substring(i, i + wordLength);
            result.put(substr, result.getOrDefault(substr, 0) + 1);
        }
        return words.equals(result);
    }
}
