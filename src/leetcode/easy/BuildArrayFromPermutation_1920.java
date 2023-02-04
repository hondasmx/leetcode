package leetcode.easy;

import java.util.Arrays;

public class BuildArrayFromPermutation_1920 {

    public int[] buildArray(int[] nums) {
        return Arrays.stream(nums).map(num -> nums[num]).toArray();
    }
}
