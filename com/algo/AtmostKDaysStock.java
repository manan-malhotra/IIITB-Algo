/*
 * Q17 Given a sequence of n numbers, representing the stock prices of a stock on different days,
 *  design a linear time algorithm to compute the maximum profit that you can make by buying and selling a stock exactly once,
 *  you can sell a stock at most k days after you bought it.
 */

package com.algo;

public class AtmostKDaysStock {

    public static void main(String[] args) {
        int[] prices = {1,3,1,3,5,3,6,7};
        int k = 3;
        System.out.println(atmostKDaysStock(prices,k));
    }
    private static int atmostKDaysStock(int[] prices, int k) {
        int[] s = maxSlidingWindow(prices, k);
        int maxi = 0;
        for (int i = 0; i < s.length; i++) {
            maxi = Math.max(maxi, s[i]-prices[i]);
        }
        return maxi;
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(k==1) return nums;
        int n = nums.length;
        int[] dq = new int[n];
        int[] ans = new int[n];
        int start=-1;
        int end=-1;
        for(int i=n-1;i>=0;i--){
            if(end==-1){ // dq is empty
                start++;
                dq[++end]=i;
            }else if(nums[i]<=nums[dq[end]]){ // nums[i] is smaller
                dq[++end]=i;
                
            }else{
                while(end>=0 && nums[i]>nums[dq[end]] && end>=start){
                    end--;
                }
                end++;
                dq[end]=i;
            }
            if(start!=-1 && i==dq[start]-k){
                start++;
            }
            // if(i<ans.length) 
            ans[i]=nums[dq[start]];
        }
        return ans;
    }
    
}
