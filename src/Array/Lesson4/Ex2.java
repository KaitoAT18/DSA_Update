package Array.Lesson4;

import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        int n;
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập số nguyên dương: ");
        n = input.nextInt();
        long fn =  fibonacci(n);
        System.out.printf("Số fibonacci thứ %d = %d",n,fn);
    }

    /**
     * Phương thức tìm số fibonacci thứ n
     * @param n chỉ số của số fibo cần tìm
     * @return giá trị fn tìm được
     */
    private static long fibonacci(int n) {
        if (n < 2) return n;
        return fibonacci(n-1) + fibonacci(n-2);
    }
}
