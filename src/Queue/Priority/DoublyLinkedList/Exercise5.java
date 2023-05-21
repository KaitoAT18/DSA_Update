package Queue.Priority.DoublyLinkedList;

import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
        PriorityQueue<String> queue = new PriorityQueue<>();
        Scanner input = new Scanner(System.in);

        int choice = 8;
        do {
            System.out.println("========== MENU ==========");
            System.out.println("1. Thêm mới một phần tử vào hàng đợi.");
            System.out.println("2. Xoá và trả về phần tử đầu hàng đợi.");
            System.out.println("3. Lấy phần tử đầu hàng đợi nhưng không xoá.");
            System.out.println("4. Lấy số phần tử hiện có trong hàng đợi.");
            System.out.println("5. Hiển thị các phần tử trong hàng đợi.");
            System.out.println("6. Kiểm tra queue rỗng không.");
            System.out.println("7. Cho biết nhũng phần tử nào có mức ưu tiên nhỏ nhất.");
            System.out.println("8. Thoát chương trình.");
            System.out.println("Bạn chọn?: ");
            choice = input.nextInt();

            switch (choice) {
                case 1: {
                    System.out.println("Nhập phần tử: ");
                    input.nextLine();
                    String e = input.nextLine();
                    System.out.println("Nhập thứ tự ưu tiên: ");
                    int priority = input.nextInt();
                    queue.add(e, priority);
                    break;
                }
                case 2: {
                    System.out.println("Phần tử đầu hàng đợi: " + queue.remove());
                    break;
                }
                case 3: {
                    System.out.println("Phần tử đầu hàng đợi: " + queue.peek());
                    break;
                }
                case 4: {
                    System.out.println("Số phần tử hiện có trong hàng đợi: " + queue.size());
                    break;
                }
                case 5: {
                    if (!queue.isEmpty()) {
                        System.out.println("Danh sách hàng đợi: ");
                        queue.display();
                    } else {
                        System.out.println("Queue rỗng.");
                    }
                    break;
                }
                case 6: {
                    System.out.println("Queue rỗng?: " + queue.isEmpty());
                    break;
                }
                case 7: {
                    System.out.println("Những phần tử có mức ưu tiên nhỏ nhất là: ");
                    queue.minElements();
                    break;
                }
                case 8: {
                    System.out.println("<= Xin chào và hẹn gặp lại =>");
                    break;
                }
                default: {
                    System.out.println("Sai chức năng. Vui lòng nhập lại!");
                    break;
                }
            }
        } while (choice != 8);
    }
}
