package test;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
class NumberPadString{

    static Character[][] numberToCharMap;



    private static void printWords(int[] numbers)
    {
        generateNumberToCharMap();
        
    }

    private static void generateNumberToCharMap()
    {
        numberToCharMap = new Character[10][5];
        numberToCharMap[0] = new Character[]{'\0'};
        numberToCharMap[1] = new Character[]{'\0'};
        numberToCharMap[2] = new Character[]{'a','b','c'};
        numberToCharMap[3] = new Character[]{'d','e','f'};
        numberToCharMap[4] = new Character[]{'g','h','i'};
        numberToCharMap[5] = new Character[]{'j','k','l'};
        numberToCharMap[6] = new Character[]{'m','n','o'};
        numberToCharMap[7] = new Character[]{'p','q','r','s'};
        numberToCharMap[8] = new Character[]{'t','u','v'};
        numberToCharMap[9] = new Character[]{'w','x','y','z'};
    }

    // Driver code
    public static void main(String[] args)
    {
        int number[] = {2, 3};
        printWords(number);
    }
}

// This code is contributed by ankit pachori 1
