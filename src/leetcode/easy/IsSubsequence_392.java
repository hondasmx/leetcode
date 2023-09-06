package leetcode.easy;

/**
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 *
 * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the
 * characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 */

/**
 *
 */
public class IsSubsequence_392 {

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc")); //true
        System.out.println(isSubsequence("axc", "ahbgdc")); //false
        System.out.println(isSubsequence("aaaaaa", "bbaaaa")); //false
    }

    public static boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }
        String[] split = s.split("");
        for (int i = 0; i < split.length; i++) {
            String str = split[i];
            var index = t.indexOf(str);
            if (index == -1) {
                return false;
            }
            if (i == s.length() - 1 && index == t.length() - 1) {
                return true;
            }
            t = t.substring(index + 1);
        }

        return true;
    }
}
