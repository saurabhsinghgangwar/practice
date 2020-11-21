package test;

import java.util.HashMap;
import java.util.Map;

public class FairIndexV2 {
    public static void main(String[] args) {


        int[] A = {1,4,2,-2,5};
        int[] B = {
              7,-2,-2,2,5} ;
        System.out.println( call(A, B));
    }
    public static int call(int[] A, int[] B) {

        long sum1 = 0, sum2 = 0;
        long targetSum =0;
        int count =0 ;
        int len = A.length ;
        Map<Long,Integer> map = new HashMap<>() ;
        for (int i = 0; i < len; i++) {
            sum1 = sum1+ A[i];
            sum2 = sum2 + B[i];
            if(sum1 == sum2 && i< len-1){
                map.merge(sum1, 1, Integer::sum);
            }
        }
        
        targetSum = sum1/2 ;
        if(sum1%2 !=0  && sum2%2 !=0 ){
            return 0;
        }
        else if( sum1 != sum2){
            return 0;
        }
        else{
          Integer   count1 =   map.get(targetSum);
          if(count1 != null){
              count = count1 ;
          }

        }
        return count;

    }
}
