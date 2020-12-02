package test;

public class StringPermutation {
    public static void main(String[] args) {
        permutation("ABC","",3);
    }
    public  static  void permutation(String s, String str, int n){

        if(str.length()==n){

            System.out.println(str);
        }
        else{

            char[] arr = s.toCharArray() ;
            String out = "" ;
            for(int i=0; i < arr.length ; i++){
                out = out.concat(String.valueOf(arr[i])) ;


            }

        }

    }




}
