package LinkedList.Exercise17;

import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

public class Exercise17 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Vector<Student> listStudent = new Vector<>();

        int choice = 0;
        do {
            System.out.println("=============== MENU ===============");
            System.out.println("1. Thêm mới sinh viên.");
            System.out.println("2. Tìm sinh viên theo mã sinh viên nhập vào từ bàn phím. Hiển thị thông tim chi tiết ra màn hình.");
            System.out.println("3. Cập nhập điểm trung bình cho sinh viên theo mã sinh viên.");
            System.out.println("4. Xoá sinh viên có mã x.");
            System.out.println("5. Sắp xếp sinh viên theo yêu cầu.");
            System.out.println("6. Tìm số sinh viên có điểm trung bình >= x.");
            System.out.println("7. Liệt kê tất cả sinh viên trong tên có cụm x.");
            System.out.println("8. Hiển thị danh sách sinh viên.");
            System.out.println("0. Thoát chương trình.");
            System.out.println("Bạn chọn?: ");

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 0: {
                    System.out.println("<= Phiên giao dịch kết thúc. Xin chào và hẹn gặp lại! =>");
                    break;
                }
                case 1: {
                    String id;
                    String firstName;
                    String midName;
                    String lastName;
                    String address;
                    String email;
                    int age;
                    float gpa;

                    System.out.println("Nhập mã sinh viên: ");
                    id = input.nextLine();
                    System.out.println("Nhập họ: ");
                    lastName = input.nextLine();
                    System.out.println("Nhập tên đệm: ");
                    midName = input.nextLine();
                    System.out.println("Nhập tên: ");
                    firstName = input.nextLine();
                    System.out.println("Nhập địa chỉ: ");
                    address = input.nextLine();
                    System.out.println("Nhập email: ");
                    email = input.nextLine();
                    System.out.println("Nhập tuổi: ");
                    age = input.nextInt();
                    System.out.println("Nhập gpa: ");
                    gpa = input.nextFloat();
                    input.nextLine();

                    Student student = new Student(id, firstName, midName, lastName, address, email, age, gpa);
                    listStudent.add(student);
                    break;
                }
                case 2: {
                    if (!listStudent.isEmpty()) {
                        System.out.println("Nhập mã sinh viên: ");
                        String id = input.nextLine();

                        int index = -1;
                        for (var e: listStudent) {
                            if (e.getId().toLowerCase().compareTo(id.toLowerCase()) == 0) {
                                index = listStudent.indexOf(e);
                                break;
                            }
                        }
                        if (index >= 0) {
                            showHeader();
                            showStudent(listStudent.get(index));
                        } else {
                            System.out.println("Không tìm thấy sinh viên có mã \"" + id + "\".");
                        }
                    } else {
                        System.out.println("Danh sách sinh viên rỗng!");
                    }
                    break;
                }
                case 3: {
                    if (!listStudent.isEmpty()) {
                        System.out.println("Nhập mã sinh viên: ");
                        String id = input.nextLine();
                        int index = -1;
                        for (var e: listStudent) {
                            if (e.getId().toLowerCase().compareTo(id.toLowerCase()) == 0) {
                                index = listStudent.indexOf(e);
                                break;
                            }
                        }
                        if (index >= 0) {
                            System.out.println("Nhập điểm trung bình: ");
                            float gpa = input.nextFloat();
                            Student student = listStudent.get(index);
                            student.setGpa(gpa);
                            listStudent.set(index, student);
                        } else {
                            System.out.println("Không tìm thấy sinh viên có mã \"" + id + "\".");
                        }
                    } else {
                        System.out.println("Danh sách sinh viên rỗng!");
                    }
                    break;
                }
                case 4: {
                    if (!listStudent.isEmpty()) {
                        System.out.println("Nhập mã sinh viên cần xoá: ");
                        String id = input.nextLine();

                        boolean removed = false;
                        for (var e: listStudent) {
                            if (e.getId().toLowerCase().compareTo(id.toLowerCase()) == 0) {
                                listStudent.remove(e);
                                removed = true;
                                break;
                            }
                        }
                        if (removed) {
                            System.out.println("Xoá thành công sinh viên có mã \"" + id + "\".");
                        } else {
                            System.out.println("Không tìm thấy sinh viên có mã \"" + id + "\".");
                        }
                    } else {
                        System.out.println("Danh sách sinh viên rỗng!");
                    }
                    break;
                }
                case 5: {
                    if (!listStudent.isEmpty()) {
                        int choose = 0;
                        do {
                            System.out.println("===== MENU =====");
                            System.out.println("1. Mã sinh viên tăng dần.");
                            System.out.println("2. Tên sinh viên từ a-z.");
                            System.out.println("3. Tuổi tăng dần.");
                            System.out.println("4. Điểm trung bình giảm dần.");
                            System.out.println("0. Thoát.");
                            System.out.println("Bạn chọn?: ");
                            choose = input.nextInt();

                            switch (choose) {
                                case 1: {
                                    listStudent.sort(new SortingByID());
                                    break;
                                }
                                case 2: {
                                    listStudent.sort(new SortingByName());
                                    break;
                                }
                                case 3: {
                                    listStudent.sort(new SortingByAge());
                                    break;
                                }
                                case 4: {
                                    listStudent.sort(new SortingByGpaDESC());
                                    break;
                                }
                                default: {
                                    System.out.println("Sai chức năng. Vui lòng kiểm tra lại!");
                                }
                            }
                        } while (choose != 0);
                    } else {
                        System.out.println("Danh sách sinh viên rỗng!");
                    }
                    break;
                }
                case 6: {
                    if (!listStudent.isEmpty()) {
                        float x;
                        do {
                            System.out.println("Nhập x = ");
                            x = input.nextFloat();
                        } while (x <= 0 && x >= 4);

                        int countStudent = 0;
                        for (var e: listStudent) {
                            if (e.getGpa() >= x) {
                                countStudent++;
                            }
                        }
                        System.out.printf("Có %d sinh viên có điểm trung bình >= %f.", countStudent, x);
                    } else {
                        System.out.println("Danh sách sinh viên rỗng!");
                    }
                    break;
                }
                case 7: {
                    if (!listStudent.isEmpty()) {
                        System.out.println("Đang update tính năng này.");
                    } else {
                        System.out.println("Danh sách sinh viên rỗng!");
                    }
                    break;
                }
                case 8: {
                    if (!listStudent.isEmpty()) {
                        showHeader();
                        showListStudent(listStudent);
                    } else {
                        System.out.println("Danh sách sinh viên rỗng!");
                    }
                    break;
                }
                default: {
                    System.out.println("Sai chức năng. Vui lòng kiểm tra lại!");
                    break;
                }
            }
        }while (choice != 0) ;
    }

    private static void showListStudent(Vector<Student> listStudent) {
        for (var e: listStudent) {
            showStudent(e);
        }
        System.out.println();
    }

    private static void showStudent(Student e) {
        System.out.printf("%-15s%-15s%-15s%-15s%-20s%-30s%-10d%-15.2f\n",
                e.getId(), e.getFirstName(),
                e.getMidName(), e.getLastName(),
                e.getAddress(), e.getEmail(),
                e.getAge(), e.getGpa());
    }

    private static void showHeader() {
        System.out.printf("%-15s%-15s%-15s%-15s%-20s%-30s%-10s%-15s\n",
                "Mã SV", "Họ", "Đệm", "Tên", "Địa chỉ", "Email", "Tuổi", "Điểm TB");
    }
}
