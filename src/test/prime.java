package test;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



public class prime{

    /*
     * Complete the 'isPrime' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts LONG_INTEGER n as parameter.
     */

    public static int isPrime(long n) {
        // Write your code here
        int num =1 ;
        for(int i=2 ; i< n/2 ; i++){
            if(n%i == 0){
                num = i ;
                break;
            }
        }
        return num ;
    }

}


 class Solution1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(bufferedReader.readLine().trim());

        int result = prime.isPrime(n);

        System.out.printf(String.valueOf(result)) ;

        bufferedReader.close();

    }
}
