/*
 Q2. Given a binary string of length n, design a linear time algorithm to compute 
 the length of the largest dense sub-string of the given string. 
 */
package com.algo;

import java.util.HashMap;

public class OnesMoreThanZeros
{
 
    // Function to find longest substring
    // having count of 1s more than count
    // of 0s.
    public static int findLongestSub(String bin)
    {
        int n = bin.length(), i;
 
        // To store sum.
        int sum = 0;
 
        // To store first occurrence of each
        // sum value.
        HashMap<Integer,
                Integer> prevSum = new HashMap<>();
 
        // To store maximum length.
        int maxlen = 0;
 
        // To store current substring length.
        int currlen;
        for (i = 0; i < n; i++)
        {
 
            // Add 1 if current character is 1
            // else subtract 1.
            if (bin.charAt(i) == '1')
                sum++;
            else
                sum--;
 
            // If sum is positive, then maximum
            // length substring is bin[0..i]
            if (sum > 0)
            {
                maxlen = i + 1;
            }
 
            // If sum is negative, then maximum
            // length substring is bin[j+1..i], where
            // sum of substring bin[0..j] is sum-1.
            else if (sum <= 0)
             
            {
                if (prevSum.containsKey(sum - 1))
                {
                    currlen = i - (prevSum.get(sum - 1));
                    maxlen = Math.max(maxlen, currlen);
                }
            }
 
            // Make entry for this sum value in hash
            // table if this value is not present.
            if (!prevSum.containsKey(sum))
                prevSum.put(sum, i);
        }
        return maxlen;
    }
 
    // Driver code
    public static void main(String[] args)
    {
        String bin = "0001111";
        System.out.println(findLongestSub(bin));
    }
}
 