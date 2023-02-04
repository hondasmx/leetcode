package leetcode.medium;

import java.util.Arrays;

//Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
//
//Return the sum of the three integers.
//
//You may assume that each input would have exactly one solution.
public class ThreeSumClosest_16 {
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-2, 0, 1, 1, 2}, 1));

    }

    public static int threeSumClosest(int[] nums, int target) {
        if (nums.length == 3) {
            return nums[0] + nums[1] + nums[2];
        }
        Arrays.sort(nums);
        var result = nums[0] + nums[1] + nums[2];
        var diff = Math.abs(target - result);
        for (int i = 0; i < nums.length; i++) {
            result = twoSum(target, result, diff, nums, i);
            diff = Math.abs(target - result);
        }

        return result;
    }

    private static int twoSum(int target, int result, int diff, int[] nums, int i) {
        var low = i + 1;
        var high = nums.length - 1;
        while (low < high) {
            var sum = nums[i] + nums[low] + nums[high];
            int abs = Math.abs(sum - target);
            if (abs < diff) {
                diff = abs;
                result = sum;
            }
            if (sum > target) {
                high--;
            } else {
                low++;
            }
        }
        return result;
    }

}
