package LinkedList;

public class Exercise2 {
    /**
     * Bài 2. Tạo danh sách liên kết đơn generic lưu trữ các String. Cập nhật tất cả các node có giá trị x
     * trong danh sách này bằng giá trị y nào đó. Sau khi cập nhật trả về số lượng node được cập nhật.
     */
    public static void main(String[] args) {
        SinglyLinkedList<String> list = new SinglyLinkedList<String>();

        //Thêm phần tử vào danh sách liên kết
        list.insertTail("Minh");
        list.insertTail("Nam");
        list.insertTail("Minh");
        list.insertTail("Minh");
        list.insertTail("Long");
        list.insertTail("Binh");
        list.insertTail("Minh");
        list.insertTail("Thang");

        //Cập nhập tất cả các node có data là "Minh" thành "Kien"
        var node = new SinglyLinkedList.Node("Minh");
        var newData = "Kien";

        int count = list.updateFullNodeData(node, newData);
        if (count > 0) {
            System.out.println("Update successful !");
            System.out.print("List: ");
            list.showList();
            System.out.println("Số node được cập nhập: " + count);
        } else {
            System.out.println("Updata Failed");
        }
    }
}
