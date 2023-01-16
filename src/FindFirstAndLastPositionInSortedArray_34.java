import java.util.Arrays;

/**
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 * If target is not found in the array, return [-1, -1].
 * You must write an algorithm with O(log n) runtime complexity.
 */

public class FindFirstAndLastPositionInSortedArray_34 {

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
//        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 4)));
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
    }

    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int startIndex = Arrays.binarySearch(nums, target);
        if (startIndex < 0) {
            return new int[]{-1, -1};
        }
        var endIndex = startIndex;

        while (startIndex > 0 && nums[startIndex - 1] == target) {
            startIndex--;
        }
        while (endIndex < nums.length - 1 && nums[endIndex + 1] == target) {
            endIndex++;
        }
        return new int[]{startIndex, endIndex};
    }
}
