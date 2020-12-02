package test;

import java.util.Stack;
import java.util.*;
import java.lang.*;
import java.io.*;
public class StockSpan {
    public static void main (String[] args) {
        try{
            BufferedReader bufferedReader = new
                    BufferedReader(new InputStreamReader(System.in));
            int noOfLines = Integer.parseInt( bufferedReader.readLine()) ;
            int[] arr ;
            for(int j=0; j< noOfLines ;j++ )  {
                int n= Integer.parseInt(bufferedReader.readLine() );
                arr = new int[n];
                String s = bufferedReader.readLine() ;
                String[] ss = s.split(" ");
                for(int i=0 ; i < n ; i++){
                    arr[i] = Integer.parseInt (ss[i]) ;
                }
                stockSpan(arr) ;
            }
        }
        catch(Exception e){
            System.out.println("") ;

        }
    }

    public static void stockSpan(int[] arr){
        Stack<Integer> stack = new Stack<>() ;
        int len = arr.length ;
        int[] result = new int[len] ;
        for(int i=0; i< len ; i++){
            int temp =1;
            while(!stack.isEmpty()  && arr[stack.peek()] <= arr[i]){
               int j= stack.pop();
                temp = temp+result[j];
            }
            stack.push(i);
            result[i] = temp ;
        }

        for(int i =0 ; i< result.length ; i++){
            System.out.println(result[i]+" index "+ i  + " values "+ arr[i]);

        }
    }
}
