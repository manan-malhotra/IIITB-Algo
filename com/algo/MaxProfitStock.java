/*
 * Q14. Given a sequence of n numbers, representing the stock prices of a stock on different days,
 *  design a linear time algorithm to compute the maximum profit that you can make by buying and 
 *  selling a stock exactly once, you can sell a stock only after you buy it
 */
package com.algo;

public class MaxProfitStock {

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        int maxPossible = 0;
        int leastPrice = Integer.MAX_VALUE ;
        int ifSoldToday = 0;
        for(int i:prices){
            if(i<leastPrice) leastPrice = i;
            ifSoldToday = i - leastPrice;
            if(ifSoldToday>maxPossible) maxPossible = ifSoldToday;
        }
        return maxPossible;
    }
}
