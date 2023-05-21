package LinkedList;

public class Exercise11 {
    public static void main(String[] args) {
        SinglyLinkedList<String> list = new SinglyLinkedList<String>();

        list.insertTail("A");
        list.insertTail("B");
        list.insertTail("C");
        list.insertTail("D");
        list.insertTail("E");
        list.insertTail("F");
        list.insertTail("G");
        list.insertTail("H");
        list.insertTail("Z");
        list.insertTail("A");
        list.insertTail("D");
        list.insertTail("B");
        list.insertTail("I");
        list.insertTail("N");
        list.insertTail("M");

        System.out.println("Danh sách ban đầu: ");
        list.showList();
        System.out.println("Danh sách sau khi sắp xếp từ A->Z: ");
        list.sortAscendingList();
        list.showList();
        System.out.println("Danh sách sau khi sắp xếp từ Z->A: ");
        list.sortDescendingList();
        list.showList();
    }
}
