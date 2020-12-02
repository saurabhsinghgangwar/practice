package test;

import java.io.*;
import java.util.*;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.text.*;

 class Solution5 {
    final static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);

    public static void main(String[] args) {
        BufferedReader bufferedReader = new
                BufferedReader(new InputStreamReader(System.in));
        Set<Order> ordersToProcess = new HashSet<>();
        try {
            String orderLine ;
            long noOfLines = Long.parseLong( bufferedReader.readLine()) ;
            bufferedReader.readLine() ;
            for(int j=1; j< noOfLines ;j++ )  {
                orderLine= bufferedReader.readLine() ;
                ordersToProcess.add(getOrder(orderLine));
            }
        }catch (IOException | ParseException e) {
            System.out.println("Something wrong happened try again"+e);
        }
        extractInvoice(ordersToProcess);
    }

     private static void extractInvoice(Set<Order> ordersToProcess) {
         String string = "Inv-\\d{6,8}";
         Pattern pattern = Pattern.compile(string);
         Predicate<String> invoiceFilter = Pattern
                 .compile(string)
                 .asPredicate();
         List<String> invoiceList1 =  ordersToProcess.stream().map(order -> {
             String desc = order.getDescription();
             String result = "" ;
             Matcher matcher =  pattern.matcher(desc);
             if(matcher.find()){
                 result = desc.substring(matcher.start(), matcher.end()) ;
             }
             return result ;
         }).collect(Collectors.toList()) ;

         List<String> invoiceList=  ordersToProcess.stream().
                 map(Order::getDescription).
                 map(desc -> {
                     Matcher matcher =  pattern.matcher(desc);
                     return  matcher.find() ?  desc.substring(matcher.start(), matcher.end()) : "" ;
                 })
                 .collect(Collectors.toList());

         invoiceList.stream().sorted().forEach(System.out::println);
     }

     private static Order getOrder(String line) throws ParseException {
         String[]  input = line.split(",");
         Date date = formatter.parse(input[1]);
         int qty = Integer.parseInt( input[2]) ;
         double totalPrice = Double.parseDouble( input[3]) ;
         return new Order(input[0],date ,qty,totalPrice, input[4], input[5]);
     }
 }

class Order{
    private String id;
    private Date payDate;
    private int quantity;
    private double totalPrice;
    private String currency;
    private String description;
    public Order(String id, Date payDate, int quantity, double totalPrice,
                 String currency, String description) {
        this.id = id;
        this.payDate = payDate;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.currency = currency;
        this.description = description;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Order test = (Order) o;
        return id.equals(test.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}