/*
 * Q3. Given a binary string of length n, design a linear time algorithm
 *  to compute the length of the largest sub-string which contains equal number of 0’s and 1’s.
 */
package com.algo;

import java.util.HashMap;

public class EqualNumberOf0sand1s {

    public static void main(String[] args) {
        int[] arr = {1,0,0,1,1,0,1,0,0,0,0,1};
        System.out.println(equalNumberOf0sand1s(arr,arr.length));
        
    }

    public static int equalNumberOf0sand1s(int[] arr, int N)
    {
        // Your code here
        int c1=0,c0=0,maxlen=0;
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        hm.put(0,-1);
        for(int i=0;i<arr.length;i++){
            if(arr[i]==1){
                c1++;
            }else{
                c0++;
            }
            if(!hm.containsKey(c1-c0)){
                hm.put(c1-c0,i);
            }else{
                maxlen = Math.max(maxlen,i-hm.get(c1-c0));
            }
        }
        return maxlen;
    }
    
}
