package leetcode.sobes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class CodeSignal {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{25, 2, 3, 57, 38, 41})));
    }


    static int[] solution(int[] a) {
        var map = new HashMap<Integer, Integer>();
        for (int num: a) {
            var split = split(num);
            for (int splitted: split) {
                map.put(splitted, map.getOrDefault(splitted, 0) + 1);
            }
        }
        var maxValue = Collections.max(map.values());
        return map.entrySet().stream().filter(el->el.getValue() == maxValue).mapToInt(entry -> entry.getKey()).toArray();
    }

    static List<Integer> split(int num) {
        var result = new ArrayList<Integer>();
        while (num / 10 > 0) {
            result.add(num % 10);
            num = num / 10;
        }
        result.add(num);
        return result;
    }



}
