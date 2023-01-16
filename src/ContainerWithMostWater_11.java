//You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
//
//Find two lines that together with the x-axis form a container, such that the container contains the most water.
//
//Return the maximum amount of water a container can store.
//
//Notice that you may not slant the container.

public class ContainerWithMostWater_11 {

    public static void main(String[] args) {
        var nums = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(nums));
    }

    //квадратичная сложность
    public static int maxArea2(int[] height) {
        var result = 0;
        for (int index1 = 0; index1 < height.length; index1++) {
            int value1 = height[index1];
            for (int index2 = index1; index2 < height.length; index2++) {
                int value2 = height[index2];
                var current = Math.abs(index1 - index2) * Math.min(value2, value1);
                result = Math.max(result, current);
            }
        }
        return result;
    }

    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right])  * (right - left));
            if (height[left] < height[right])
                left++;
            else
                right--;
        }

        return maxArea;
    }
}
