package test;

import java.util.ArrayList;
import java.util.List;

public class MagicSqr {

        public void magic(int[][] A ){

            // find sum first
            int lR = A.length;
            int lC = A[0].length ;
            List<Integer> lr = new ArrayList();
            List<Integer> lc = new ArrayList();
            List<Integer> ld = new ArrayList();

            int tempSumRow = 0;
            int tempSumColumn=0;
            int tempSumDiag=0;

            for(int i=0;i<lR;i++){
                int j;
                for( j=0; j<lC;j++){

                        tempSumRow += A[i][j];

                }
                if(lr.size()!=0 && tempSumRow != lr.get(0))
                {
                  int s =  lr.get(0)-A[i][j-1];
                  lr.remove(0);
                  lr.add(s);

                }

                else

                lr.add(tempSumRow);


            }
            for(int i=0;i<lC;i++){
                for(int j=0; j<lR;j++){

                    tempSumColumn += A[j][i];

                }

                lc.add(tempSumColumn);


            }
            // check if all equal
            for( int i = A.length-1;  i >= 0 ; i--){
                int temp =0 ;
                for(int j=0 ;  j< lC ; j++){
                    if(temp != (lc.get(j) - A[i][lC])){
                        break ;
                    }
                     temp  =lc.get(j) - A[i][lC] ;
                }

            }




        }
    }


