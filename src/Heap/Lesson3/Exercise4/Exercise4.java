package Heap.Lesson3.Exercise4;

import Heap.Lesson3.Data.Student;

import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        Heap<Student> heap = new Heap<>(100);
        Scanner input = new Scanner(System.in);
        int choice = 7;

        do {
            System.out.println("=================== MENU ===================");
            System.out.println("1. Thêm mới 1 phần tử.");
            System.out.println("2. Hiển thị các phần tử trong heap.");
            System.out.println("3. Tìm xem node có giá trị x có tồn tại không.");
            System.out.println("4. Xóa node có giá trị x khỏi heap.");
            System.out.println("5. Cho biết phần tử nhỏ nhất trong heap.");
            System.out.println("6. Cho biết kích thước của heap hiện thời.");
            System.out.println("7. Thoát chương trình.");
            System.out.println("Bạn chọn?: ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1: {
                    System.out.println("Mã sinh viên: ");
                    String id = input.nextLine();
                    System.out.println("Họ: ");
                    String lastName = input.nextLine();
                    System.out.println("Đệm: ");
                    String midName = input.nextLine();
                    System.out.println("Tên: ");
                    String firstName = input.nextLine();
                    System.out.println("Điểm TB: ");
                    float gpa = input.nextFloat();
                    heap.add(new Student(id, firstName, midName, lastName, gpa));
                    break;
                }
                case 2: {
                    System.out.println("Các phần tử trong heap: ");
                    heap.showElements();
                    break;
                }
                case 3: {
                    System.out.println("Nhập mã sinh viên: ");
                    String id = input.nextLine();
                    var student = new Student(id);
                    int findXIndex = heap.findNode(student);
                    if (findXIndex != -1) {
                        System.out.printf("Sinh viên mã \"%s\" tồn tại trong heap.\n", student.getId());
                    } else {
                        System.out.printf("Sinh viên mã \"%s\" không tồn tại trong heap.\n", student.getId());
                    }
                    break;
                }
                case 4: {
                    System.out.println("Nhập mã sinh viên: ");
                    String id = input.nextLine();
                    var student = new Student(id);
                    boolean removeX = heap.remove(student);
                    if (removeX) {
                        System.out.println("Xoá thành công!");
                    } else {
                        System.out.println("Xoá thất bại!");
                    }
                    break;
                }
                case 5: {
                    try {
                        System.out.println("Sinh viên có mã nhỏ nhất: " + heap.min());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 6: {
                    System.out.println("Kích thước của heap: " + heap.size());
                    break;
                }
                case 7: {
                    System.out.println("Chương trình kết thúc.");
                    break;
                }
                default: {
                    System.out.println("Sai chức năng. Vui lòng chọn lại.");
                    break;
                }
            }
        } while (choice != 7);
    }
}
