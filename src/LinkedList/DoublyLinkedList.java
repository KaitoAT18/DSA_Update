package LinkedList;


public class DoublyLinkedList<T extends Comparable<T>> {
    private Node<T> head;
    private Node<T> tail;

    static class Node<T> {
        private T data;
        private Node<T> next;
        private Node<T> prev;

        public Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }

    //Chèn vào đầu danh sách
    public void insertHead(T data) {
        Node<T> p = new Node<>(data);
        if (isEmpty()) {
            head = tail = p;
        } else {
            p.next = head;      //next của p là head cũ
            head.prev = p;      //prev của head cũ là p
            head = p;           //cập nhập head mới là p
        }
    }

    //Chèn vào cuối danh sách
    public void insertTail(T data) {
        Node<T> p = new Node<>(data);
        if (isEmpty()) {
            head = tail = p;
        } else {
            tail.next = p;     //next của tail cũ là p
            p.prev = tail;     //prev của p là tail cũ
            tail = p;          //cập nhập tail mới là p
        }
    }

    //Kiểm tra danh sách rỗng
    boolean isEmpty() {
        return head == null;
    }

    //Thêm 1 node mới vào sau nodeX của danh sách liên kết
    public void insertAfterX(T data, T x) {
        Node<T> p = new Node<>(data);
        Node<T> nodeX = head;

        if (isEmpty()) System.out.println("Danh sách liên kết rỗng !");

        while (nodeX != null) {
            if (nodeX.data == x) {
                break;
            }
            nodeX = nodeX.next;
        }

        if (nodeX != null && nodeX == tail) {
            insertTail(p.data);
        } else if (nodeX != null) {
            p.next = nodeX.next;
            p.prev = nodeX;
            nodeX.next.prev = p;
            nodeX.next = p;
        } else {
            System.out.println("Không tìm thấy node mục tiêu.");
        }
    }

    //Thêm 1 node mới vào trước nodeX của danh sách liên kết
    public void insertBeforeX(T data, T x) {
        Node<T> p = new Node<>(data);
        Node<T> nodeX = head;

        if (isEmpty()) System.out.println("Danh sách liên kết rỗng !");

        while (nodeX != null) {
            if (nodeX.data == x) {
                break;
            }
            nodeX = nodeX.next;
        }

        if (nodeX != null && nodeX == head) {
            insertHead(p.data);
        } else if (nodeX != null) {
            p.next = nodeX;
            p.prev = nodeX.prev;
            nodeX.prev.next = p;
            nodeX.prev = p;
        } else {
            System.out.println("Không tìm thấy node mục tiêu.");
        }
    }

    //Chèn node sau vị trí node thứ k
    public void insertAferK(T data, int k) {
        Node<T> p = new Node<T>(data);

        if (isEmpty()) {
            System.out.println("Danh sách liên kết rỗng !");
        } else if (k > 0) {
            int count = 1;
            Node<T> node = head;

            while (node != null) {
                if (count == k) {
                    break;
                }
                count++;
                node = node.next;
            }

            if (node != null && node.next == null) {
                insertTail(p.data);
            } else if (node != null) {
                p.next = node.next;
                node.next.prev = p;
                p.prev = node;
                node.next = p;
            } else {
                System.out.println("Không tìm thấy node thứ " + k);
            }
        } else {
            System.out.println("Giá trị vị trí k = " + k + " không hợp lệ");
        }
    }

    //Tìm node giữa của danh sách liên kết
    public Node<T> findMidNode() {
        Node<T> currentNode = head;
        Node<T> midNode = head;

        while (currentNode != null && currentNode.next != null && currentNode.next.next != null) {
            currentNode = currentNode.next.next;
            midNode = midNode.next;
        }
        return midNode;
    }

    //Tìm dữ liệu cho midNode (node giữa)
    public T findDataMidNode() {
        Node<T> midNode = findMidNode();
        return midNode == null ? null : midNode.data;
    }

    public void showMidNode() {
        Node<T> midNode = findMidNode();
        midNode.data = findDataMidNode();
        System.out.println(midNode.data);
    }

    //Thêm node vào sau node giữa danh sách liên kết
    public void insertAfterMidNode(T data) {
        Node<T> midNode = findMidNode();
        Node<T> p = new Node<T>(data);

        p.next = midNode.next;
        p.prev = midNode;
        midNode.next.prev = p;
        midNode.next = p;
    }

    //Hiển thị đầu -> cuối danh sách
    public void TraversalFromHead() {
        for (var node = head; node != null; node = node.next) {
            System.out.print(node.data + " -> ");
        }
        System.out.println("null");
    }

    //Hiển thị cuối -> đầu danh sách
    public void TraversalFromTail() {
        for (var node = tail; node != null; node = node.prev) {
            System.out.print(node.data + " -> ");
        }
        System.out.println("null");
    }

    //Cập nhập dữ liệu cho 1 node
    public boolean updateNodeData(Node target, T newData) {
        for (var node = head; node != null; node = node.next) {
            if (node.data.equals(target.data)) {
                node.data = newData;
                return true;
            }
        }
        return false;
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
        while (x != null) {
            if (x.data.equals(data)) {
                break;
            }
            x = x.next;
        }
        //Kiểm tra
        if (x == null) {
            return false;
        } else {
            if (x == head) {
                removeHead(x);
            } else if (x == tail) {
                removeTail(x);
            } else {
                remove(x);
            }
            return true;
        }
    }

    private void remove(Node<T> x) {
        Node<T> prevX = x.prev;
        Node<T> nextX = x.next;
        prevX.next = x.next;
        nextX.prev = x.prev;
        x.prev = null;
        x.next = null;
    }

    private void removeTail(Node<T> x) {
        Node<T> prevX = x.prev;
        prevX.next = null;
        tail = prevX;
        x.prev = null;
    }

    private void removeHead(Node<T> x) {
        Node<T> nextX = x.next;
        nextX.prev = null;
        head = nextX;
        x.next = null;
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
