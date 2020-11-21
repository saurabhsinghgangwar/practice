package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NAND {
    static List s1 = new ArrayList<String>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

       for (int n = 0; n < t; n++) {
            int height = sc.nextInt();
            String input = "" ;
            int x = (int) Math.pow(2,height-1);
            for(int i=0 ; i< x ;i++) {
                input += sc.next();
            }
           solveIt(input , height);
            // System.out.println(s);
        }


        // System.out.println( soultion("01010010"));
        // System.out.println(s);
    }

    public static void solveIt(String s , int h){
        for(int i =0; i<h; i++){
            s1= new ArrayList();


            if(s.length()==1){
                System.out.println(s);

            }
            strings(s);
            //    System.out.println(s1.size());
            s= processIt(s1);


        }

    }

    private static String processIt(List<String> s1) {
        String s ="";
        for(String s2 : s1){
            if((s2.charAt(0) == '1') && (s2.charAt(1)=='1') ){
                s=s+'0';
            }
            else
                s=s+'1';

        }
        return s;
    }

    private static void strings(String s) {
        if(s.length()<=1){

            return;
        }
        else
        {
            //  System.out.println(s.substring(0,2));
            s1.add(s.substring(0,2));
            strings(s.substring(2));
        }

    }
}
