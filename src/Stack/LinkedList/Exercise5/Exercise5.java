package Stack.LinkedList.Exercise5;

import Stack.LinkedList.Stack;

import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
        Stack<Student> studentStack = new Stack<>();
        Scanner input = new Scanner(System.in);
        int choice = 5;

        do {
            System.out.println("========== MENU ==========");
            System.out.println("1. Thêm mới sinh viên vào stack.");
            System.out.println("2. Hiển thị thông tin sinh viên đầu stack.");
            System.out.println("3. Kiểm tra xem stack hiện chứa bao nhiêu sinh viên.");
            System.out.println("4. Hiển thị các sinh viên có trong stack.");
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
                    System.out.println("Gpa: ");
                    gpa = input.nextFloat();
                    input.nextLine();

                    Student student = new Student(id, firstName, midName, lastName, address, email, age, gpa);
                    studentStack.push(student);
                    System.out.println("Thêm thành công sinh viên vào stack.");
                    break;
                }
                case 2: {
                    if (!studentStack.isEmpty()) {
                        Student topStudent = studentStack.peek();
                        showHeader();
                        showStudentInfo(topStudent);
                    } else {
                        System.out.println("Stack rỗng.");
                    }
                    break;
                }
                case 3: {
                    System.out.println("Số sinh viên có trong stack: " + studentStack.size() + " sinh viên.");
                    break;
                }
                case 4: {
                    if (!studentStack.isEmpty()) {
                        showHeader();
                        showListStudent(studentStack);
                    } else {
                        System.out.println("Stack rỗng.");
                    }
                    break;
                }
                case 5: {
                    System.out.println("<=... Xin chào và hẹn gặp lại ...=>");
                    break;
                }
                default: {
                    System.out.println("Sai chức năng. Vui lòng kiểm tra lại!");
                }
            }
        } while (choice != 5);
    }

    private static void showListStudent(Stack<Student> studentStack) {
        while (!studentStack.isEmpty()) {
            showStudentInfo(studentStack.peek());
            studentStack.pop();
        }
        System.out.println();
    }

    public static void showHeader() {
        System.out.printf("%-15s%-15s%-15s%-15s%-20s%-30s%-10s%-15s\n",
                "Mã SV", "Họ", "Đệm", "Tên", "Địa chỉ", "Email", "Tuổi", "Điểm TB");
    }

    public static void showStudentInfo(Student e) {
        System.out.printf("%-15s%-15s%-15s%-15s%-20s%-30s%-10d%-15.2f\n",
                e.getId(), e.getFirstName(),
                e.getMidName(), e.getLastName(),
                e.getAddress(), e.getEmail(),
                e.getAge(), e.getGpa());
    }
}
