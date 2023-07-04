package leetcode.easy;


/**
 * You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be
 * planted in adjacent plots.
 * <p>
 * Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer
 * n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and
 * false otherwise.
 */
public class CanPlaceFlowers_605 {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true;

        var startIndex = 0;
        var endIndex = 1;
        for (int i = 1; i < flowerbed.length; i++) {
            int current = flowerbed[i];
            if (current == 0) {
                endIndex++;
                continue;
            }
            var diff = endIndex - startIndex - 1;
            if ((startIndex == 0 || endIndex == flowerbed.length - 1) && diff >=2) {
                n -= diff / 2;
            }
            else if (diff >= 3)  {
                n -= 1 + ((diff - 3) / 2);
            }
            startIndex = i;
            endIndex = i;
        }

        return n <=0;
    }
}
