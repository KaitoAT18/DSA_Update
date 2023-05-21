package HashTable.Lesson1;

import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        HashTable<String, Student> hashTable = new HashTable<>(100);
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            System.out.println("============================== MENU ===================================");
            System.out.println("*\t1. Thêm mới 1 sinh viên.                                          *");
            System.out.println("*\t2. Tìm sinh viên theo mã sinh viên.                               *");
            System.out.println("*\t3. Kiểm tra xem một sinh viên có tồn tại hay không.               *");
            System.out.println("*\t4. Kiểm tra key là mã sinh viên nào đó có tồn tại không.          *");
            System.out.println("*\t5. Kiểm tra bảng băm có rỗng không.                               *");
            System.out.println("*\t6. Kiểm tra kích thước của bảng băm.                              *");
            System.out.println("*\t7. Kết thúc chương trình.                                         *");
            System.out.println("=======================================================================");
            System.out.println("Xin mời chọn chức năng số: ");
            choice = input.nextInt();
            input.nextLine();       // đọc bỏ dòng trước đó

            switch (choice) {
                case 1:
                    System.out.println("Mã sinh viên: ");
                    var id = input.nextLine();
                    System.out.println("Họ: ");
                    var last = input.nextLine();
                    System.out.println("Đệm: ");
                    var mid = input.nextLine();
                    System.out.println("Tên: ");
                    var first = input.nextLine();
                    System.out.println("Điểm TB: ");
                    var gpa = input.nextFloat();
                    hashTable.put(id, new Student(id, first, last, mid, gpa));
                    break;
                case 2:
                    if (!hashTable.isEmpty()) {
                        System.out.println("Nhập mã sinh viên cần tìm: ");
                        id = input.nextLine();
                        var result = hashTable.get(id);
                        if (result != null) {
                            System.out.printf("Tìm thấy sinh viên mã \"%s\"\n", id);
                            System.out.println(result);
                        } else {
                            System.out.printf("Tìm thấy sinh viên mã \"%s\"\n", id);
                        }
                    } else {
                        System.out.println("=== Danh sách sinh viên rỗng! ===");
                    }
                    break;
                case 3:
                    if (!hashTable.isEmpty()) {
                        System.out.println("Nhập mã sinh viên cần tìm: ");
                        id = input.nextLine();
                        var newStudent = new Student(id);
                        var checkStudent = hashTable.containsValue(newStudent);
                        if (checkStudent) {
                            System.out.printf("Tồn tại sinh viên mã \"%s\"\n", id);
                        } else {
                            System.out.printf("Không tồn tại sinh viên mã \"%s\"\n", id);
                        }
                    } else {
                        System.out.println("=== Danh sách sinh viên rỗng! ===");
                    }
                    break;
                case 4:
                    if (!hashTable.isEmpty()) {
                        System.out.println("Nhập mã sinh viên cần tìm: ");
                        id = input.nextLine();
                        var checkKey = hashTable.containsKey(id);
                        if (checkKey) {
                            System.out.printf("Tồn tại sinh viên mã \"%s\"\n", id);
                        } else {
                            System.out.printf("Không tồn tại sinh viên mã \"%s\"\n", id);
                        }
                    } else {
                        System.out.println("=== Danh sách sinh viên rỗng! ===");
                    }
                    break;
                case 5:
                    System.out.println(hashTable.isEmpty() ? "Rỗng." : "Không rỗng.");
                    break;
                case 6:
                    System.out.println("Số phần tử hiện có trong bảng băm: " + hashTable.size());
                    break;
                case 7:
                    System.out.println("=== Chương trình kết thúc. ===");
                    break;
                default:
                    System.out.println("=== Sai chức năng. Vui lòng nhập lại. ===");
                    break;
            }
        } while (choice != 7);
    }
}
