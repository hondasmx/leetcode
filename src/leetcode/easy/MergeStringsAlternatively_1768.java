package leetcode.easy;

/**
 * You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with
 * word1.
 * If a string is longer than the other, append the additional letters onto the end of the merged string.
 * Return the merged string.
 */
public class MergeStringsAlternatively_1768 {

    public static void main(String[] args) {
        System.out.println(mergeAlternately("abc", "pqr")); //apbqcr
        System.out.println(mergeAlternately("ab", "pqrs")); //apbqrs
        System.out.println(mergeAlternately("abcd", "pq")); //apbqcd
        assert mergeAlternately("abc", "pqr").equals("apbqcr");
        assert mergeAlternately("ab", "pqrs").equals("apbqrs");
        assert mergeAlternately("abcd", "pq").equals("apbqcd");
    }

    public static String mergeAlternately(String word1, String word2) {
        var length = Math.max(word1.length(), word2.length());
        var result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (word1.length() > i) {
                result.append(word1.charAt(i));
            }
            if (word2.length() > i) {
                result.append(word2.charAt(i));
            }
        }

        return result.toString();
    }

}
