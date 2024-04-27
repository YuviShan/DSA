package org.dsa.Arrays;

// Q: Given an integer array A of size N. Return 1 if the array can be arranged to form an arithmetic progression, otherwise return 0.

import java.util.Arrays;

//A sequence of numbers is called an arithmetic progression if the difference between any two consecutive elements is the same.
public class ArithmeticProgressionCheck {
    public static void main(String[] args) {
        int[] A = {3, 7, 1};
        int n = A.length;
        Arrays.sort(A);
        int intervel = A[1] - A[0];
        int ans = 1;
        for (int i = 2;i<n;i++){
            if(A[i] - A[i-1] != intervel){
                ans = 0;
            }

        }
        System.out.println(ans);

    }
}
