package LinkedList;

public class SinglyLinkedList<T extends Comparable<T>> {
    //Khởi tạo DSLK đơn
    private Node<T> head;
    private Node<T> tail;

    static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    //Chèn vào đầu
    public void insertHead(T data) {
        Node<T> p = new Node<>(data);
        if (head == null) {
            head = tail = p;
        } else {
            p.next = head;
            head = p;
        }
    }

    //Chèn vào cuối
    public void insertTail(T data) {
        Node<T> p = new Node<>(data);
        if (head == null) {
            head = tail = p;
        } else {
            tail.next = p;
            tail = p;
        }
    }

    //Chèn 1 node vào sau
    public void insertAfterX(T data, T x) {
        Node<T> p = new Node<>(data);
        Node<T> nodeX = head;

        while (nodeX != null) {
            if (nodeX.data == x) {
                break;
            }
            nodeX = nodeX.next;
        }

        if (nodeX != null) {
            p.next = nodeX.next;
            nodeX.next = p;
        } else {
            System.out.println("Không tìm thấy node mục tiêu.");
        }
    }

    //Hiển thị
    public void showList() {
        for (var node = head; node != null; node = node.next) {
            System.out.print(node.data + " -> ");
        }
        System.out.println("null");
    }

    //Cập nhập dữ liệu cho 1 node
    public boolean updateNodeData(Node target, T newData) {
        //Tìm node cần cập nhập
        for (var node = head; node != null; node = node.next) {
            if (node.data.equals(target.data)) {
                node.data = newData;        // Cập nhập dữ liệu mới cho node vừa tìm được
                return true;
            }
        }
        return false;
    }

    //Cập nhập dữ liệu cho tất cả các node có giá trị x, thành y
    public int updateFullNodeData(Node target, T newData) {
        int count = 0;          //Số lượng node được cập nhập
        //Tìm node cần cập nhập
        for (var node = head; node != null; node = node.next) {
            if (node.data.equals(target.data)) {
                node.data = newData;        // Cập nhập dữ liệu mới cho node vừa tìm được
                count++;
            }
        }
        return count;
    }

    //Tìm node
    public Node<T> getNode(T data) {
        for (var node = head; node != null; node = node.next) {
            if (node.data.equals(data)) {
                return node;
            }
        }
        return null;
    }

    //Xoá node
    public boolean removeNode(T data) {
        Node<T> x = head;
        Node<T> prevX = head;

        while (x != null) {
            if (x.data.equals(data)) {
                break;
            }
            prevX = x;
            x = x.next;
        }

        if (x != null) {
            //x là node head
            if (x == head) {
                head = x.next;
                x.next = null;
            } else if (x == tail) {         //x là node tail
                prevX.next = x.next;
                tail = prevX;
            } else {
                prevX.next = x.next;
                x.next = null;
            }
            return true;
        } else {
            return false;
        }
    }

    // Sắp xếp danh sách liên kết
    public void sortAscendingList() {
        Node<T> current = head;
        Node<T> index = null;

        while (current != null) {
            index = current.next;
            while (index != null) {
                if (current.data.compareTo(index.data) > 0) {
                    T tmp = current.data;
                    current.data = index.data;
                    index.data = tmp;
                }
                index = index.next;
            }
            current = current.next;
        }
    }

    public void sortDescendingList() {
        Node<T> current = head;
        Node<T> index = null;

        while (current != null) {
            index = current.next;
            while (index != null) {
                if (current.data.compareTo(index.data) < 0) {
                    T tmp = current.data;
                    current.data = index.data;
                    index.data = tmp;
                }
                index = index.next;
            }
            current = current.next;
        }
    }
}
