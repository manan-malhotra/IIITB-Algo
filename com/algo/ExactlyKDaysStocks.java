/*
 * Q15
 * Given a sequence of n numbers, representing the stock prices of a stock on different days,
 *  design a linear time algorithm to compute the maximum profit that you can make by buying
 *  and selling a stock exactly once, you can sell a stock exactly k days after you bought it
 * 
 */
package com.algo;

public class ExactlyKDaysStocks {

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(exactlyKDays(prices,2));
    }

    private static int exactlyKDays(int[] prices,int k) {
        // int ifSoldToday = 0;
        // int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        int n = prices.length;
        for(int i=0;i<n-k;i++){
            maxProfit = Math.max(prices[k+i]-prices[i],maxProfit);
        }
        return maxProfit;
    }
    
}
