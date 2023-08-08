/*
 * Q12. Given a array A of numbers , write an O(n log n) time algorithm to compute array B,
 *  such that B[i] = j,j is the smallest j such that A[j] < A[i].B[i] = −1 
 * if all the numbers to the left of A[i] are greater than or equal to A[i].
 */

package com.algo;

import java.util.Arrays;

public class FirstSmallerArray {
    public static void main(String[] args) {
        int[] a = {12,5,2,0,1,2,6,9,25,7};
        int[] b = firstSmallerArray(a);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }

    private static int[] firstSmallerArray(int[] arr) {
        int n = arr.length;
        int[] b = new int[n];
        int[] s = new int[n];
        int top = -1;
        for (int i = 0; i < arr.length; i++) {
            if(top==-1 || arr[i]<arr[s[top]]){
                // System.out.println(arr[i]);
                b[i]=-1;
                s[++top]=i;
            }else{
                b[i]=binarySearchMinimum(s,arr,0,top,arr[i]);
            }
            
        }
        return b;
    }

    private static int binarySearchMinimum(int[] s, int[] arr,int start, int end,int target) {
        int potentialAns = -1;
        // System.out.println(target+" target " + end);
        // System.out.println(Arrays.toString(s));
        while(start<=end){
            int mid = start + (end-start)/2;
            if(arr[s[mid]]<target){
                potentialAns = mid;
                end = mid-1;
            }else{
                start=mid+1;
            }
        }
        if(potentialAns==-1) return -1;
        return s[potentialAns];
    }
}
