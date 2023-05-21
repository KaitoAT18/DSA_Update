package Array.Lesson4;

import java.util.Scanner;

public class Lesson3 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        System.out.print("Nhập số nguyên dương n: ");
        var n = input.nextInt();
        System.out.println("Tổng các chữ số của n: " + sumDigits(n));
    }

    /**
     * Tổng các chữ số của số n
     * @param n số nhập từ bàn phím
     * @return tổng các chữ số của số n
     */
    private static int sumDigits(int n) {
        if (n < 10) return n;
        return n % 10 + sumDigits(n/10);
    }
}
