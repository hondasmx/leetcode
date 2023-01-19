import java.util.ArrayList;
import java.util.Collections;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * Find the maximum profit you can achieve. You may complete at most two transactions.
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 */

public class BestTimeToBuyAndSellStokes3_123 {
    public static void main(String[] args) {
//        System.out.println(maxProfit(new int[]{3,3,5,0,0,3,1,4})); //6
//        System.out.println(maxProfit(new int[]{1,2,3,4,5})); //4
        System.out.println(maxProfit(new int[]{1, 2, 4, 2, 5, 7, 2, 4, 9, 0})); //13
        //Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
        //Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
        //Total profit is 4 + 3 = 7.

    }

    public static int maxProfit(int[] prices) {

        var result = new ArrayList<Integer>();
        var low = prices[0];
        var high = 0;
        for (int i = 1; i < prices.length; i++) {
            int current = prices[i];
            if (current < low) {
                result.add(Math.max(high - low, 0));
                low = current;
                high = 0;
            } else if (high < current) {
                high = current;
            } else {
                result.add(high - low);
                low = current;
                high = 0;
            }

            if (i == prices.length - 1 && high == current) {
                result.add(high - low);
            }
        }
        Collections.sort(result);
        Collections.reverse(result);
        return result.stream().limit(2).mapToInt(Integer::intValue).sum();
    }
}
