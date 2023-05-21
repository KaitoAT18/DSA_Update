package Array.Lesson4;

import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        int n;
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập số nguyên dương: ");
        n = input.nextInt();
        int s = sum(n);
        System.out.printf("Sum = %d\n",s);
    }

    private static int sum(int n) {
        if (n == 1) return n;           //điểm dừng
        return n + sum(n-1);         //Bước đệ quy
    }
}
