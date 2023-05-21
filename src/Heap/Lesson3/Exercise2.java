package Heap.Lesson3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Heap<Integer> heap = new Heap<>(Integer.class, 20);
        Scanner input = new Scanner(System.in);

        int choice = 7;
        do {
            System.out.println("~~~~~~~~~~ MENU ~~~~~~~~~~");
            System.out.println("1. Thêm mới một node vào heap.");
            System.out.println("2. Hiển thị các phần tử trong heap ra màn hình.");
            System.out.println("3. Tìm xem node có giá trị x có tồn tại trong heap hay không.");
            System.out.println("4. Xoá node có giá trị x khỏi heap. Hiển thị kết quả xoá thành công hay thất bại.");
            System.out.println("5. Cho biết phần tử lớn nhất trong heap hiện thời.");
            System.out.println("6. Cho biết kích thước hiện thời của heap.");
            System.out.println("7. Thoát chương trình.");
            System.out.println("Bạn chọn?: ");

            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1 -> {
                    System.out.println("Nhập giá trị cần thêm: ");
                    int x = input.nextInt();
                    if (heap.add(x)) {
                        System.out.println("Thêm thành công.");
                    } else {
                        System.out.println("Thêm thất bại.");
                    }
                }
                case 2 -> {
                    System.out.println("Các phần tử trong heap: ");
                    heap.showElements();
                }
                case 3 -> {
                    System.out.println("Nhập giá trị node cần tìm: ");
                    int x = input.nextInt();
                    if (heap.findNode(x) >= 0) {
                        System.out.println("Tìm thấy node có giá trị " + x);
                    } else {
                        System.out.println("Không tìm thấy node có giá trị " + x);
                    }
                }
                case 4 -> {
                    System.out.println("Nhập giá trị node cần xoá: ");
                    int x = input.nextInt();
                    if (heap.remove(x)) {
                        System.out.println("Xoá thành công.");
                    } else {
                        System.out.println("Xoá thất bại.");
                    }
                }
                case 5 -> System.out.println("Phần tử lớn nhất trong heap: " + heap.maxElement());
                case 6 -> System.out.println("Kích thước hiện tại của heap: " + heap.size());
                case 7 -> System.out.println("<=== Phiên giao dịch kết thúc. Xin chào và hẹn gặp lại. ===>");
                default -> System.out.println("Sai chức năng. Vui lòng kiểm tra lại.");
            }
        } while (choice != 7);
    }
}
