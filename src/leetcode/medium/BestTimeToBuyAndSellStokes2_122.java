package leetcode.medium;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */

public class BestTimeToBuyAndSellStokes2_122 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4})); //7
        System.out.println(maxProfit(new int[]{1, 2, 3, 4, 5})); //4
        System.out.println(maxProfit(new int[]{2, 4, 1})); //2
        //Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
        //Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
        //Total profit is 4 + 3 = 7.

    }

    //true solution
    public int maxProfitTrue(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }

    public static int maxProfit(int[] prices) {

        var result = 0;
        var low = prices[0];
        var high = 0;
        for (int i = 1; i < prices.length; i++) {
            int current = prices[i];
            if (current < low) {
                result += Math.max(high - low, 0);
                low = current;
                high = 0;
            } else if (high < current) {
                high = current;
            } else {
                result += high - low;
                low = current;
                high = 0;
            }

            if (i == prices.length - 1 && high == current) {
                result += high - low;
            }
        }

        return result;
    }
}
