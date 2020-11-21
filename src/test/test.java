package test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class test {
    public static void main(String[] args) {
        int[] arr = {-1,-2,1} ;
        int[] arr1 = { 1,2,3,4,5,6,7,8,9} ;
        List<Integer> l1 = Arrays.stream(arr)		// IntStream
                .boxed()  		// Stream<Integer>
                .collect(Collectors.toList());
        List<Integer> l2 = Arrays.stream(arr1)		// IntStream
                .boxed()  		// Stream<Integer>
                .collect(Collectors.toList());

        boolean b = l1.stream().noneMatch(l2::contains);
      //  System.out.println(b);
        String[] arr2 = {} ;

       List<String> s = Arrays.asList(arr2) ;
       Set s1= s.stream().filter(a-> !a.isEmpty()).collect(Collectors.toSet()); ;
        System.out.println();
    }
}


