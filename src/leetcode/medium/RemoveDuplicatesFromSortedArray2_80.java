package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique
 * element appears at most twice.
 * The relative order of the elements should be kept the same.
 * <p>
 * Since it is impossible to change the length of the array in some languages, you must instead have the result be
 * placed in
 * the first part of the array nums. More formally, if there are k elements after removing the duplicates,
 * then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first
 * k elements.
 * <p>
 * Return k after placing the final result in the first k slots of nums.
 * <p>
 * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1)
 * extra memory.
 */
public class RemoveDuplicatesFromSortedArray2_80 {

    public static void main(String[] args) {
        removeDuplicates(new int[]{1, 1, 1, 2, 2, 3}); //Output: 5, nums = [1,1,2,2,3,_]
        removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3});  //Output: 7, nums = [0,0,1,1,2,3,3,_,_]
    }

    public static int removeDuplicates(int[] nums) {
        var duplicateCount = 0;
        var prevNum = nums[0];
        var indexesToRemove = new ArrayList<Integer>();
        for (int i = 1; i < nums.length; i++) {
            if (prevNum == nums[i]) {
                duplicateCount++;
            } else {
                duplicateCount = 0;
            }

            if (duplicateCount > 1) {
                indexesToRemove.add(i - indexesToRemove.size());
            }
            prevNum = nums[i];
        }
        for (var idx : indexesToRemove) {
            removeElement(nums, idx);
        }
        return nums.length - indexesToRemove.size();

    }

    public static void removeElement(int[] arr, int removedIdx) {
        System.arraycopy(arr, removedIdx + 1, arr, removedIdx, arr.length - 1 - removedIdx);
    }
}
