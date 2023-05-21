package Heap.Lesson6.MaxHeap;

import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        PriorityQueue<String> queue = new PriorityQueue<>(100);
        Scanner input = new Scanner(System.in);

        int choice = 9;

        do {
            System.out.println("-------------------- MENU --------------------");
            System.out.println("1. Thêm mới một node vào hàng đợi.");
            System.out.println("2. Hiển thị các phần tử trong hàng đợi ra màn hình.");
            System.out.println("3. Tìm xem node mang giá trị x có tồn tại trong hàng đợi hay không.");
            System.out.println("4. Lấy phần tử đầu hàng đợi. Hiển thị thông tin của node đó.");
            System.out.println("5. Xoá phần tử đầu hàng đợi. Hiển thị kết quả xoá thành công hay thất bại.");
            System.out.println("6. Kiểm tra xem hàng đợi có rỗng không ?.");
            System.out.println("7. Kiểm tra xem hàng đợi đã đầy chưa ?.");
            System.out.println("8. Cho biết kích thước hiện thời của hàng đợi.");
            System.out.println("9. Thoát chương trình.");
            System.out.println("Bạn chọn: ");

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1: {
                    System.out.println("Nhập giá trị: ");
                    String data = input.nextLine();
                    System.out.println("Nhập độ ưu tiên: ");
                    int priority = input.nextInt();
                    if (queue.add(data, priority)) {
                        System.out.println("Thêm thành công.");
                    } else {
                        System.out.println("Thêm thất bại.");
                    }
                    break;
                } case 2: {
                    System.out.println("Danh sách các phần tử trong hàng đợi: ");
                    queue.showElements();
                    break;
                }
                case 3: {
                    System.out.println("Nhập giá trị của node kiểm tra: ");
                    String data = input.nextLine();
                    if (queue.search(data) >= 0) {
                        System.out.println("Tìm thấy node có giá trị " + "'" + data + "'" + " trong hàng đợi");
                    } else {
                        System.out.println("Không tìm thấy node có giá trị " + "'" + data + "'" + " trong hàng đợi");
                    }
                    break;
                }
                case 4: {
                    System.out.println("Phần tử ở đầu hàng đợi: " + queue.peek().getValue());
                    queue.getInfoElement(queue.peek());
                    break;
                }
                case 5: {
                    if (queue.pop() != null) {
                        System.out.println("Xoá thành công.");
                    } else {
                        System.out.println("Xoá thất bại.");
                    }
                    break;
                }
                case 6: {
                    System.out.println("Hàng đợi rỗng?: " + queue.isEmpty());
                    break;
                }
                case 7: {
                    System.out.println("Hàng đợi đầy?: " + queue.isFull());
                    break;
                }
                case 8: {
                    System.out.println("Kích thước hiện tại của hàng đợi: " + queue.size());
                    break;
                }
                case 9: {
                    System.out.println("Chương trình kết thúc.");
                    break;
                }
                default:
                    System.out.println("Sai chức năng. Vui lòng nhập lại.");
            }
        } while (choice != 9);
    }
}
