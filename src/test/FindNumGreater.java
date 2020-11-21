package test;

public class FindNumGreater {
    static final int MAXN = Integer.MAX_VALUE;

    public static void main(String[] args) {
        System.out.println( solution(1990));
    }
    public static int solution(int N) {
        // write your code in Java SE 8
       int sum = sumOfNumber(N) ;

        // Initialize result variable
        int res = -1;

        // Loop through numbers greater
        // than equal to X
        for (int i = N+1; i < MAXN; i++)
        {

            // Calculate sum of digits
            int sum_of_digit = sumOfNumber(i);

            // Check if sum of digits
            // is divisible by Y
            if (sum_of_digit == sum )
            {
                res = i;
                break;
            }
        }
        return res;
    }

    private static int sumOfNumber(int n) {
        int sum = 0;
        while (n > 0)
        {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
