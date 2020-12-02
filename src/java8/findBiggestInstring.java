package java8;

public class findBiggestInstring {
    public static void main(String[] args) {
        System.out.println(solution("88"));
    }
    public static int solution(String S) {
        // write your code in Java SE 8
        int maxNum = Integer.MIN_VALUE ;
        for(int i=0 ; i< S.length()-1 ;i++){
            String temp = S.substring(i, i+2);
            int num = Integer.parseInt(temp);
            if(maxNum < num){
                maxNum = num ;
            }
        }
        return  maxNum ;
    }
}
