package Heap.Lesson2;

import Heap.Heap;

import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Heap<Integer> heap = new Heap<Integer>(Integer.class, 100);

        int choice = 5;
        do {
            System.out.println("========== MENU ==========");
            System.out.println("1. Thêm mới một node vào heap.");
            System.out.println("2. Hiển thị các phần tử trong heap ra màn hình.");
            System.out.println("3. Cho biết phần tử lớn nhất trong heap hiện thời.");
            System.out.println("4. Cho biết kích thước hiện thời của heap.");
            System.out.println("5. Thoát chương trình.");
            System.out.println("Bạn chọn?: ");
            choice = input.nextInt();

            switch (choice) {
                case 1: {
                    System.out.println("Nhập giá trị node cần thêm: ");
                    int newNode = input.nextInt();
                    if (heap.add(newNode)) {
                        System.out.println("Thêm thành công.");
                    } else {
                        System.out.println("Thêm thất bại.");
                    }
                    break;
                }
                case 2: {
                    System.out.println("Các phần tử trong heap: ");
                    heap.showElements();
                    break;
                }
                case 3: {
                    System.out.println("Phần tử lớn nhất trong heap: " + heap.maxElement());
                    break;
                }
                case 4: {
                    System.out.println("Kích thược hiện thời của heap: " + heap.getCurrentSize());
                    break;
                }
                case 5: {
                    System.out.println("<= Phiên giao dịch kết thúc. Xin chào và hẹn gặp lại. =>");
                    break;
                }
                default: {
                    System.out.println("Sai chức năng. Vui lòng kiểm tra lại.");
                }
            }
        } while (choice != 5);
    }
}
