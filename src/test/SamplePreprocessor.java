package test;
import java.util.*;
import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.math.BigDecimal.ZERO;
import static java.util.stream.Collectors.averagingDouble;
import static java.util.stream.Collectors.groupingBy;

public class SamplePreprocessor {

    //private final SampleNormalizer normalizer;

    public static void main(String[] args) {
        List<BigDecimal> l = new ArrayList<>() ;
        l.add(new BigDecimal("1")) ;
        l.add(new BigDecimal("0")) ;
        l.add(new BigDecimal("null")) ;
        l.add(new BigDecimal("2")) ;
        l.add(new BigDecimal("-1")) ;
        l.add(new BigDecimal("5")) ;
        l.add(new BigDecimal("6")) ;
        System.out.println( preprocess(l.stream())) ;
    }

   static Stream<BigDecimal> preprocess(Stream<BigDecimal> input) {
       List<BigDecimal> l =  input.filter(dec -> dec != null && dec.compareTo(ZERO) > 0 ).collect(Collectors.toList()) ;
        int count =0 ;
       List<Triple> triples = new ArrayList<>();
       List<BigDecimal> list = new ArrayList<>();
       for(BigDecimal b : l){
          count++ ;
          list.add(b) ;
          if(count == 3){
              count =0 ;
              Triple t = new Triple(list.get(0), list.get(1), list.get(2)) ;
              triples.add(t) ;
              list.clear();
          }
      }
       
     Stream<BigDecimal> stream =   triples.stream().filter( triple -> triple.getAvg().
               compareTo(new BigDecimal("30")) >= 0 )
               .flatMap(triple -> triple.getList().stream()) ;
        return null;
    }

     static class Triple{
        BigDecimal first ;
        BigDecimal second ;
        BigDecimal third ;
        public  Triple(BigDecimal f , BigDecimal s , BigDecimal t){
            this.first = f ;
            this.second = s ;
            this.third = t;
        }
        public BigDecimal getAvg(){
            return first.add(second).add(third).divide(new BigDecimal("3")) ;
        }
        public  List<BigDecimal> getList(){
            List<BigDecimal> l = new ArrayList<>();
            l.add(first);
            l.add(second);
            l.add(third);
            return  l ;
        }
    }
}