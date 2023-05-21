package Array.Lesson2;

import java.util.Scanner;

public class Lesson2 {
    public static void main(String[] args) {
        int m;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập cạnh hình vuông: ");
        m = scanner.nextInt();
        var rect = new String[m][m];
        
        fillRect(rect);         //Vẽ hình vuông lưu vào mảng 2 chiều kiểu String
        onScreen(rect);         //Hiện kết quả
    }

    private static void onScreen(String[][] rect) {
        for (var row: rect) {
            for (var col: row) {
                System.out.print(col);
            }
            System.out.println();
        }
    }

    private static void fillRect(String[][] rect) {
        for (int i = 1; i <= rect.length; i++) {
            for (int j = 1; j <= rect.length; j++) {
                if (i == 1 || i == rect.length || j == 1 || j == rect.length || i == j || (i+j) == (rect.length+1)) {
                    rect[i-1][j-1] = " * ";
                } else {
                    rect[i-1][j-1] = "   ";
                }
            }
        }
    }
}
