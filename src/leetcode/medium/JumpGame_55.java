package leetcode.medium;

/**
 * You are given an integer array nums. You are initially positioned at the array's first index,
 * and each element in the array represents your maximum jump length at that position.
 * <p>
 * Return true if you can reach the last index, or false otherwise.
 */
public class JumpGame_55 {

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));//true
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));//false
        System.out.println(canJump(new int[]{2, 0}));//true
        System.out.println(canJump(new int[]{2, 0, 0}));//true
    }

    public static boolean canJump(int[] nums) {
        int currMaximum = 0;
        int checker = 0;
        if(nums.length == 1){
            return true;
        }
        for(int i = 0 ; i < nums.length -1 ; i++){
            currMaximum = Math.max(currMaximum , nums[i] + i);
            if(checker == i){
                checker = currMaximum;
            }
            if(currMaximum >= nums.length-1){
                return true;
            }
            if(nums[checker]==0 && i==checker){
                return false;
            }
        }
        return true;
    }
}
