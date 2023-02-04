package leetcode.medium;

import java.util.*;

//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
//
//Notice that the solution set must not contain duplicate triplets.
public class ThreeSum_3 {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-2,0,1,1,2}));

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return List.of();
        }
        Arrays.sort(nums);
        var result = new HashSet<List<Integer>>();
        //до нуля потому что сумма положительных чисел - всегда положительна
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            twoSum(result, nums, i);
        }

        return new ArrayList<>(result);
    }

    private static void twoSum(Set<List<Integer>> result, int[] nums, int i) {
        var low = i + 1;
        var high = nums.length - 1;
        while (low < high) {
            var sum = nums[i] + nums[low] + nums[high];
            if (sum == 0) {
                result.add(List.of(nums[i], nums[low], nums[high]));
            } else if (sum > 0) {
                high--;
            } else {
                low++;
            }
        }
    }

    //O(n3)
//    public static List<List<Integer>> threeSum(int[] nums) {
//        if (nums.length < 3) {
//            return new ArrayList<>();
//        }
//        var result = new HashSet<List<Integer>>();
//        Arrays.sort(nums);
//        var i = 0;
//        var j = 1;
//        var k = 2;
//        while (i < nums.length - 2) {
//            while (j < nums.length - 1) {
//                if (i == j) {
//                    j++;
//                    continue;
//                }
//                while (k < nums.length) {
//                    if (j == k) {
//                        k++;
//                        continue;
//                    }
//                    if (nums[i] + nums[j] + nums[k] == 0) {
//                        result.add(List.of(nums[i], nums[j], nums[k]));
//                    }
//                    k++;
//                }
//                k = j + 1;
//                j++;
//            }
//            i++;
//            j = i + 1;
//            k = j + 1;
//        }
//        return result.stream().toList();
//    }
}
