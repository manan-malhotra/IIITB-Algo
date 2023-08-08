/*
 Q11. Given a array A of numbers , write a linear time algorithm to compute array B, 
 such that B[i] = j, j is the largest j < i such that A[j] > A[i].B[i] = −1 
 if all the numbers to the left of A[i] are less than or equal to A[i].
 */
package com.algo;

import java.util.Arrays;

public class PreviousGreaterArray {

    public static void main(String[] args) {
        int[] arr = {11,0,65,8,10,18,9,22,32,7};
        int[] b = previousGreaterArray(arr);
        System.out.println(Arrays.toString(b));
        
    }

    private static int[] previousGreaterArray(int[] arr) {
        int n = arr.length;
        int[] b = new int[n];
        int[] s = new int[n];
        int top = -1;
        for (int i = 0; i < s.length; i++) {
            b[i]=-1;
        }
        for (int i = 0; i < arr.length; i++) {
            if(top==-1){
                s[++top]=i;
            }else if(arr[i]<arr[s[top]]){
                b[i]=s[top];
                s[++top]=i;
            }else{
                while(top!=-1 && arr[i]>=arr[s[top]]){
                    top--;
                }
                if(top!=-1) b[i]=s[top];
                s[++top]=i;
            }
        }
        return b;
    }
    
}
