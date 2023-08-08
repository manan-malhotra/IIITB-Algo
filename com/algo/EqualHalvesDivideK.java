/*  Q4. Given a binary string S of length n, design a linear time algorithm to compute k, 
such that the number of 0’s in S[0..k] is equal to number of 1’s in S[k+1..n-1] */
package com.algo;
public class EqualHalvesDivideK {
    public static void main(String[] args) {
        String binaryString = "101010"; // Replace this with your binary string
        int k = findK(binaryString);
        int j = findKJay(binaryString);

        System.out.println(k==j);
    }
    public static int findK(String S) {
        int n = S.length();
        int onesCount = 0;

        // Count the number of 0's and 1's in the entire string
        for (int i = 0; i < n; i++) {
            if (S.charAt(i) == '1') {
                onesCount++;
            }
        }

        // Initialize the counts for the left and right segments of the string
        int leftZeros = 0;

        // Iterate through the string to find k
        for (int i = 0; i < n - 1; i++) {
            if (S.charAt(i) == '0') {
                leftZeros++;
            } else {
                onesCount--;
            }

            if (leftZeros == onesCount) {
                return i; // Found k such that counts are equal
            }
        }

        return -1; // If no such k exists
    }
    public static int findKJay(String S){
        int n = S.length();
        int onesCount = -1;

        // Count the number of 0's and 1's in the entire string
        for (int i = 0; i < n; i++) {
            if (S.charAt(i) == '1') {
                onesCount++;
            }
        }
        return onesCount;
    }
}
