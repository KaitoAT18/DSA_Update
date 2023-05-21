package Queue.Circular.Array;

import Queue.Circular.Array.CircularQueue;

import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        CircularQueue<Number> circularQueue = new CircularQueue<>(10);
        Scanner input = new Scanner(System.in);
        int choice = 8;

        do {
            System.out.println("========== MENU ==========");
            System.out.println("1. Thêm một phần tử vào hàng đợi.");
            System.out.println("2. Xoá và trả về phần tử đầu hàng đợi.");
            System.out.println("3. Lấy phần tử đầu hàng đợi nhưng không xoá.");
            System.out.println("4. Lấy số phần tử của hàng đợi.");
            System.out.println("5. Hiển thị các phần tử của hàng đợi theo thứ tự từ đầu đến cuối.");
            System.out.println("6. Kiểm tra queue rỗng không.");
            System.out.println("7. Kiểm tra queue đã đầy chưa.");
            System.out.println("8. Thoát chương trình.");
            System.out.println("Bạn chọn?: ");
            choice = input.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("Nhập phần tử cần thêm: ");
                    Number number = input.nextInt();
                    System.out.println(circularQueue.enqueue(number));
                    break;
                }
                case 2: {
                    Number firstElement = circularQueue.dequeue();
                    if (firstElement != null) {
                        System.out.println("Phần tử đầu hàng đợi: " + firstElement);
                    }
                    break;
                }
                case 3: {
                    Number fisrtElement = circularQueue.peek();
                    if (fisrtElement != null) {
                        System.out.println("Phần tử đầu hàng đợi: " + fisrtElement);
                    } else {
                        System.out.println("Queue rỗng.");
                    }
                    break;
                }
                case 4: {
                    System.out.println("Số phần tử hiện có trong hàng đợi: " + circularQueue.size());
                    break;
                }
                case 5: {
                    System.out.println("Danh sách các phần tử có trong hàng đợi: ");
                    circularQueue.display();
                    break;
                }
                case 6: {
                    System.out.println("Queue rỗng: " + circularQueue.isEmpty());
                    break;
                }
                case 7: {
                    System.out.println("Queue đầy: " + circularQueue.isFull());
                    break;
                }
                case 8: {
                    System.out.println("<= Phiên giao dịch kết thúc. Xin chào và hẹn gặp lại ! =>");
                    break;
                }
                default: {
                    System.out.println("Sai chức năng. Vui lòng nhập lại.");
                }
            }
        } while (choice != 8);
    }
}
