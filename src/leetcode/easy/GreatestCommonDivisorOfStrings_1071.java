package leetcode.easy;

/**
 * For two strings s and t, we say "t divides s" if and only if s = t + ... + t (i.e., t is concatenated with itself
 * one or more times).
 * Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
 */
public class GreatestCommonDivisorOfStrings_1071 {

    public static void main(String[] args) {
        assert gcdOfStrings("ABCABC", "ABC").equals("ABC");
        assert gcdOfStrings("ABABAB", "ABAB").equals("AB");
        assert gcdOfStrings("LEET", "CODE").equals("");
    }

    public static int gcd(int x, int y) {
        if (y == 0) {
            return x;
        } else {
            return gcd(y, x % y);
        }
    }

    public static String gcdOfStrings(String str1, String str2) {
        // Check if they have non-zero GCD string.
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        // Get the GCD of the two lengths.
        int gcdLength = gcd(str1.length(), str2.length());
        return str1.substring(0, gcdLength);
    }
}
