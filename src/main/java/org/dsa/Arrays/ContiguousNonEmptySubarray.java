package org.dsa.Arrays;

import java.util.Arrays;
import java.util.List;

//Q: Find the maximum sum of contiguous non-empty subarray within an array A of length N.

//Hint: Kadane's Algo

public class ContiguousNonEmptySubarray {
    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(1,2,3,-7,1,1,1,1,3,-7);
        int n = A.size();
        int ans = Integer.MIN_VALUE;
        int sum = 0;
        int startIndex = 0, endIndex = 0;
        for(int i=0;i<n;i++){
            int previousSum = sum;
            sum += A.get(i);
            if(previousSum ==0 && ! (ans>sum)) {startIndex = i;}
            if(sum > ans){
                endIndex = i;
            }
            ans = Math.max(ans,sum);
            
            if(sum<0){
                sum = 0;
            }
        }
        System.out.println("Sum of Contiguous Array:"+ans);
        System.out.println("StartIndex:"+startIndex + " EndIndex:"+ endIndex);
    }
}
