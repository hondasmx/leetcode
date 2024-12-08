package leetcode.easy;

import java.util.Arrays;

public class TwoSum_1 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{0, 2, 3, 1}, 4)));
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int num1 = nums[j];
                int sum = num + num1;
                if (sum == target) {
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }

}
