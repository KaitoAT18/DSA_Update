package Heap.Lesson4.Exercise4;

import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        Heap<Student> heap = new Heap<>(100);
        Scanner input = new Scanner(System.in);
        int choice = 8;

        do {
            System.out.println("=============== MENU ===============");
            System.out.println("1. Thêm mới một node vào heap.");
            System.out.println("2. Hiển thị các phần tử trong heap ra màn hình.");
            System.out.println("3. Tìm xem node có giá trị x có tồn tại trong heap hay không.");
            System.out.println("4. Cập nhập node có giá trị x sao cho vẫn đảm bảo tính chất của min heap.");
            System.out.println("5. Xoá node có giá trị x khỏi heap. Hiển thị kết quả xoá thành công hay thất bại.");
            System.out.println("6. Cho biết phần tử nhỏ nhất trong heap hiện thời.");
            System.out.println("7. Cho biết kích thước hiện thời của heap.");
            System.out.println("8. Thoát chương trình.");
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

                    var student = new Student(id, firstName, midName, lastName, gpa);
                    if (heap.add(student)) {
                        System.out.println("Thêm thành công sinh viên có mã \"" + id + "\" + vào danh sách.");
                    } else {
                        System.out.println("Thêm thất bại.");
                    }
                    break;
                }
                case 2: {
                    System.out.println("Danh sách sinh viên: ");
                    heap.showElements();
                    break;
                }
                case 3: {
                    System.out.println("Nhập mã sinh viên cần tìm: ");
                    String id = input.nextLine();
                    var student = new Student(id);
                    int found = heap.findNode(student);
                    if (found >= 0) {
                        System.out.println("Tìm thấy sinh viên có mã \"" + id + "\" trong danh sách.");
                    } else {
                        System.out.println("Không tìm thấy sinh viên có mã \"" + id + "\" trong danh sách.");
                    }
                    break;
                }
                case 4: {
                    System.out.println("Nhập mã sinh viên cần cập nhập: ");
                    String id = input.nextLine();
                    var student = new Student(id);
                    if (heap.findNode(student) >= 0) {
                        System.out.println("Mã sinh viên: ");
                        String newId = input.nextLine();
                        System.out.println("Họ: ");
                        String lastName = input.nextLine();
                        System.out.println("Đệm: ");
                        String midName = input.nextLine();
                        System.out.println("Tên: ");
                        String firstName = input.nextLine();
                        System.out.println("Điểm TB: ");
                        float gpa = input.nextFloat();

                        var newStudent = new Student(newId, firstName, midName, lastName, gpa);
                        if (heap.update(student, newStudent)) {
                            System.out.println("Cập nhập thành công.");
                        } else {
                            System.out.println("Cập nhập thất bại.");
                        }
                    } else {
                        System.out.println("Không tìm thấy sinh viên cần cập nhập.");
                    }
                    break;
                }
                case 5: {
                    System.out.println("Nhập mã sinh viên cần xoá: ");
                    String id = input.nextLine();
                    var student = new Student(id);
                    if (heap.findNode(student) >= 0) {
                        if (heap.remove(student)) {
                            System.out.println("Xoá thành công.");
                        } else {
                            System.out.println("Xoá thất bại.");
                        }
                    } else {
                        System.out.println("Không tìm thấy sinh viên cần cập nhập.");
                    }
                    break;
                }
                case 6: {
                    System.out.println("Sinh viên có mã sinh viên nhỏ nhất: " + heap.minElement());
                    break;
                }
                case 7: {
                    System.out.println("Số phần tử trong danh sách: " + heap.size());
                    break;
                }
                case 8: {
                    System.out.println("~.~ Chương trình kết thúc ~.~");
                    break;
                }
                default:
                    System.out.println("Sai chức năng. Vui lòng kiểm tra lại.");
            }
        } while (choice != 8);
    }
}
