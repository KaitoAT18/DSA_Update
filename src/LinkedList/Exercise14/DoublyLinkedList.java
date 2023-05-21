package LinkedList.Exercise14;

import java.text.SimpleDateFormat;
import java.util.Comparator;

public class DoublyLinkedList {
    private Node head;
    private Node tail;

    static class Node {
        private BankAccount data;
        private Node next;
        private Node prev;

        public Node(BankAccount data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

        public BankAccount getData() {
            return data;
        }

        public void setData(BankAccount data) {
            this.data = data;
        }
    }

    //Chèn vào đầu danh sách
    public void insertHead(BankAccount data) {
        Node p = new Node(data);
        if (isEmpty()) {
            head = tail = p;
        } else {
            p.next = head;      //next của p là head cũ
            head.prev = p;      //prev của head cũ là p
            head = p;           //cập nhập head mới là p
        }
    }

    //Chèn vào cuối danh sách
    public void insertTail(BankAccount data) {
        Node p = new Node(data);
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
    public void insertAfterX(BankAccount data, BankAccount x) {
        Node p = new Node(data);
        Node nodeX = head;

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
    public void insertBeforeX(BankAccount data, BankAccount x) {
        Node p = new Node(data);
        Node nodeX = head;

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
    public void insertAferK(BankAccount data, int k) {
        Node p = new Node(data);

        if (isEmpty()) {
            System.out.println("Danh sách liên kết rỗng !");
        } else if (k > 0) {
            int count = 1;
            Node node = head;

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
    public Node findMidNode() {
        Node currentNode = head;
        Node midNode = head;

        while (currentNode != null && currentNode.next != null && currentNode.next.next != null) {
            currentNode = currentNode.next.next;
            midNode = midNode.next;
        }
        return midNode;
    }

    //Tìm dữ liệu cho midNode (node giữa)
    public BankAccount findDataMidNode() {
        Node midNode = findMidNode();
        return midNode == null ? null : midNode.data;
    }

    public void showMidNode() {
        Node midNode = findMidNode();
        midNode.data = findDataMidNode();
        System.out.println(midNode.data);
    }

    //Thêm node vào sau node giữa danh sách liên kết
    public void insertAfterMidNode(BankAccount data) {
        Node midNode = findMidNode();
        Node p = new Node(data);

        p.next = midNode.next;
        p.prev = midNode;
        midNode.next.prev = p;
        midNode.next = p;
    }

    //Hiển thị đầu -> cuối danh sách
    public void TraversalFromHead() {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        for (Node node = head; node != null; node = node.next) {
            System.out.printf("%-25s%-20s%-20s%-15s%-20s%-15s%-15s%-20d\n",
                    node.data.getName(), node.data.getCardNumber(),
                    node.data.getAccountNumber(), node.data.getCardType(),
                    node.data.getIssuingBank(), format.format(node.data.getReleaseDate()),
                    format.format(node.data.getExpirationDate()), node.data.getBalance());

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
    public boolean updateNodeData(Node target, BankAccount newData) {
        for (var node = head; node != null; node = node.next) {
            if (node.data.equals(target.data)) {
                node.data = newData;
                return true;
            }
        }
        return false;
    }

    //Tìm node
    public Node getNode(BankAccount data) {
        for (var node = head; node != null; node = node.next) {
            if (node.data.equals(data)) {
                return node;
            }
        }
        return null;
    }

    //Xoá node
    public boolean removeNode(BankAccount data) {
        Node x = head;
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

    private void remove(Node x) {
        Node prevX = x.prev;
        Node nextX = x.next;
        prevX.next = x.next;
        nextX.prev = x.prev;
        x.prev = null;
        x.next = null;
    }

    private void removeTail(Node x) {
        Node prevX = x.prev;
        prevX.next = null;
        tail = prevX;
        x.prev = null;
    }

    private void removeHead(Node x) {
        Node nextX = x.next;
        nextX.prev = null;
        head = nextX;
        x.next = null;
    }

    // Sắp xếp
    public void sortList(Comparator comparator) {
        Node current = head;
        Node index = null;

        while (current != null) {
            index = current.next;
            while (index != null) {
                if (comparator.compare(current.data, index.data) > 0) {
                    BankAccount tmp = current.data;
                    current.data = index.data;
                    index.data = tmp;
                }
                index = index.next;
            }
            current = current.next;
        }
    }

    public void sortListDESC(Comparator comparator) {
        Node current = head;
        Node index = null;

        while (current != null) {
            index = current.next;
            while (index != null) {
                if (comparator.compare(current.data, index.data) < 0) {
                    BankAccount tmp = current.data;
                    current.data = index.data;
                    index.data = tmp;
                }
                index = index.next;
            }
            current = current.next;
        }
    }
}
