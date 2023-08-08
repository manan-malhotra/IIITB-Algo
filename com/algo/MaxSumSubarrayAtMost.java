/*
 * 21. Given a sequence of n numbers and an integer k, 
 * design a linear time algorithm to compute the length of the maximum sum sub array ,
 *  whos length is at most k
 */
package com.algo;
public class MaxSumSubarrayAtMost {

    public static void main(String[] args) {
        int[] nums = {-2,-6,-1,-4,-77,-2,-3};
        int k = 3;
        int maxSum = maxSumSubarrayLengthK(nums, k);
        System.out.println(maxSum);
    }

    public static int maxSumSubarrayLengthK(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int count = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            sum+=nums[i];
            maxSum = Math.max(maxSum, sum);
            count++;
            if(count==k){
                i=start++;
                sum=0;
                count=0;
            }
        }
        return maxSum;
    }

}
