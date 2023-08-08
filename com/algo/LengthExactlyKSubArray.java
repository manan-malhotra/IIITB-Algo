/*
 * Q19. Given a sequence of n numbers and an integer k, design a linear time algorithm
 *  to compute the length of the maximum sum sub array , whos length is exactly k.
 */

package com.algo;

import java.util.Arrays;
import java.util.List;

public class LengthExactlyKSubArray {

    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(-2, -3, 4, -1, -2, 1, 5, -3);
	    System.out.println(maxSubarraySumExactlyK(a,3));
    }

    private static long maxSubarraySumExactlyK(List<Integer> Arr,int K) {
        int N = Arr.size();
        long res = 0;
        for(int i=0;i<K;i++){
            res+=Arr.get(i);
        }
        long maxi = res;
        for(int i=K;i<N;i++){
            res+=Arr.get(i);
            res-=Arr.get(i-K);
            maxi = Math.max(maxi,res);
        }
        return maxi;
        
    }
    
}
