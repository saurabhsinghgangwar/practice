package test;

public class Flip {

  public static void main(String[] args) {
      int[] as = {0, 0, 1, 0, 1,1};
      int res = 0;
      for(int a: as){
           if (res % 2 != 0) {
              if (a == 0) {
                  a = 1;
              } else {
                  a = 0;
              }

          }
          if(a !=0){
              res++;
          }
      }
      System.out.println(res);
  }
}
