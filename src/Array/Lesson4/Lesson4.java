package Array.Lesson4;

import java.util.Scanner;

public class Lesson4 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        System.out.print("Nhập n = ");
        int n = input.nextInt();
        System.out.printf("Reverse %d = ",n);
        reverseNumber(n);
    }

    private static void reverseNumber(int n) {
        if (n > 0) {                //Điều kiện dừng
            System.out.print(n % 10);
            reverseNumber(n/10);
        }
    }
}
