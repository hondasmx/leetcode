package leetcode.medium;

import java.util.Arrays;

/**
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 */
public class RotateArray_189 {

    public static void main(String[] args) {
        rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3); //Output: [5,6,7,1,2,3,4]
        rotate(new int[]{-1, -100, 3, 99}, 2); //Output: [3,99,-1,-100]
        rotate(new int[]{1,2}, 3); //Output: [2,1]
    }

    public static void rotate(int[] nums, int k) {
        var startIndex = k % nums.length;
        var subArray = Arrays.copyOfRange(nums, nums.length - startIndex, nums.length );
        System.arraycopy(nums, 0, nums, startIndex, nums.length - startIndex);
        System.arraycopy(subArray, 0, nums, 0, subArray.length);
        System.out.println(nums);
    }
}
