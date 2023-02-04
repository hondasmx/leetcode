package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * <p>
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 */
public class PascalTriangle_118 {
    public static void main(String[] args) {
        System.out.println(generate(1));
        System.out.println(generate(2));
        System.out.println(generate(3));
        System.out.println(generate(4));
        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {
        var result = new ArrayList<List<Integer>>();
        result.add(List.of(1));
        if (numRows == 1) {
            return result;
        }

        for (int i = 2; i <= numRows; i++) {
            var row = new ArrayList<Integer>();
            row.add(1);


            if (i > 2) {
                var prevRow = result.get(i - 2);
                var index = 1;
                while (row.size() < i - 1) {
                    row.add(prevRow.get(index-1) + prevRow.get(index));
                    index++;
                }
            }

            row.add(1);
            if (row.size() == i) {
                result.add(row);
            }
        }

        return result;
    }
}
