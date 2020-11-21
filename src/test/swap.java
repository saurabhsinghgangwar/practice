package test;// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends


//User function Template for Java


public class swap
{
    long findSwapValues(long A[], int n, long  B[], int m1)
    {
        // Your code goes here
        long sa=0;
        long sb=0;
        Set<Long> m = new HashSet();
        for(long a : A){
            sa= sa+a;
        }
        for(long b : B){
            sb= sb+b;
            m.add(b);
        }

        long d = Math.abs(sa-sb)/2;
        if(Math.abs(sa-sb) %2 ==1){
            return -1;
        }
        long td=0;
        if(sa > sb){
            for(Long a : A){
                td = a-d;

                if(m.contains(td)){
                    return  1;
                }
            }
        }
        else{
            for(Long a : A){
                td = Math.abs(a+d);

                if(m.contains(td)){
                    return  1;
                }
            }

        }

        return  -1 ;
    }
}



// { Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
            long[] a = {0 ,4,5,4,1,3,3,3,2,1,2,4,1,4,3,0,0,0,5,1,5,4,1

            } ;
            long[] b = {0,3,4,3,4,3,1,1,4,2,2,3,5,5,1,2,3,3,4,2,1
            } ;
                    swap ob = new swap();
            long ans = ob.findSwapValues(a,a.length,b,b.length);
            System.out.println(ans);
        }
    }





// } Driver Code Ends