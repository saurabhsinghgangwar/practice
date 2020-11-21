package test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindTheNumber {
    public static void main(String[] args) {
        int[]  A = {1,2,3} ;
        List<Integer> l = Arrays.stream(A)		// IntStream
                .boxed()  		// Stream<Integer>
                .collect(Collectors.toList());
        int i =1;
        for( i =1 ; i < A.length ; i++) {
           if(!l.contains(i)){
               System.out.println(i);
               break;
               }
        }
        if(i >= A.length) {
            System.out.println(i+1);
        }

    }
}
