/*
 * Q8. Design a linear time algorithm to decide if a given sequence of numbers is a stack sequence.
 */

package com.algo;

public class StackSequence {

    public static void main(String[] args) {
        int[] pushed = {1,2,3,4,5};
        int[] popped ={4,5,3,2,1};
        System.out.println(validateStackSequences(pushed,popped));
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        int i = 0; // Intialise one pointer pointing on pushed array
        int j = 0; // Intialise one pointer pointing on popped array
        
        for(int val : pushed){
            pushed[i++] = val; // using pushed as the stack.
            while(i > 0 && pushed[i - 1] == popped[j]){ // pushed[i - 1] values equal to popped[j];
                i--; // decrement i
                j++; // increment j
            }
        }
        return i == 0; // Since pushed is a permutation of popped so at the end we are supposed to be left with an empty stack
    }
    
}
