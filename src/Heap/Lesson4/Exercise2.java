package Heap.Lesson4;

import java.lang.reflect.Array;
import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Heap<Integer> heap = new Heap<>(Integer.class, 100);
        Scanner input = new Scanner(System.in);

        int choice = 7;
        do {
            System.out.println("=============== MENU ===============");
            System.out.println("1. Thêm mới một node vào heap.");
            System.out.println("2. Hiển thị các phần tử trong heap ra màn hình.");
            System.out.println("3. Tìm xem node có giá trị x có tồn tại trong heap hay không.");
            System.out.println("4. Cập nhập node có giá trị x sao cho vẫn đảm bảo tính chất của max heap.");
            System.out.println("5. Xoá node có giá trị x khỏi heap. Hiển thị kết quả xoá thành công hay thất bại.");
            System.out.println("6. Cho biết phần tử lớn nhất trong heap hiện thời.");
            System.out.println("7. Cho biết kích thước hiện thời của heap.");
            System.out.println("8. Thoát chương trình.");
            System.out.println("Bạn chọn?: ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1: {
                    System.out.println("Nhập giá trị node cần thêm: ");
                    int x = input.nextInt();
                    if (heap.add(x)) {
                        System.out.println("Thêm thành công.");
                    } else {
                        System.out.println("Thêm thất bại.");
                    }
                    break;
                }
                case 2: {
                    System.out.println("Danh sách các phần tử trong heap: ");
                    heap.showElements();
                    break;
                }
                case 3: {
                    System.out.println("Nhập giá trị node cần tìm: ");
                    int x = input.nextInt();
                    if (heap.findNode(x) >= 0) {
                        System.out.println("Node có giá trị " + x + " tồn tại trong heap.");
                    } else {
                        System.out.println("Node có giá trị " + x + " không tồn tại trong heap.");
                    }
                    break;
                }
                case 4: {
                    System.out.println("Nhập giá trị node cần cập nhập: ");
                    int x = input.nextInt();
                    if (heap.findNode(x) >= 0) {
                        System.out.println("Nhập giá trị node mới: ");
                        int newX = input.nextInt();
                        if (heap.update(x, newX)) {
                            System.out.println("Cập nhập thành công.");
                        } else {
                            System.out.println("Cập nhập thất bại.");
                        }
                    }
                    break;
                }
                case 5: {
                    System.out.println("Nhập giá trị node cần xoá: ");
                    int x = input.nextInt();
                    if (heap.findNode(x) >= 0) {
                        if (heap.remove(x)) {
                            System.out.println("Xoá thành công.");
                        } else {
                            System.out.println("Xoá thất bại.");
                        }
                    } else {
                        System.out.println("Không tìm thấy node cần xoá.");
                    }
                    break;
                }
                case 6: {
                    System.out.println("Phần tử lớn nhất trong heap hiện thời: " + heap.maxElement());
                    break;
                }
                case 7: {
                    System.out.println("Kích thước hiện thời của heap: " + heap.size());
                    break;
                }
                case 8: {
                    System.out.println("*.* Chương trình kết thúc *.*");
                    break;
                }
                default: {
                    System.out.println("Sai chức năng. Vui lòng kiểm tra lại.");
                }
            }
        } while (choice != 8);
    }
}
