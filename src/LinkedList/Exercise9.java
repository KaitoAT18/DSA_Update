package LinkedList;

import java.util.Scanner;

public class Exercise9 {
    /**
     * Bài 2. Xóa tất cả các node có giá trị x khỏi danh sách liên kết đôi có các phần tử kiểu long. Hãy
     * cho biết có bao nhiêu phần tử đã bị xóa.
     * @param args
     */
    public static void main(String[] args) {
        DoublyLinkedList<Long> list = new DoublyLinkedList<Long>();

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

        System.out.println("Nhập dữ liệu cần xoá: ");
        Long data = new Scanner(System.in).nextLong();
        System.out.println("Số node xoá được: " + removeNode(list, data));
    }

    private static int removeNode(DoublyLinkedList<Long> list, Long data) {
        int count = 0;          //Đếm số node đã xoá được

        var result = list.removeNode(data);
        while (result) {
            result = list.removeNode(data);
            count++;
        }
        return count;
    }
}
