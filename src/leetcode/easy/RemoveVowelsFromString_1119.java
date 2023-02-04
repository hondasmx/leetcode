package leetcode.easy;

import java.util.List;

/**
 * Given a string s, remove the vowels 'a', 'e', 'i', 'o', and 'u' from it, and return the new string.
 */
public class RemoveVowelsFromString_1119 {

    public String removeVowels(String s) {
        var result = new StringBuilder();
        var vowels = List.of('a', 'e', 'i','o', 'u');
        for (var i = 0; i < s.length(); i++) {
            var ch = s.charAt(i);
            if (!vowels.contains(ch)) {
                result.append(ch);
            }
        }
        return result.toString();
    }
}
