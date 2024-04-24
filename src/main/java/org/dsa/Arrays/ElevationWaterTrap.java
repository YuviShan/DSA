package org.dsa.Arrays;

//Question : Given a Array A of non-negative integers representing an elevation map
//where the width of each bar is 1, compute how much water it is able to trap after raining.

//Solution Hint
//Step 1: Find the leftMax array and Right Max Array
//Step 2: Find the Water logged in each building by Min(LeftMax, RightMax) - Height of building

public class ElevationWaterTrap {
    public static void main(String[] args) {
        int[] A = new int[]{1,2,3,2,4};
        int n = A.length;
        int result = 0;
        int[] leftMaxArray = new int[n];
        int[] rightMaxArray = new int[n];
        //LeftMax Array
        int tempMax = 0;
        leftMaxArray[0] = tempMax;
        for(int i=1;i<n;i++){
            tempMax = Math.max(tempMax, A[i - 1]);
            leftMaxArray[i] = tempMax;
        }

        //Right Max Array
        int tempRMax = 0;
        rightMaxArray[n-1] = tempRMax;
        for(int i=n-2;i>=0;i--){
            tempRMax = Math.max(tempRMax, A[i + 1]);
            rightMaxArray[i] = tempRMax;
        }



        for(int i=0;i<n;i++){
           int unitTrapped = Math.min(leftMaxArray[i],rightMaxArray[i]) - A[i];
           if(unitTrapped < 0) {
               unitTrapped = 0;
           }
           result  +=unitTrapped;
        }

        System.out.println(result);
    }
}
