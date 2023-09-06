package leetcode.medium;

import java.util.Arrays;

/**
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
 * find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and
 * numbers[index2] where 1 <= index1 < index2 < numbers.length.
 * Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of
 * length 2.
 * The tests are generated such that there is exactly one solution. You may not use the same element twice.
 * Your solution must use only constant extra space.
 */
public class TwoSum2_167 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9))); //[1,2]
        System.out.println(Arrays.toString(twoSum(new int[]{2, 3, 4}, 6))); //[1,3]
        System.out.println(Arrays.toString(twoSum(new int[]{-1, 0}, -1))); //[1,2]
    }

    public static int[] twoSum(int[] numbers, int target) {
        var startIndex = 0;
        var endIndex = numbers.length - 1;
        for (int i = 0; i < numbers.length; i++) {
            var min = numbers[startIndex];
            var max = numbers[endIndex];
            var sum = min + max;
            if (sum == target) break;
            if (sum > target) {
                endIndex--;
            } else {
                startIndex++;
            }
        }
        return new int[] {++startIndex, ++endIndex};
    }
}
