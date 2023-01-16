import java.util.Arrays;

public class SearchInsertPosition_35 {

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 3, 3, 4}, 2));
    }

    public static int searchInsert(int[] nums, int target) {
        int result = Arrays.binarySearch(nums, target);
        return result < 0 ? Math.abs(result + 1) : result;
    }
}
