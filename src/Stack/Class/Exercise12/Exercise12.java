package Stack.Class.Exercise12;

import java.util.Scanner;
import java.util.Stack;

import static Stack.LinkedList.Exercise5.Exercise5.showHeader;


public class Exercise12 {
    public static void main(String[] args) {
        Stack<Student> stack = new Stack<>();
        Scanner input = new Scanner(System.in);

        int choice = 5;
        do {
            System.out.println("~~~~~~~~~~ MENU ~~~~~~~~~~");
            System.out.println("1. Thêm mới sinh viên.");
            System.out.println("2. Hiển thị sinh viên đầu trong danh sách.");
            System.out.println("3. Kiểm tra xem danh sách chứa bao nhiêu sinh viên.");
            System.out.println("4. Hiển thị danh sách.");
            System.out.println("5. Thoát chương trình.");
            System.out.println("Bạn chọn?: ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1: {
                     String id;
                     String firstName;
                     String midName;
                     String lastName;
                     String address;
                     String email;
                     int age;
                     float gpa;

                    System.out.println("Mã sinh viên: ");
                    id = input.nextLine();
                    System.out.println("Họ: ");
                    firstName = input.nextLine();
                    System.out.println("Tên đệm: ");
                    midName = input.nextLine();
                    System.out.println("Tên: ");
                    lastName = input.nextLine();
                    System.out.println("Địa chỉ: ");
                    address = input.nextLine();
                    System.out.println("Email: ");
                    email = input.nextLine();
                    System.out.println("Tuổi: ");
                    age = input.nextInt();
                    System.out.println("GPA: ");
                    gpa = input.nextFloat();

                    Student student = new Student(id, firstName, midName, lastName, address, email, age, gpa);
                    stack.add(student);
                    System.out.println("Thêm thành công sinh viên có mã: \"" + id + "\". + vào danh sách.");
                    break;
                } case 2: {
                    if (!stack.isEmpty()) {
                        System.out.println("Thông tin sinh viên đầu danh sách: ");
                        Student topStudent = stack.peek();
                        showHeader();
                        showStudentInfo(topStudent);
                    } else {
                        System.out.println("Danh sách rỗng.");
                    }
                    break;
                } case 3: {
                    System.out.println("Danh sách có " + stack.size() + " sinh viên.");
                    break;
                } case 4: {
                    if (!stack.isEmpty()) {
                        System.out.println("Danh sách sinh viên: ");
                        showHeader();
                        showListStudent(stack);
                    } else {
                        System.out.println("Danh sách rỗng.");
                    }
                    break;
                } case 5: {
                    System.out.println("<= Phiên giao dịch kết thúc. Xin chào và hẹn gặp lại! =>");
                    break;
                }
                default: {
                    System.out.println("Sai chức năng. Vui lòng kiểm tra lại!");
                    break;
                }
            }
        } while (choice != 5);
    }

    private static void showListStudent(Stack<Student> stack) {
        while (!stack.isEmpty()) {
            showStudentInfo(stack.pop());
        }
        System.out.println();
    }

    private static void showStudentInfo(Student e) {
        System.out.printf("%-15s%-15s%-15s%-15s%-20s%-30s%-10d%-15.2f\n",
                e.getId(), e.getFirstName(),
                e.getMidName(), e.getLastName(),
                e.getAddress(), e.getEmail(),
                e.getAge(), e.getGpa());
    }
}
