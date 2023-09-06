package leetcode.medium;

import java.util.Arrays;

public class MinimumSizeSubarraySum_209 {

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3})); //2
        System.out.println(minSubArrayLen(4, new int[]{1, 4, 4})); //1
        System.out.println(minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1})); //0
        System.out.println(minSubArrayLen(11, new int[]{1, 2, 3, 4, 5})); //3
    }

    public static int minSubArrayLen(int target, int[] nums) {
        if (Arrays.stream(nums).sum() < target) {
            return 0;
        }

        var startIndex = 0;
        var endIndex = 0;
        var result = nums.length - 1;
        var sum = nums[0];
        while (startIndex < nums.length && endIndex < nums.length) {
            if (sum >= target) {
                result = Math.min(result, endIndex - startIndex);
                sum -= nums[startIndex];
                startIndex++;
            } else {
                endIndex++;
                if (endIndex < nums.length) {
                    sum += nums[endIndex];
                }
            }
        }
        return result + 1;
    }
}
