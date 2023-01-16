import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("au"));
//
//        var s = "pwwkew";
//        System.out.println(Arrays.toString(s.split("a")));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        var startIndex = 0;
        var endIndex = 1;
        var result = 1;
        while (endIndex <= s.length()){
            var testString = s.substring(startIndex, endIndex);
            if (isDistinct(testString)) {
                endIndex++;
                if (testString.length() >= result) {
                    result = testString.length();
                }
            } else {
                startIndex++;
            }
            if (startIndex > endIndex) {
                endIndex = startIndex;
            }

        }
        return result;
    }

//    public static int lengthOfLongestSubstring(String s) {
//        if (s.length() == 0) {
//            return 0;
//        }
//        var result = 1;
//        var distinctChars = Arrays.stream(s.split("")).collect(Collectors.toSet());
//        for (String distinctChar : distinctChars) {
//            var splitted = s.split(distinctChar);
//            for (String split : splitted) {
//                if (isDistinct(split) && split.length() > result) {
//                    result = split.length() + 1;
//                }
//            }
//        }
//        return result;
//    }

    private static boolean isDistinct(String s) {
        return Arrays.stream(s.split("")).distinct().count() == s.length();
    }
}