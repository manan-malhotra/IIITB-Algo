/*
Q10. Given a array A of numbers , write a linear time algorithm to compute array B, 
such that B[i] = j, j is the smallest j > i such that A[j] < A[i].B[i] = n 
if all the numbers to the right of A[i] are greater than or equal to A[i].
*/ 
package com.algo;

import java.util.Arrays;

public class NextSmallerArray {
    public static void main(String[] args) {
        int[] a= {36,2,11,12,8};
        int[] b = nextArray(a);
        System.out.println(Arrays.toString(b));
    }

    private static int[] nextArray(int[] a) {
        int n = a.length;
        int[] b = new int[n];
        for (int i = 0; i < b.length; i++) {
            b[i]=n;
        }
        int[] s = new int[n];
        int top = -1;
        for (int i = 0; i < a.length; i++) {
            if(top==-1 || a[i]>=a[s[top]]){
                s[++top]=i;
            }else{
                System.out.println("i "+i+" "+top);
                while(top>=0 && a[i]<a[s[top]] ){
                    b[s[top]]=i;
                    top--;
                }
                s[++top]=i;
            }
            // System.out.println(Arrays.toString(b)+" debug "+Arrays.toString(s));
        }
        return b;
    }
}
