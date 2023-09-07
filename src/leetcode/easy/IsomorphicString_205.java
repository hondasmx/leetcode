package leetcode.easy;

import java.util.HashMap;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * <p>
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 * <p>
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character, but a character may map to itself.
 */

public class IsomorphicString_205 {

    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add")); //true
        System.out.println(isIsomorphic("foo", "bar")); //false
        System.out.println(isIsomorphic("paper", "title")); //true
        System.out.println(isIsomorphic("bbbaaaba", "aaabbbba")); //false
    }

    public static boolean isIsomorphic(String s, String t) {
        var list1 = new HashMap<Character, Integer>();
        var list2 = new HashMap<Character, Integer>();

        for (char c : s.toCharArray()) {
            list1.put(c, list1.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            list2.put(c, list2.getOrDefault(c, 0) + 1);
        }

        return list1.values()
                    .stream()
                    .sorted()
                    .toList()
                    .equals(list2.values().stream().sorted().toList())
                && !list1.keySet().equals(list2.keySet());
    }
}
