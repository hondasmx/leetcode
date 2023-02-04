package leetcode.medium;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Given a triangle array, return the minimum path sum from top to bottom.
 * For each step, you may move to an adjacent number of the row below.
 * More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
 */

public class Triangle_120 {

    public static void main(String[] args) {
        System.out.println(minimumTotal(List.of(
                Stream.of(2).collect(Collectors.toList()),
                Stream.of(3, 4).collect(Collectors.toList()),
                Stream.of(6, 5, 7).collect(Collectors.toList()),
                Stream.of(4, 1, 8, 3).collect(Collectors.toList())
        )));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        if (triangle.size() == 2) {
            return triangle.get(0).get(0) + Math.min(triangle.get(1).get(0), triangle.get(1).get(1));
        }

        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j < row.size(); j++) {
                Integer newValue = row.get(j);
                List<Integer> prevRow = triangle.get(i - 1);
                if (j == 0 ) {
                    newValue += prevRow.get(j);
                } else if (j == row.size() - 1) {
                    newValue += prevRow.get(j - 1);
                } else {
                    newValue += Math.min(prevRow.get(j - 1), prevRow.get(j));
                }
                row.set(j, newValue);
            }
        }
        return Collections.min(triangle.get(triangle.size() - 1));
    }
}
