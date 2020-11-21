package test;

public class FairIndex {
    public static void main(String[] args) {


        int[] A = {0,0,0,0};
        int[] B = {
               0,0,0,0} ;
        System.out.println( call(A, B));
    }
    public static int call(int[] A, int[] B) {

        long sum1 = 0, sum2 = 0;
        long targetSum =0;
        int count =0 ;
        int len = A.length ;
        for (int i = 0; i < len; i++) {
            sum1 = sum1+ A[i];
            sum2 = sum2 + B[i];
        }
        targetSum = sum1/2 ;
        if(sum1%2 !=0  && sum2%2 !=0 ){
            return 0;
        }
        else if( sum1 != sum2){
            return 0;
        }
        else{
            sum1 =0 ;
            sum2 =0 ;
            for(int i =0 ; i < len ; i++ ){
                sum1 += A[i] ;
                sum2 += B[i] ;
                if((sum1 == sum2 ) && (sum1 == targetSum) && (i != len-1)  ){
                    count++ ;
                }
            }
        }
        return count;

    }
}
