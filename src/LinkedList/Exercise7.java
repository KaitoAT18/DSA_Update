package LinkedList;

import java.util.Scanner;

public class Exercise7 {
    public static void main(String[] args) {
        int choice = 7;
        Scanner input = new Scanner(System.in);
        LinkedList listStudents = new LinkedList();
        do {
            System.out.println("========== MENU ==========");
            System.out.println("1. Thêm mới sinh viên vào danh sách.");
            System.out.println("2. Xoá sinh viên theo mã.");
            System.out.println("3. Xoá sinh viên theo tên.");
            System.out.println("4. Xoá tối đa n sinh viên có tuổi bằng x.");
            System.out.println("6. Hiển thị danh sách sinh viên ra màn hình.");
            System.out.println("7. Thoát chương trình.");
            System.out.println("Bạn chọn?: ");
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1: {
                    Student student;
                    String id;
                    String fullName;
                    String address;
                    String email;
                    int age;
                    double gpa;
                    System.out.println("Mã sinh viên: ");
                    id = input.nextLine();
                    System.out.println("Họ tên: ");
                    fullName = input.nextLine();
                    System.out.println("Địa chỉ: ");
                    address = input.nextLine();
                    System.out.println("Email: ");
                    email = input.nextLine();
                    System.out.println("Tuổi: ");
                    age = input.nextInt();
                    System.out.println("Điểm: ");
                    gpa = input.nextDouble();
                    input.nextLine();
                    student = new Student(id, fullName, address, email, age, gpa);
                    listStudents.insertTail(student);
                    break;
                }
                case 2: {
                    if (!listStudents.isEmty()) {
                        System.out.println("Nhập mã sinh viên cần xoá: ");
                        String id = input.nextLine();
                        boolean result = listStudents.removeNode(new Student(id));
                        if (result) {
                            System.out.println("Xoá thành công!");
                        } else {
                            System.out.println("Xoá thất bại!");
                        }
                    } else {
                        System.out.println("Danh sách sinh viên rỗng!");
                    }
                    break;
                }
                case 3: {
                    if (!listStudents.isEmty()) {
                        System.out.println("Nhập tên sinh viên cần xoá: ");
                        String fullName = input.nextLine();
                        boolean isRemoved = false;
                        while (true) {
                            boolean result = listStudents.removeStudentByName(fullName);
                            if (!result) {
                                break;
                            } else {
                                isRemoved = true;
                            }
                        }
                        if (isRemoved) {
                            System.out.println("Xoá sinh viên thành công!");
                        } else {
                            System.out.println("Sinh viên cần xoá không tồn tại!");
                        }
                    } else {
                        System.out.println("Danh sách sinh viên rỗng.");
                    }
                    break;
                }
                case 4: {
                    if (!listStudents.isEmty()) {
                        int n;
                        System.out.println("Nhập số sinh viên tối đa cần xoá: ");
                        n = input.nextInt();
                        if (n > 0) {
                            System.out.println("Nhập mức điểm trung bình để xoá: ");
                            double gpa = input.nextDouble();
                            int counter = 0;
                            while (true) {
                                boolean result = listStudents.removeStudentByGPA(gpa);
                                if (!result || counter >= n) {
                                    break;
                                } else {
                                    counter++;
                                }
                            }
                        } else {
                            System.out.println("Số sinh viên cần xoá không hợp lệ. Vui lòng nhập n > 0");
                        }
                    } else {
                        System.out.println("Danh sách sinh viên rỗng.");
                    }
                    break;
                }
                case 5: {
                    if (!listStudents.isEmty()) {
                        System.out.println("Nhập tuổi của sinh viên cần xoá: ");
                        int age = input.nextInt();
                        boolean isRemoved = false;
                        while (true) {
                            boolean result = listStudents.removeStudentByAge(age);
                            if (!result) {
                                break;
                            } else {
                                isRemoved = true;
                            }
                        }
                        if (isRemoved) {
                            System.out.printf("Các sinh viên có tuổng bằng %d đã được xoá khỏi danh sách!\n", age);
                        } else {
                            System.out.printf("Không có sinh viên nào có tuổi bằng %d.\n", age);
                        }
                    } else {
                        System.out.println("Danh sách sinh viên rỗng.");
                    }
                    break;
                }
                case 6: {
                    if (!listStudents.isEmty()) {
                        listStudents.showList();
                    } else {
                        System.out.println("Danh sách sinh viên rỗng.");
                    }
                    break;
                }
                case 7: {
                    System.out.println("<= Phiên giao dịch kết thúc. Xin chào và hẹn gặp lại quý khách.=>");
                    break;
                }
                default: {
                    System.out.println("Sai chức năng, vui lòng nhập lại!");
                }
            }
        } while (choice != 7);
    }
}
