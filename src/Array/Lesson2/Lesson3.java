package Array.Lesson2;

import java.util.Scanner;

public class Lesson3 {
    public static void main(String[] args) {
        int h;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chiều cao tam giác: ");
        h = scanner.nextInt();
        var triangle = new String[h][h];

        fillTriangle(triangle);         //Vẽ hình tam giác lưu vào mảng 2 chiều kiểu String
        onScreen(triangle);             //Hiện kết quả
    }

    private static void fillTriangle(String[][] triangle) {
        var h = triangle.length;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < h; j++) {
                if (j >= i) triangle[i][j] = " * ";
            }
        }
    }

    private static void onScreen(String[][] triangle) {
        for (var row: triangle) {
            for (var col: row) {
                if (col == null) {
                    col = "   ";
                    System.out.print(col);
                } else {
                    System.out.print(col);
                }
            }
            System.out.println();
        }
    }
}

