package test;

import java.util.Stack;

public class parenthesisBalance {
    public static void main(String[] args) {
        String testStr = "{ (( 3+4 )} {()}" ;
        System.out.println(checkBalance(testStr));

    }

    private static boolean checkBalance(String testStr) {
        Stack<Character> stack = new Stack<>();

        char[] chars = testStr.toCharArray();
        for(char c : chars){
            if(c == '{' || c == '[' || c== '(' ){
                stack.push(c);
            }
            else if (c == '}' || c == ']' || c== ')' ){
                char c1= stack.pop();
                if(!compareChar(c1,c))
                    return  false;
            }
        }
        if(stack.size() > 0){
            return  false;
        }
        return true;
    }

    private static boolean compareChar(char c1, char c) {
       if( c1 == '{' && c == '}')
           return true;
       if( c1 == '['  && c == ']')
           return  true ;
       if(c1== '(' && c == ')')
           return  true;
       return false ;
    }
}
