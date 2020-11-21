package test;

public class Matrix {
    public static void main(String[] args) {
        int[] arr = {2,1,1,0,1} ;
        System.out.println( solution(3,2, arr))  ;
    }
    public static  String solution(int U, int L, int[] C) {
        int rowSum = 0;
        int columnSum =0 ;
        int rowMax =-1;
        int columnMax = -1;
        int rowNonZero = 0;
        int columnNonZero =0 ;
        int noOfColumn = C.length ;
        char[] resultMatrix1 = new char[noOfColumn];
        char[] resultMatrix2 = new char[noOfColumn];
        int rowSum1 = U ;
        int rowSum2 = L ;
        rowSum = U+L;
        rowMax = U > L ? U : L ;
        if( U > 0 ) rowNonZero++ ;
        if(L > 0)  rowNonZero++ ;
        for(int i =0 ; i < noOfColumn ; i++ ){
            columnSum += C[i] ;
            columnMax = Math.max(columnMax , C[i]);
            if(C[i]> 0){
                columnNonZero++;
            }
            if(C[i] ==2){
                resultMatrix1[i] = '1' ;
                resultMatrix2[i] = '1' ;
                rowSum1 = rowSum1 -1 ;
                rowSum2 = rowSum2 -1 ;
            }
             if(C[i] ==0){
                resultMatrix1[i] = '0' ;
                resultMatrix2[i] = '0' ;
            }
        }

        if((rowSum != columnSum )|| (rowMax > columnNonZero) || (columnMax> rowNonZero)){
            return "IMPOSSIBLE" ;
        }
        else{
            for(int i =0 ; i < noOfColumn ; i++ ){
                if(C[i] == 1 ){
                    if(rowSum1 > 0 && rowSum2 > 0){
                        resultMatrix1[i] ='1' ;
                        resultMatrix2[i] ='0' ;
                        rowSum1 = rowSum1 -1 ;
                        rowSum2 = rowSum2 -1 ;
                    }
                    else if ( rowSum1 == 0){
                        resultMatrix1[i] ='0' ;
                        resultMatrix2[i] ='1' ;

                        rowSum2 = rowSum2 -1 ;
                    }
                    else if ( rowSum2 == 0){
                        resultMatrix1[i] ='1' ;
                        resultMatrix2[i] ='0' ;

                        rowSum1 = rowSum1 -1 ;
                    }
                }
            }

            String result = new String(resultMatrix1) + ","+ new String(resultMatrix2) ;
            return result ;
        }

    }
}
