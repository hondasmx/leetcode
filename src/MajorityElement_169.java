import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Given an array nums of size n, return the majority element.
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 * You may assume that the majority element always exists in the array.
 */


public class MajorityElement_169 {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{2,2,1,1,1,2,2}));
        System.out.println(majorityElement(new int[]{3,2,3,1,1,1,4,5,6,123}));

    }
    public static int majorityElement(int[] nums) {
        var collect = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        for (var integerLongEntry : collect.entrySet()) {
            if (integerLongEntry.getValue() > nums.length / 2) {
                return integerLongEntry.getKey();
            }
        }
        return 0;
    }


    public int majorityElement_true(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
