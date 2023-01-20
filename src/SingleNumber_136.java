import java.util.Arrays;
import java.util.HashSet;

/**
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 */
public class SingleNumber_136 {

    public static void main(String[] args) {
//        System.out.println(singleNumber(new int[]{2, 2, 1})); //1
//        System.out.println(singleNumber(new int[]{4, 1, 2, 1, 2})); //4
        System.out.println(singleNumber(new int[]{1, 0, 1})); //0
    }

    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        if (nums.length == 1) {
            return nums[0];
        }
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (i < nums.length - 1 && num == nums[i + 1]) {
                continue;
            }
            if (i > 0 && num == nums[i - 1]) {
                continue;
            }

            return num;
        }
        return 0;
    }

    public int singleNumber_true(int[] nums) {
        int sumOfSet = 0, sumOfNums = 0;
        var set = new HashSet<Integer>();

        for (int num : nums) {
            if (!set.contains(num)) {
                set.add(num);
                sumOfSet += num;
            }
            sumOfNums += num;
        }
        return 2 * sumOfSet - sumOfNums;
    }
}
