/*
 * Q18. Given a sequence of n numbers design a linear time algorithm to compute
 * the length of the maximum sum sub array
 */

package com.algo;

import java.util.Arrays;
import java.util.List;

public class LengthMaximumSubArray {

    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(5,-5,3,2,7,-8,2,6,-3);
	    System.out.println(maxSubarraySum(a));
    }

    private static int maxSubarraySum(List<Integer> a) {
        int n = a.size();
        int length = 0;
        int maxLen = 0;
        int sum = 0;
        int maxSum = 0;
            for(int i=0;i<n;i++){
                sum+=a.get(i);
                if(sum<0){
                    sum=0;
                    length=0;
                } else{
                    length++;
                    if(sum>=maxSum){
                        maxSum=sum;
                        maxLen=Math.max(maxLen,length);
                    }
                }
            }
        return maxLen;
    }
    
}
