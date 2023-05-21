package LinkedList;

public class Exercise12 {
    public static void main(String[] args) {
        DoublyLinkedList<Double> list = new DoublyLinkedList<Double>();

        list.insertTail(3.25);
        list.insertTail(25.31);
        list.insertTail(13.25);
        list.insertTail(26.41);
        list.insertTail(6.47);
        list.insertTail(17.58);
        list.insertTail(1.42);
        // hiển thị
        System.out.println("Danh sách trước khi sắp xếp: ");
        list.TraversalFromHead();
        // sắp xếp tăng dần
        System.out.println("Danh sách sau khi sắp xếp tăng dần: ");
        list.sortAscendingList();
        list.TraversalFromHead();
        // sắp xếp giảm dần
        System.out.println("Danh sách sau khi sắp xếp giảm dần: ");
        list.sortDescendingList();
        list.TraversalFromHead();
    }
}
