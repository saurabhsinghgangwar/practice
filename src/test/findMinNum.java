package test;

// Java program to print minimum number that can be formed
// from a given sequence of Is and Ds
class findMinNum
{

    // Prints the minimum number that can be formed from
    // input sequence of I's and D's
    static int PrintMinNumberForPattern(String pattern)
    {

        String res="";
        int currentMax = 0;
        int indexOfN =0 ;
        int valM =0;

        if(pattern == null || pattern.length() == 0){
            return -1 ;
        }
        if(!pattern.matches("^[M-N]*$")){
            return  -1 ;
        }
        if(!pattern.contains("N")){
            int temp = pattern.length()+1 ;

            while (temp > 0) {
                res = res + temp;
                temp--;
            }
            return  Integer.parseInt(res)  ;
        }
        if(!pattern.contains("M")){
            int temp = pattern.length()+1 ;
            int i =1 ;
            while (i <=  temp) {
                res = res + i;
               i++;
            }
            return  Integer.parseInt(res)   ;
        }
        if(pattern.charAt(0) == 'M'){
            indexOfN = pattern.indexOf("N");

            currentMax = indexOfN ;
            int temp = indexOfN +1 ;

            while (temp > 0) {
                res = res + temp;
                temp--;
            }
        }

        pattern = pattern.substring(currentMax);

        while (pattern.length() > 0 ){
            switch (pattern.charAt(0) ) {
                 case 'M' :
                     pattern = pattern.substring(1);
                     valM --;
                     res = res + valM ;
                     break;

                 case 'N' :
                     pattern = pattern.substring(1);
                     int indexOfNextN = pattern.indexOf("N") ;
                     int temp = -1;
                     if(indexOfNextN == -1){
                         temp = pattern.length() -1;
                     }
                     else {
                        temp = indexOfN - indexOfNextN;
                     }
                     currentMax = currentMax + temp + 1;
                     while(temp > 0 ){
                         currentMax++ ;
                         res = res + currentMax ;
                         temp -- ;
                     }
                     valM = currentMax ;

                     break ;
                 default:
                     res ="-1" ;
                     break;
             }
        }


        return Integer.parseInt(res)  ;
    }

    // Driver code
    public static void main(String[] args)
    {
        System.out.println(PrintMinNumberForPattern("MMM"));

    }
}

// This code is contributed by Princi Singh
