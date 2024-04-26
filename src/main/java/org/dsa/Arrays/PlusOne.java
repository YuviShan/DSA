package org.dsa.Arrays;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given a non-negative number represented as an array of digits, add 1 to the number ( increment the number represented by the digits ).
//
//The digits are stored such that the most significant digit is at the head of the list.
//
//NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer. For example: for this problem, the following are some good questions to ask :
//
//Q: Can the input have 0's before the most significant digit. Or, in other words, is 0 1 2 3 a valid input?
//A: For the purpose of this question, YES
//Q: Can the output have 0's before the most significant digit? Or, in other words, is 0 1 2 4 a valid output?
//A: For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.

public class PlusOne {
    public static void main(String[] args) {
        //List<Integer> A = Arrays.asList(new Integer[]{9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9});
        int[] A = {9,9,9,9,9,9};
        int n = A.length;
        Arrays.stream(A).forEach(System.out::print);
        System.out.println();
        boolean carryforward = false;
        boolean newArrayNeeded = false;
        if(A[0] == 0 && n!=1){
            int endIdx = 0;
            for(int i=1;i<n;i++){
                if(A[i] == 0){
                    endIdx = i;
                }else {
                    break;
                }
            }
            A = Arrays.copyOfRange(A,endIdx+1,n);
        }
        n = A.length;
        for(int i=n-1;i>=0;i--) {
            if(i == n-1){
                A[i] = A[i]+1;
            }
            if(carryforward){
                A[i] = A[i]+1;
                carryforward = false;
            }
            if(A[i] > 9){
                A[i] = 0;
                carryforward =true;
            }
            if(i==0 && carryforward){
                newArrayNeeded = true;
            }
        }
        if(newArrayNeeded){
            int[] B  = new int[n+1];
            B[0] = 1;
            int idx = 1;
            for(int a : A){
                B[idx] = a;
                idx++;
            }
            A = B;
        }






        System.out.println("-------------------------");
        Arrays.stream(A).forEach(System.out::print);




    }
}
