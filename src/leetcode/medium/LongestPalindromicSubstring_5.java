package leetcode.medium;

public class LongestPalindromicSubstring_5 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("bppbsooos"));
    }

    public static String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }

        var result = "";
        for (int i = 1; i < s.length(); i++) {
            var minIndex = i;
            var maxIndex = i;
            while (minIndex - 1 >= 0 && s.charAt(minIndex - 1) == s.charAt(minIndex)) {
                minIndex--;
            }
            while (maxIndex + 1 < s.length() && s.charAt(maxIndex + 1) == s.charAt(maxIndex)) {
                maxIndex++;
            }
            var increment = 0;
            while (minIndex - increment >= 0
                    && maxIndex + increment < s.length()
                    && s.charAt(minIndex - increment) == s.charAt(maxIndex + increment)) {
                increment++;
            }
            if (increment * 2 + (maxIndex - minIndex) > result.length()) {
                result = s.substring(minIndex - increment + 1, maxIndex + increment);
            }
        }

        return result;
    }
}
