package LinkedList;

import java.util.Scanner;

public class Exercise3 {

    public static void main(String[] args) {
        DoublyLinkedList<Student> listStudents = new DoublyLinkedList<Student>();
        Scanner input = new Scanner(System.in);

        fillDemoData(listStudents);
        System.out.println("Các phần tử trong danh sách: ");
        listStudents.TraversalFromHead();

        String id;
        String email;
        Double gpa;

        System.out.print("Nhập mã sinh viên cần cập nhập: ");
        id = input.nextLine();
        System.out.println("Nhập email mới: ");
        email = input.nextLine();
        System.out.println("Điểm TB: ");
        gpa = input.nextDouble();

        var foundNode = listStudents.getNode(new Student(id));
        if (foundNode != null) {
            var data = foundNode.getData();
            data.setEmail(email);
            data.setGpa(gpa);
            listStudents.updateNodeData(foundNode, data);
            System.out.println("Cập nhật thành công.");
            listStudents.TraversalFromHead();
        } else {
            System.out.println("Không tồn tại sinh viên cần tìm trong danh sách.");
        }
    }

    private static void fillDemoData(DoublyLinkedList<Student> listStudent) {
        listStudent.insertTail(new Student("B25DCCN100", "Hoàng Trọng Tuyên", "Hà Nội", "tuyen@xmail.com", 22, 3.26f));
        listStudent.insertTail(new Student("B25DCCN102", "Lê Văn Tuấn", "Hà Nội", "tuan@xmail.com", 22, 3.65f));
        listStudent.insertTail(new Student("B25DCCN108", "Ngô Bá Nam", "Hà Nội", "nam@xmail.com", 22, 2.35f));
        listStudent.insertTail(new Student("B25DCCN101", "Trần Đức Bưởi", "Hà Nội", "buoi@xmail.com", 22, 3.68f));
        listStudent.insertTail(new Student("B25DCCN106", "Đặng Tiến Lâm", "Hà Nội", "lamhaha@xmail.com", 22, 3.27f));
        listStudent.insertTail(new Student("B25DCCN105", "Khúc Thừa Dụ", "Hà Nội", "daicadu@xmail.com", 22, 3.06f));
    }
}
