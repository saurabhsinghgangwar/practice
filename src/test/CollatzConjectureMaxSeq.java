package test;

import java.util.HashMap;
import java.util.Map;

public class CollatzConjectureMaxSeq {
    /**
     * Given an integer N. The task is to find the number in the range from 1 to N-1 which is having the maximum number of terms in its Collatz Sequence and the number of terms in the sequence.
     *
     * The collatz sequence of a number N is defined as:
     *
     * If N is Odd then change N to 3*N + 1.
     * If N is Even then change N to N / 2.
     * For example let us have a look at the sequence when N = 13:
     * 13 -> 40 -> 20 -> 10 -> 5 > 16 -> 8 -> 4 -> 2 -> 1
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(calculateStartingPoint(10));
    }

    private static String calculateStartingPoint(int i) {

        int num = -1;
        int len =0 ;
        Map<Integer, Integer> collatzMap = new HashMap<>();
        calculateLength(i , collatzMap);

        for (int n = 1 ; n <= i ;n++) {
            if (collatzMap.get(n) == null)
                 calculateLength(n, collatzMap);

          int  cLen = collatzMap.get(n);
            if (len<cLen) {
                len = cLen;
                num = n;
            }
        }
        return "("+ num +" , "+ len +")" ;
    }

    private static int calculateLength(int i, Map<Integer, Integer> collatzMap) {

        if(collatzMap.get(i) != null){
           return  collatzMap.get(i);
        }
        if(i ==1){
            collatzMap.put(i , 1);
        }
        else if(i % 2 == 0){
            collatzMap.put(i, (1
            + calculateLength(i/2, collatzMap) )) ;
        }
        else {
            collatzMap.put(i, (1
                    + calculateLength(3*i +1, collatzMap) )) ;
        }
        return  collatzMap.get(i);
    }
}
