package test;

import java.util.*;

;

public class ArrayTemp {
    public static void main(String[] args) {

        // string str
        int[]  A = {5,2,4,6,3,7} ;
        // String str = "ccaaddffecee" ;


        // Print the count of K length
        // substrings with k distinct characters
        System.out.println(solution(A));
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
