package org.dsa.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given an array of integers, A of length N, find out the maximum sum sub-array of non negative numbers from A.
//
//The sub-array should be contiguous i.e., a sub-array created by choosing the second and fourth element and skipping the third element is invalid.
//
//Maximum sub-array is defined in terms of the sum of the elements in the sub-array.
//
//Find and return the required subarray.
//
//NOTE:
//
//    1. If there is a tie, then compare with segment's length and return segment which has maximum length.
//    2. If there is still a tie, then return the segment with minimum starting index.

//Hint :This problem requires a simple adhoc approach :
//
//Just need to simulate whats stated in the problem.
//Can you traverse through the array maintaining the current subset ? Note that the subset becomes invalid as soon as you encounter a negative number.
//
//Also, note that you do not need to start again on encountering the negative number. You can start from the number next to the negative number.


public class ContinousNonNegativeSubArray {
    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(756898537,-1,-1, 1424268980, -4,0, 1);

        int n = A.size();

        long sum = 0;
        int startIndex = 0, endIndex = 0;
        long maxSum = 0;
        int maxStartIndex = 0, maxEndIndex = 0;

        for(int i=0;i<n;i++){
            if(A.get(i) < 0){
                if(sum>maxSum){
                    maxStartIndex = startIndex;
                    maxEndIndex = endIndex;
                    maxSum = sum;
                } else if (sum == maxSum){
                    if(endIndex-startIndex > maxEndIndex-maxStartIndex){
                        maxStartIndex = startIndex;
                        maxEndIndex = endIndex;
                    }
                }
                startIndex = i<n-1? i+1 : i;
                sum = 0;
            } else{
                sum += A.get(i);
                endIndex = i;
                if(i == n-1){
                    if(sum>maxSum){
                        maxStartIndex = startIndex;
                        maxEndIndex = endIndex;
                        maxSum = sum;
                    }
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        if(maxSum >= 0 && A.get(maxStartIndex) >= 0 ){
            for(int j= maxStartIndex ;j<=maxEndIndex; j++){
                result.add(A.get(j));
            }
        }

        System.out.println(result);
        System.out.println("sum: " + maxSum);

        System.out.println("StartIndex:"+maxStartIndex + " EndIndex:"+ maxEndIndex);
    }
}
