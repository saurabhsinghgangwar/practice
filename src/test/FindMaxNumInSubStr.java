package test;

import java.util.*;

public class FindMaxNumInSubStr {


    // Function to return the
// required count of substrings
    public static int countSubstrings(String str) {
        int N = str.length();

        // Store the count
        int answer = 0;

        for(int i=0; i < N-1 ; i++){
            int s = Integer.parseInt(str.substring(i , i+2)) ;
            if(answer < s){
                answer =s ;
            }
        }
        // Return the count
        return answer;
    }

    // Driver code
    public static void main(String[] args) {

        // string str
        String str = "50552";

        // integer K
        int K = 3;

        // Print the count of K length
        // substrings with k distinct characters
        System.out.println(countSubstrings(str));
    }
}

// This code is contributed by grand_master


