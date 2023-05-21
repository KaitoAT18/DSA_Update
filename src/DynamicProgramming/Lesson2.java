package DynamicProgramming;

import java.util.Scanner;

/**
 * 7! = 6!.7    f(n-1)*n
 * 6! = 5!.6
 * 5! = 4!.5
 * ...
 * 2! = 1!.2
 * 1! = 1
 */

public class Lesson2 {
    private static final int MAX = 20;
    private static long[] factorial = new long[MAX+1];
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập số nguyên dương n: ");
        int n = input.nextInt();
        System.out.printf("Top-down: f(%d) = %d\n", n, f(n));
        System.out.printf("Bottom-up: f(%d) = %d\n", n, fV2(n));
    }

    //Top-down
    private static long f(int n) {
        if (n == 1) {
            return factorial[n] = 1;
        }
        if (factorial[n] == 0) {
            factorial[n] = n*f(n-1);
        }
        return factorial[n];
    }

    //Bottom-up
    private static long fV2(int n) {
        long f1 = 1;
        long fn = 1;
        for (int i = 2; i <= n ; i++) {
            fn = i*f1;
            f1 = fn;
        }
        return fn;
    }
}
