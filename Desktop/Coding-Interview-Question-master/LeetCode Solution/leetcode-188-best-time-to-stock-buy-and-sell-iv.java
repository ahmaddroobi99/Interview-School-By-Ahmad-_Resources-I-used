/*
    Title: 188. Best Time to Buy and Sell Stock IV
    
    Description: You are given an integer array prices where prices[i] is the price of a             given stock on the ith day.
    Design an algorithm to find the maximum profit. You may complete at most k transactions.
    Notice that you may not engage in multiple transactions simultaneously (i.e., you must           sell the stock before you buy again).
    
    Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
    
*/

class Solution {
    public int maxProfit(int k, int[] prices) {
        if(k >= prices.length) {  // Same as Problem 122. Best Time to Buy and Sell Stock II
            int maxProfit = 0;
            for(int i = 1; i < prices.length; i++)
                if(prices[i] > prices[i - 1])
                    maxProfit += prices[i] - prices[i - 1];
            return maxProfit;
        }
		
        int T[][] = new int[k+1][prices.length];
        for (int i = 1; i < T.length; i++) {
            int maxDiff = -1 * prices[0];
            for (int j = 1; j < T[0].length; j++) {
                T[i][j] = Math.max(T[i][j-1], prices[j] + maxDiff);
                maxDiff = Math.max(maxDiff, T[i-1][j] - prices[j]);
            }
        }
        return T[k][prices.length-1];
    }
}
