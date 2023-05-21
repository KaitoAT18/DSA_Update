package DynamicProgramming;

import java.util.Scanner;

public class Lesson1 {
    private static final int MAX = 90;
    private static long[] fibo = new long[MAX];
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập n: ");
        int n = input.nextInt();

        System.out.printf("Top-down: Fibonacci(%d) = %d\n", n, fibonacci(n));
        System.out.printf("Bottom-up: Fibonacci(%d) = %d\n", n, fibonacciV2(n));
    }

    //Top-down
    private static long fibonacci(int n) {
        if (n < 2) {
            return fibo[n] = n;
        }
        if (fibo[n] == 0) {
            fibo[n] = fibonacci(n-1) + fibonacci(n-2);
        }
        return fibo[n];
    }

    //Bottom-up
    private static long fibonacciV2(int n) {
        long f0 = 0;
        long f1 = 1;
        long fn = (n < 2) ? n:0;

        for (int i = 2; i <= n; i++) {
            fn = f0 + f1;
            f0 = f1;
            f1 = fn;
        }
        return fn;
    }
}
