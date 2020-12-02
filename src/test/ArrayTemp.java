package test;

import java.util.*;

;

public class ArrayTemp {
    public static void main(String[] args) {

        // string str
        int[]  A = {5,4,7,6,3,8,2, 9} ;

        System.out.println(solution3(A));
    }

    private static int solution3(int[] A) {
        int min =  Integer.MAX_VALUE, secondMin =  Integer.MAX_VALUE;
        int n = A.length;
        for (int j = 0; j < n; j++)
        {

            // If found new minimum
            if (A[j] < min)
            {

                // Minimum now becomes second minimum
                secondMin = min;

                // Update minimum
                min = A[j];
            }

            // If current element is > min and < secondMin
            else if ((A[j] < secondMin) && A[j] != min)

                // Update secondMin
                secondMin = A[j];
        }

        // Return the sum of the minimum pair
        return (secondMin + min);
    }

    private static int solution1(int[] A) {
        int n = A.length ;
        int sum = Integer.MAX_VALUE;
        for(int i =1 ; i< n-1 ; i++){
            for(int j= i+2 ; j< n-1 ; j++){
                if(A[i]+A[j] < sum){
                    sum = A[i]+A[j];
                }
            }
        }
        return sum;
    }


    private static int solution2(int[] A) {
        int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        int n = A.length ;
        int minInd = -1 ;
        int secondMinInd=-1;
        for (int j = 1; j < n-1 ; j++) {

            // If found new minimum
            if (A[j] < min &&  j-minInd > 1) {

                // Minimum now becomes second minimum
                secondMin = min;

                // Update minimum
                min = A[j];
                minInd = j ;
            }

            // If current element is > min and < secondMin
            else if ((A[j] < secondMin) && A[j] != min && j-minInd > 1) {

                secondMin = A[j];
                secondMinInd = j;
            }
        }
        return secondMin + min ;
    }




    public static int solution(int[] A) {
        if (A.length == 2) return 0;

        int minSliceTwo = A[0] + A[1];
        int minTwoIndex = 0;

        int minSliceThree = Integer.MAX_VALUE;
        int minThreeIndex = 0;

        for (int i = 2; i < A.length-1; i++) {
            int sliceTwo = A[i - 1] + A[i+1];
            if (sliceTwo < minSliceTwo) {
                minSliceTwo = sliceTwo;
                minTwoIndex = i - 1;
            }

            int sliceThree = sliceTwo + A[i - 2];
            if (sliceThree < minSliceThree) {
                minSliceThree = sliceThree;
                minThreeIndex = i - 2;
            }
        }
        int averageMinTwo = minSliceTwo*3;
        int averageMinThree = minSliceThree*2;

        if (averageMinTwo == averageMinThree) return Math.min(minTwoIndex, minThreeIndex);
        else return averageMinTwo < averageMinThree ? minTwoIndex : minThreeIndex;
    }



}
