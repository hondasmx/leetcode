package leetcode.medium;

/**
 * You are given an integer array nums. You are initially positioned at the array's first index,
 * and each element in the array represents your maximum jump length at that position.
 * <p>
 * Return true if you can reach the last index, or false otherwise.
 */
public class JumpGame2_45 {

    public static void main(String[] args) {
        System.out.println(jump(new int[]{2, 3, 1, 1, 4}));//2
        System.out.println(jump(new int[]{2, 3, 0, 1, 4}));//2
        System.out.println(jump(new int[]{0}));//0
        System.out.println(jump(new int[]{1,2,3}));//2
        System.out.println(jump(new int[]{1,2}));//1
        System.out.println(jump(new int[]{2,1}));//1
        System.out.println(jump(new int[]{1,1,1,1}));//3
        System.out.println(jump(new int[]{2,3,1}));//1

    }

    public static int jump(int[] nums) {
        if (nums.length == 1) return 0;
        var idx = 0;
        var result = 0;
        while (idx < nums.length - 1) {
            var num = nums[idx];
            var maximumJumpIndex = idx + num;
            if (maximumJumpIndex >= nums.length - 1) {
                return ++result;
            }
            var maxNum = 0;
            var maxIdx = 0;
            for (int i = idx; i <= maximumJumpIndex; i++) {
                if (Math.max(maxNum, i + nums[i]) > maxNum) {
                    maxIdx = i;
                    maxNum = Math.max(maxNum, i + nums[i]);
                }
            }
            idx = maxIdx;
            result++;
        }
        return result;
    }

    public int jumpTrue(int[] nums) {
        // The starting range of the first jump is [0, 0]
        int answer = 0, n = nums.length;
        int curEnd = 0, curFar = 0;

        for (int i = 0; i < n - 1; ++i) {
            // Update the farthest reachable index of this jump.
            curFar = Math.max(curFar, i + nums[i]);

            // If we finish the starting range of this jump,
            // Move on to the starting range of the next jump.
            if (i == curEnd) {
                answer++;
                curEnd = curFar;
            }
        }

        return answer;
    }
}
