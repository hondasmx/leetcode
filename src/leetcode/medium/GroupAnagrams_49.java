package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 */
public class GroupAnagrams_49 {

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));

    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        var result = new HashMap<String, List<String>>();
        for (var str : strs) {
            var ca = str.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!result.containsKey(key)) {
                result.put(key, new ArrayList<>());
            }
            result.get(key).add(str);
        }

        return result.values().stream().toList();
    }
}
