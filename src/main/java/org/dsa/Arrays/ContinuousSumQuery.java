package org.dsa.Arrays;


//There are A beggars sitting in a row outside a temple. Each beggar initially has an empty pot. When the devotees come to the temple, they donate some amount of coins to these beggars. Each devotee gives a fixed amount of coin(according to their faith and ability) to some K beggars sitting next to each other.

import java.util.Arrays;

//Given the amount P donated by each devotee to the beggars ranging from L to R index, where 1 <= L <= R <= A, find out the final amount of money in each beggar's pot at the end of the day, provided they don't fill their pots by any other means.
//For ith devotee B[i][0] = L, B[i][1] = R, B[i][2] = P, given by the 2D array B

//Hint:  Difference Array
//Instead of updating each beggar ranging from i to j, we could update index i with +S and index j + 1 with -S, where S is a donation made by some devotee.
// So if you want to know the number of coins taken by kth beggar, you just need to find the prefix sum of all the values(coins) from 1 to k(Try to prove it by yourself that values between i to j contains +S as you are doing prefix sum).
public class ContinuousSumQuery {
    public static void main(String[] args) {
        int A = 5;
        int[][] B = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        int[] result = new int[A];
        int n = B.length;
        for(int i=0; i<n;i++){
           int startIndex = B[i][0] -1;
           int endIndex = B[i][1] - 1;
           int coinValue = B[i][2];
           result[startIndex] = result[startIndex]+coinValue;
           if(endIndex != result.length-1){
               result[endIndex+1] = result[endIndex+1]-coinValue;
           }

        }
        for(int j=1;j<A;j++){
            result[j] = result[j-1]+result[j];
        }
        Arrays.stream(result).boxed().forEach(System.out::println);
    }
}
