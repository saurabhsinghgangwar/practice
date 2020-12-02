package test;

import java.util.*;
import java.util.stream.Collectors;

public class findUniqueCount {

    public static void main(String[] args) {

        // string str
       String str = "aaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbccccccccccccccccccccdddddddddddddddeeeeeee";
       // String str = "ddddddaaatttttyyyyyyyqiiiiiii" ;


        // Print the count of K length
        // substrings with k distinct characters
        System.out.println(solution(str));
    }

    public static int solution(String S) {
        int n = S.length() ;
        int min = Integer.MAX_VALUE ;
        int sum = n ;
        Map<Character , Integer> map = new TreeMap<>();
        List<Integer> list = new ArrayList<>();
        int count =0;
        char[] arr= S.toCharArray() ;
        for(int i=0; i< n ; i++){
            char c= arr[i] ;
            map.merge(c, 1, Integer::sum);

        }
        LinkedHashMap<Character, Integer> reverseSortedMap = new LinkedHashMap<>();

        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));

        for(Map.Entry<Character, Integer> entry : reverseSortedMap.entrySet()){
            int i = entry.getValue();
          if(i > min){
                count  =count + sum ;
                break ;
            }
            else{
                int temp  ;

                if(list.contains(i)){
                    count++;
                    temp = i-1;
                    list.add(i-1);
                }
                else{
                    temp = i;
                    list.add(i);

                }
              if(min > temp ) {
                  min = temp;

              }

            }
            sum = sum -i ;


        }
        return  count ;
        // write your code in Java SE 8
    }

}
