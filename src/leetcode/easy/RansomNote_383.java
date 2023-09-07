package leetcode.easy;

import java.util.HashMap;

/**
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from
 * magazine and false otherwise.
 * <p>
 * Each letter in magazine can only be used once in ransomNote.
 */

public class RansomNote_383 {

    public static void main(String[] args) {
//        System.out.println(canConstruct("a", "b")); //false
//        System.out.println(canConstruct("aa", "ab")); //false
        System.out.println(canConstruct("aa", "aab")); //true
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        var magazineMap = new HashMap<Character, Integer>();

        for (var s : magazine.toCharArray()) {
            magazineMap.put(s, magazineMap.getOrDefault(s, 0) + 1);
        }

        for (var key : ransomNote.toCharArray()) {
            if (magazineMap.getOrDefault(key, 0) <= 0) {
                return false;
            }
            magazineMap.put(key, magazineMap.get(key) - 1);
        }

        return true;
    }
}
