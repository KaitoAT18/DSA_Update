package LinkedList;

/**
 * Bài 2. Xóa các node có giá trị x khỏi danh sách liên kết đơn có các phần tử kiểu long. Hãy cho biết
 * có bao nhiêu phần tử đã bị xóa.
 */
public class Exercise6 {
    public static void main(String[] args) {
        SinglyLinkedList<Long> list = new SinglyLinkedList<Long>();

        list.insertHead(111l);
        list.insertHead(111l);
        list.insertHead(111l);
        list.insertHead(111l);
        list.insertHead(12321l);
        list.insertHead(1231312l);
        list.insertHead(12313131231245156l);
        list.insertHead(12313131231245156l);
        list.insertHead(12313131231245156l);
        list.insertHead(12l);
        list.insertHead(12l);
        list.insertHead(12l);
        list.insertHead(1l);
        list.insertHead(1l);
        list.insertHead(1l);

        removeAllNodeDataX(list, 111l);
    }

    private static void removeAllNodeDataX(SinglyLinkedList<Long> list, Long key) {
        System.out.println("Dữ liệu trong node cần xóa: " + key);
        var numOfRemovedNode = 0;
        var result = list.removeNode(key);

        while (result) {
            numOfRemovedNode++;
            result = list.removeNode(key);
        }
        if (numOfRemovedNode != 0) { // xóa thành công
            System.out.println("Số phần tử đã bị xóa: " + numOfRemovedNode);
            System.out.println("Danh sách sau khi xóa: ");
            list.showList();
        } else {
            System.out.println("Xóa thất bại. Node cần xóa không tồn tại.");
        }
    }
}
