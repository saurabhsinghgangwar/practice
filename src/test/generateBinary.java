package test;

public class generateBinary {
    public static void main(String[] args) {
        generateBinaryMethod("" ,3) ;
    }

    private static void generateBinaryMethod(String s, int i) {
        if(i ==0)
            System.out.println(s);
        else{
            generateBinaryMethod(s+"0" , i-1);
            generateBinaryMethod(s+"1", i-1);
        }

    }
}
