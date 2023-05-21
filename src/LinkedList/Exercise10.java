package LinkedList;

import java.util.Scanner;

public class Exercise10 {
    public static void main(String[] args) {
        int choice = 7;
        Scanner input = new Scanner(System.in);
        DLLS listStudents = new DLLS();

        do {
            menu();
            choice = input.nextInt();

            switch (choice) {
                case 1: {
                    addStudentToList(listStudents);
                    break;
                }
                case 2: {
                    input.nextLine();
                    System.out.println("Nhập mã sinh viên cần xoá: ");
                    String id = input.nextLine();
                    removeStudentByID(listStudents, id);
                    break;
                }
                case 3: {
                    input.nextLine();
                    System.out.println("Nhập tên sinh viên cần xoá: ");
                    String name = input.nextLine();
                    removeStudentByName(listStudents, name);
                    break;
                }
                case 4: {
                    System.out.println("Nhập GPA: ");
                    double gpa = input.nextDouble();
                    System.out.println("Nhập số sinh viên tối đa cần xoá: ");
                    int n = input.nextInt();
                    removeStudentByGPA(listStudents, gpa, n);
                    break;
                }
                case 5: {
                    System.out.println("Nhập tuổi sinh viên cần xoá: ");
                    int age = input.nextInt();
                    removeStudentByAge(listStudents, age);
                    break;
                }
                case 6: {
                    showListStudents(listStudents);
                    break;
                }
                case 7: {
                    System.out.println("<= Phiên giao dịch kết thúc. Hẹn gặp lại!=>");
                    break;
                }
                default: {
                    System.out.println("Chỉ nhập từ 1->7.");
                }
            }
        } while (choice != 7);
    }

    private static void showListStudents(DLLS listStudents) {
        System.out.println("Danh sách sinh viên: ");
        listStudents.TraversalFromHead();
    }

    private static void removeStudentByAge(DLLS listStudents ,int age) {
        if (!listStudents.isEmpty()) {
            int count = 0;
            var result = listStudents.removeStudentByAge(age);
            if (result) {
                while (result) {
                    result = listStudents.removeStudentByAge(age);
                    count++;
                    System.out.printf("Xoá thành công sinh viên thứ %d có tuổi là %d!\n", count, age);
                }
            } else {
                System.out.println("Không tìm thấy sinh viên có tuổi bằng: " + age);
            }
        } else {
            System.out.println("Danh sách rỗng");
        }
    }

    private static void removeStudentByGPA(DLLS listStudents ,double gpa, int n) {
        if (n > 0) {
            if (!listStudents.isEmpty()) {
                int count = 0;
                while (true) {
                    var result = listStudents.removeStudentByGPA(gpa);
                    if (!result || count >= n) {
                        break;
                    } else {
                        count++;
                    }
                }
            } else {
                System.out.println("Danh sách rỗng!");
            }
        } else {
            System.out.println("Số sinh viên tối đa cần xoá không hợp lệ! Vui lòng kiểm tra lại.");
        }
    }

    private static void removeStudentByName(DLLS listStudents, String name) {
        if (!listStudents.isEmpty()) {
            var result = listStudents.removeStudentByName(name);
            if (result) {
                System.out.println("Xoá thành công sinh viên có tên là: " + name);
            } else {
                System.out.println("Không tìm thấy sinh viên có tên là: " + name);
            }
        } else {
            System.out.println("Danh sách rỗng!");
        }
    }

    private static void addStudentToList(DLLS listStudents) {
        Scanner input = new Scanner(System.in);

        String id;
        String fullName;
        String address;
        String email;
        int age;
        double gpa;

        System.out.println("Nhập mã sinh viên: ");
        id = input.nextLine();
        System.out.println("Nhập họ và tên: ");
        fullName = input.nextLine();
        System.out.println("Nhập địa chỉ: ");
        address = input.nextLine();
        System.out.println("Nhập email: ");
        email = input.nextLine();
        System.out.println("Nhập tuổi: ");
        age = input.nextInt();
        System.out.println("Nhập GPA: ");
        gpa = input.nextDouble();

        Student student = new Student(id, fullName, address, email, age, gpa);
        listStudents.insertTail(student);
        System.out.println("Thêm thành công sinh viên có mã sinh viên là: " + student.getId() + " vào danh sách sinh viên!");
    }

    private static void removeStudentByID(DLLS listStudents, String id) {
        if (!listStudents.isEmpty()) {
            var result = listStudents.removeNode(new Student(id));
            if (result) {
                System.out.println("Xoá thành công sinh viên có mã là: " + id);
            } else {
                System.out.println("Không tìm thấy sinh viên có mã là: " + id);
            }
        } else {
            System.out.println("Danh sách rỗng!");
        }
    }

    private static void menu() {
        System.out.println("========== MENU ==========");
        System.out.println("1. Thêm mới sinh viên vào danh sách.");
        System.out.println("2. Xóa sinh viên có mã x nhập vào từ bàn phím.");
        System.out.println("3. Xóa tất cả các sinh viên có tên x nhập vào từ bàn phím.");
        System.out.println("4. Xóa tối đa n sinh viên có điểm trung bình nhỏ hơn x nhập vào từ bàn phím.");
        System.out.println("5. Xóa tất cả các sinh viên có tuổi bằng x nhập vào từ bàn phím.");
        System.out.println("6. Hiển thị danh sách sinh viên ra màn hình.");
        System.out.println("7. Thoát chương trình.");
        System.out.println("Bạn chọn?: ");
    }
}
