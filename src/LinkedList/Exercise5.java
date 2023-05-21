package LinkedList;

/**
 * Bài 1. Xóa một node khỏi danh sách liên kết đơn có các phần tử kiểu String. Phương thức xóa trả
 * về true nếu xóa thành công và false nếu xóa thất bại.
 */

public class Exercise5 {
    public static void main(String[] args) {
        SinglyLinkedList<String> list = new SinglyLinkedList<String>();

        list.insertHead("Minh");
        list.insertHead("Nam");
        list.insertHead("Kaito");
        list.insertHead("Kaito1");
        list.insertHead("Kaito2");
        list.insertHead("Kaito3");

        //Xoa node
        boolean result = list.removeNode("Kaito4");
        if (result) {
            System.out.println("Xoá thành công! Danh sách mới là: ");
            list.showList();
        } else {
            System.out.println("Xoá thất bại !");
        }
    }
}
