package java8;

import java.lang.reflect.Array;
import java.util.*;

public class StockProfit {
    public static void main(String[] args) {
        Integer[] integers = {407,1152,403,1419,689,1029,108,128,1307,300,775,622,730,978,526,943,127,566,869,
                715,983,820,1394,901,606,497,98,1222,843,600,1153,302,1450,1457,973,1431,217,936,958,
                1258,970,1155,1061,1341,657,333,1151,790,101,588,263,101,534,747,405,585,111,849,695,1256,
                1508,139,336,1430,615,1295,550,783,575,992,709,828,1447,1457,738,1024,529,406,164,994,1008,50,811,564,580,952,768,863,1225,251,1032,1460};
        List<Integer> l = Arrays.asList(integers);

        System.out.println(stockPairs(l, 1558));

    }

    public static int stockPairs(List<Integer> stocksProfit, long target) {
        int count = 0;
        HashMap<Long, Boolean> stockProfitToPairFound = new HashMap();
        for (Integer stockProfitNum : stocksProfit) {
            long remainder = target - stockProfitNum;
            boolean found = false;
            boolean remFound = false;
            if (stockProfitToPairFound.containsKey(remainder) ) {
                remFound = stockProfitToPairFound.get(remainder);
                if(!remFound) {
                    stockProfitToPairFound.put(remainder, true);

                    count++;
                    found = true;
                    stockProfitToPairFound.put(Long.valueOf(stockProfitNum), true);

                }
            }
            if(!remFound)
                stockProfitToPairFound.put(Long.valueOf(stockProfitNum), found);

        }

        return count;
    }


}
