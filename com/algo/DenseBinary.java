/*
Q1. A binary string is called dense if the number of 1’s in the string is more than the number of 0’s.
For example 1, 101,110101 are dense, but 10, 1001,100001 are not dense.
Given a binary string of length n, design an O(n log n) time algorithm to compute the 
number of dense sub-strings of the given string. For example, given 10101, the answer is 6.
*/ 

package com.algo;

import java.util.ArrayList;

public class DenseBinary{
    public static void main(String[] args) {
        String arr = "111";
        System.out.println(denseBinary(arr));
    }

    public static int denseBinary(String arr){
        int n = arr.length();
        int[] pre = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if(arr.charAt(i)=='1'){
                pre[i]=1;
            }else{
                pre[i]=-1;
            }
        }
        for (int i = 1; i < n; i++) {
            pre[i]+=pre[i-1];
        }
        for (int i = 0; i < n/2; i++) {
            swap(pre,i,n-i-1);
        }
        for(int i:pre){
            if(i>0) count++;
        }
        
        count += mergeModified(pre,0,n-1);

        return count;
    }
    private static int mergeModified(int[] arr, int start, int end) {
        int count = 0;
        if(start>=end) return count;
        int mid = (start+end)/2;
        count += mergeModified(arr, start, mid);
        count += mergeModified(arr, mid+1, end);
        count += merge(arr,start,mid,end);
        return count;
    }

    private static int merge(int[] a, int start, int mid, int end) {
        ArrayList<Integer> temp = new ArrayList<>(); 
        int left = start;      // starting index of left half of arr
        int right = mid + 1;   // starting index of right half of arr

        //Modification 1: cnt variable to count the pairs:
        int cnt = 0;
        while(left <= mid && right <= end){
            if (a[left] <= a[right]) {
                temp.add(a[left]);
                left++;
            } else {
                temp.add(a[right]);
                cnt += (mid - left + 1); //Modification 2
                right++;
            }
        }
        while (left <= mid) {
            temp.add(a[left]);
            left++;
        }

        //  if elements on the right half are still left //
        while (right <= end) {
            temp.add(a[right]);
            right++;
        }

        // transfering all elements from temporary to arr //
        for (int i = start; i <= end; i++) {
            a[i] = temp.get(i - start);
        }
        return cnt; // Modification 3
    }

    private static void swap(int[] pre, int i, int j) {
        int temp = pre[i];
        pre[i]=pre[j];
        pre[j]=temp;
    }
    

}