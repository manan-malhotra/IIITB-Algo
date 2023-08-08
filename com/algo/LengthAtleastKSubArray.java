/*
 * Q20. Given a sequence of n numbers and an integer k, 
 * design a linear time algorithm to compute the length of the maximum sum sub array ,
 *  whos length is at least k
 */

package com.algo;

public class LengthAtleastKSubArray {

    public static void main(String[] args) {
        long[] a = {4, -3, 4, -1, -2, 1, 5, -3};
	    System.out.println(maxSubarraySumAtleastK(a,3));
    }

    private static long maxSubarraySumAtleastK(long a[], long k) {
         long sum = 0;
        for (int i = 0; i < k; i++) {
            sum += a[i];
        }
        long n = a.length;
        long prev = 0;
        int j = 0;
        long maxi = Long.MIN_VALUE;
        maxi = Math.max(maxi, sum);
        for(long i=k;i<n;i++){
            sum+=a[(int)i];
            prev+=a[j++];
            if(prev<0){
                sum-=prev;
                prev=0;
            }
            maxi = Math.max(maxi, sum);
        }
        return maxi;
    }
    
}
