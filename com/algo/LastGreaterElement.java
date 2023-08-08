/*
 * Q13 Given a array A of numbers , write an O(n log n) linear time algorithm to compute array B, 
 * such that B[i] = j, j is the largest j such that A[j] > A[i].B[i] = n 
 * if all the numbers to the right of A[i] are less than or equal to A[i]
 */

package com.algo;

import java.util.Arrays;

public class LastGreaterElement {

    public static void main(String[] args) {
        int[] a = {9,9,99,9,9,9,9};
        int[] b = lastGreaterElement(a);
        System.out.println(Arrays.toString(b));
        
    }

    private static int[] lastGreaterElement(int[] arr) {
        int n = arr.length;
        int[] b = new int[n];
        int[] s = new int[n];
        int top = -1;
        for (int i = n-1; i >= 0; i--) {
            if(top==-1 || arr[s[top]]<arr[i]){
                b[i]=n+1;
                s[++top]=i;
            }else{
                b[i]=binarySearchMaximum(s,arr,0,top,arr[i]);
            }
        }
        return b;
    }

    private static int binarySearchMaximum(int[] s, int[] arr, int start, int end, int target) {
        int potentialAns = -1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(arr[s[mid]]>target){
                potentialAns = mid;
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        if(potentialAns==-1) return arr.length+1;
        return s[potentialAns];
    }
    
}
