package leetcode.easy;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */

public class BestTimeToBuyAndSellStokes_121 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4})); // 6 - 1 = 5
        System.out.println(maxProfit(new int[]{2, 5, 1, 6})); // 6 - 1 = 5
        System.out.println(maxProfit(new int[]{3, 2, 1})); // 6 - 1 = 5

    }

    public static int maxProfit(int[] prices) {

        int maxProfit = 0;
        int currentMin = Integer.MAX_VALUE;
        for (int price : prices) {
            if (currentMin > price) {
                currentMin = price;
            }

            var curProfit = price - currentMin;
            maxProfit = Math.max(curProfit, maxProfit);
        }

        return maxProfit;
    }
}
