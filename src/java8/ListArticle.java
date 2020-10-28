package java8;

import java8.Article;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

public class ListArticle {
    public static void main(String[] args) {
        List<Article> list = new ArrayList();
        for(int i =10 ; i <=20 ; i=i+10) {
            Article article = new Article();
            article.setId(i);
            article.setName("A");
            article.setPrice(i);
            article.setQty(i);
            list.add(article);
        }

        Article article = new Article();
        article.setId(10);
        article.setName("A");
        article.setPrice(32);
        article.setQty(23);
        list.add(article);

        int sum = list.stream().map(article1 -> article1.getPrice() * article1.getQty()).reduce(0, Integer::sum);
       Map<String , List<Article>> m =  list.stream().collect(Collectors.groupingBy(Article::getName));

       List l =  list.stream().collect(collectingAndThen(toCollection(() -> new TreeSet<>(comparingInt(Article::getId))),
                ArrayList::new))
               ;
        System.out.println(l.size());
       // System.out.println(m.get("A").size());
        //  System.out.println(sum);
    }
}
