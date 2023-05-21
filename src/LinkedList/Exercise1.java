package LinkedList;

public class Exercise1 {
    /**
     * Bài 1. Tạo một danh sách liên kết đơn generic lưu trữ các phần tử kiểu int. Cập nhật giá trị cho
     * node đầu tiên có giá trị x trong danh sách này bởi giá trị y nào đó. Phương thức cập nhật trả về
     * true nếu cập nhật thành công và false nếu cập nhật thất bại.
     */
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();

        // Thêm phần tử vào danh sách liên kết
        list.insertHead(1);
        list.insertHead(3);
        list.insertHead(5);
        list.insertHead(6);
        list.insertHead(36);
        list.insertHead(63);
        list.insertHead(56);

        // Cập nhập phần tử có data là "1" thành "36"
        int newData = 36;
        SinglyLinkedList.Node target = new SinglyLinkedList.Node(1);

        if (list.updateNodeData(target, newData)) {
            System.out.println("Cập nhập thành công !");
            list.showList();
        } else {
            System.out.println("Cập nhập thất bại !");
        }
    }
}
