/*
 * Q16.  Given a sequence of n numbers, representing the stock prices of a stock on different days,
 *  design a linear time algorithm to compute the maximum profit
 *  that you can make by buying and selling a stock exactly once,
 *  you can sell a stock at least k days after you bought it.
 */
package com.algo;

import java.util.Arrays;

public class AtleastKDaysStock {

    public static void main(String[] args) {
        int[] prices = {10,9,8,7,6,5,4,3,2};
        int k = 3;
        System.out.println(atleastKDaysStock(prices,k));
    }

    private static int atleastKDaysStock(int[] prices,int k) {
        int maxi = Integer.MIN_VALUE;
        int n = prices.length;
        int[] s = new int[n];
        for(int i=n-1;i>=0;i--){
            maxi=Math.max(maxi,prices[i]);
            s[i]=maxi;
        }
        maxi = 0;
        System.out.println(Arrays.toString(s));
        for(int i=0;i<n-k;i++){
            maxi=Math.max(maxi, s[i+k]-prices[i]);
        }
        return maxi;
    }
    
}
