package Queue.Priority.Library;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Exercise7 {
    public static void main(String[] args) {
        PriorityQueue<Employee> queue = new PriorityQueue<>((o1, o2) -> o1.getLastName().compareTo(o2.getLastName()));
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Scanner input = new Scanner(System.in);

        int choice = 7;
        do {
            System.out.println("========== MENU ==========");
            System.out.println("1. Thêm mới một nhân viên vào hàng đợi.");
            System.out.println("2. Xoá và trả về nhân viên đầu hàng đợi.");
            System.out.println("3. Lấy nhân viên đầu hàng đợi nhưng không xoá.");
            System.out.println("4. Hiển thị các nhân viên trong hàng đợi theo thứ tự từ đầu đến cuối.");
            System.out.println("5. Kiểm tra queue rỗng không.");
            System.out.println("6. Lấy số lượng nhân viên hiện có trong hàng đợi.");
            System.out.println("7. Thoát chương trình.");
            System.out.println("Bạn chọn?: ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1: {
                    System.out.println("Nhập thông tin nhân viên cần thêm mới: ");
                    System.out.println("Nhập mã nhân viên: ");
                    String id = input.nextLine();
                    System.out.println("Nhập họ: ");
                    String firstName = input.nextLine();
                    System.out.println("Nhập tên đệm: ");
                    String midName = input.nextLine();
                    System.out.println("Nhập tên: ");
                    String lastName = input.nextLine();
                    Date doe = null;
                    try {
                        System.out.println("Nhập ngày vào công ty: ");
                        String date = input.nextLine();
                        doe = dateFormat.parse(date);
                    } catch (ParseException parseException) {
                        System.out.println("Vui lòng kiểm tra định dạng ngày tháng!");
                        parseException.printStackTrace();
                    }
                    System.out.println("Nhập chuyên môn: ");
                    String specialize = input.nextLine();
                    System.out.println("Nhập lương: ");
                    long salary = input.nextLong();
                    System.out.println("Nhập số năm kinh nghiệm: ");
                    int experienceYear = input.nextInt();

                    Employee employee = new Employee(id, firstName, midName, lastName, doe, specialize, salary, experienceYear);
                    if (queue.add(employee)) {
                        System.out.println("Thêm thành công nhân viên có mã : \"" + id + "\" + vào danh sách." );
                    } else {
                        System.out.println("Thêm thất bại.");
                    }
                    break;
                }
                case 2: {
                    System.out.println("Nhân viên đầu hàng đợi: " + queue.poll().toString());
                    break;
                }
                case 3: {
                    System.out.println("Nhân viên đầu hàng đợi: " +  queue.peek().toString());
                    break;
                }
                case 4: {
                    if (!queue.isEmpty()) {
                        display(queue);
                    } else {
                        System.out.println("Queue rỗng.");
                    }
                    break;
                }
                case 5: {
                    System.out.println("Queue rỗng?: " + queue.isEmpty());
                    break;
                }
                case 6: {
                    System.out.println("Số nhân viên có trong hàng đợi: " + queue.size());
                    break;
                }
                case 7: {
                    System.out.println("<= Xin chào và hẹn gặp lại =>");
                    break;
                }
                default: {
                    System.out.println("Sai chức năng vui lòng nhập lại!");
                    break;
                }
            }
        } while (choice != 7);
    }

    private static void display(PriorityQueue<Employee> queue) {
        while (!queue.isEmpty()) {
            System.out.println(queue.poll().toString());
        }
        System.out.println();
    }
}
