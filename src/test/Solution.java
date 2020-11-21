package test;

import java.io.IOException;



    class Result {

        /*
         * Complete the 'shortestPalindrome' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts STRING s as parameter.
         */

        public static int shortestPalindrome(String s) {

            int i=0;
            int j=s.length()-1;
            int count1 =0;
            int count2=0;
            int finalcount=0;
            while(true){
                if(s.charAt(i) == s.charAt(j)) {
                    i++;
                    j--;
                }
                else{
                    if(j>0) {
                        count1 = count1 + shortestPalindrome(s.substring(i, j--));
                    }
                    if(i<s.length()-1) {
                        count2 = count2 + shortestPalindrome(s.substring(i + 1, j));
                    }

                }
                if(i == j || j< i)
                    break;
            }
            if(count1 > count2){
                finalcount = count2;
            }
            else {
                finalcount = count1;
            }
            return finalcount;

        }

    }
    public class Solution {
        public static void main(String[] args) throws IOException {
            
            int result = Result.shortestPalindrome("abb");
System.out.println(result);
        }
    }


