package LinkedList;

import java.util.Scanner;

public class Exercise8 {
    /**
     * Bài 1. Xóa một node khỏi danh sách liên kết đôi có các phần tử kiểu String. Phương thức xóa trả
     * về true nếu xóa thành công và false nếu xóa thất bại.
     * @param args
     */
    public static void main(String[] args) {
        DoublyLinkedList<String> list = new DoublyLinkedList<String>();

        list.insertTail("A");
        list.insertTail("B");
        list.insertTail("C");
        list.insertTail("D");
        list.insertTail("E");
        list.insertTail("F");
        list.insertTail("G");
        list.insertTail("H");

        System.out.println("Nhập dữ liệu cần xoá: ");
        String data = new Scanner(System.in).nextLine();
        var result = list.removeNode(data);

        if (result) {
            System.out.println("Xoá thành công! Danh sách sau khi xoá: ");
            list.TraversalFromHead();
        } else {
            System.out.println("Xoá thất bại!");
        }
    }
}
