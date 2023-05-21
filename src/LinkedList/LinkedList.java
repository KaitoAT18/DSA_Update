package LinkedList;

import java.util.Comparator;

public class LinkedList {
    //Khởi tạo DSLK đơn
    private Node<Student> head;
    private Node<Student> tail;
    static class Node<Student> {
        private Student data;
        private Node<Student> next;

        public Node (Student data) {
            this.data = data;
            this.next = null;
        }

        public Student getData() {
            return data;
        }
    }

    //Kiểm tra DSLK
    public boolean isEmty() {
        return head == null;
    }

    //Chèn vào đầu danh sách liên kết
    public void insertHead(Student data) {
        Node<Student> p = new Node<Student>(data);

        if (isEmty()) {
            head = tail = p;
        } else {
            p.next = head;
            head = p;
        }
    }

    //Chèn vào cuối danh sách liên kết
    public void insertTail(Student data) {
        Node<Student> p = new Node<Student>(data);

        if (isEmty()) {
            head = tail = p;
        } else {
            tail.next = p;
            tail = p;
        }
    }

    //Chèn vào sau node X
    public void insertAfterX(Student data, Student x) {
        Node<Student> p = new Node<>(data);
        Node<Student> nodeX = head;

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

    //Chèn vào trước node X
    public void insertBeforeX(Student data, Student x) {
        if (isEmty()) return;
        if (head.data == x) {
            insertHead(data);
        } else {
            Node<Student> nodeX = head;
            Node<Student> nodeBeforeX = head;

            while (nodeX != null) {
                if (nodeX.data == x) {
                    break;
                }
                nodeBeforeX = nodeX;
                nodeX = nodeX.next;
            }

            if (nodeX != null) {        //Tìm được nodeX
                Node<Student> p = new Node<>(data);
                p.next = nodeX;
                nodeBeforeX.next = p;
            } else {
                System.out.println("Không tìm thấy node có giá trị bằng " + x);
            }
        }
    }

    //Tìm node giữa của DSLK
    private Node<Student> findMidNode() {
        Node<Student> currentNode = head;
        Node<Student> midNode = head;

        while (currentNode != null && currentNode.next != null && currentNode.next.next != null) {
            currentNode = currentNode.next.next;
            midNode = midNode.next;
        }
        return midNode;
    }

    //Tìm node chính giữa DSLK
    public Student findMidNodeData() {
        Node<Student> midNode = findMidNode();
        return midNode == null ? null : midNode.data;
    }

    //Thêm node vào sau node giữa DSLK
    public void insertAfterMidNode(Student data) {
        Node<Student> midNode = findMidNode();
        Node<Student> p = new Node<>(data);
        p.next = midNode.next;      //cập nhập next của p
        midNode.next = p;           //cập nhập next của node giữa
    }

    //Chèn node sau node có vị trí k
    public void insertAfterK(Student data, int k) {
        if (isEmty()) {
            System.out.println("Danh sách liên kết rỗng !");
        } else if (k > 0) {
            int count = 1;
            Node<Student> node = head;
            while (node != null) {
                if (count == k) {
                    break;
                }
                count++;
                node = node.next;
            }
            if (node != null) {         //Tìm thấy node thứ k
                Node<Student> p = new Node<>(data);
                p.next = node.next;
                node.next = p;
            } else {
                System.out.println("Không tìm thấy node thứ " + k);
            }
        } else {
            System.out.println("Giá trị vị trí k = " + k + " không hợp lệ");
        }
    }

    //Hiển thị
    public void showList() {
        for (var node = head; node != null; node = node.next) {
            System.out.print(node.data + " -> ");
        }
        System.out.println("null");
    }

    /**
     * Phương thức xóa một node khỏi danh sách liên kết đơn.
     *
     * data: dữ liệu của node cần xóa
     * @return true nếu xóa thành công và false nếu ngược lại
     */
    private boolean removeSwitcher(Node<Student> x, Node<Student> prevX) {
        if (x != null) {
            if (x == head) {
                head = x.next;
                x.next = null;
            } else if (x == tail) {
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

    public boolean removeNode(Student data) {
        Node<Student> x = head;
        Node<Student> prevX = head;

        while (x != null) {
            if (x.data.equals(data)) {
                break;
            }
            prevX = x;
            x = x.next;
        }
        return removeSwitcher(x, prevX);
    }

    public boolean removeStudentByName(String name) {
        Node<Student> x = head;
        Node<Student> prevX = head;

        while (x != null) {
            if (x.data.getFullName().equals(name)) {
                break;
            }
            prevX = x;
            x = x.next;
        }
        return removeSwitcher(x, prevX);
    }

    // xóa sinh viên có điểm < gpa
    public boolean removeStudentByGPA(double gpa) {
        Node<Student> x = head;
        Node<Student> prevX = head;
        while (x != null) {
            if (x.data.getGpa() < gpa) {
                break;
            }
            prevX = x;
            x = x.next;
        }
        return removeSwitcher(x, prevX);
    }

    // xóa sinh viên có tuổi bằng x
    public boolean removeStudentByAge(int age) {
        Node<Student> x = head;
        Node<Student> prevX = head;
        while (x != null) {
            if (x.data.getAge() == age) {
                break;
            }
            prevX = x;
            x = x.next;
        }
        return removeSwitcher(x, prevX);
    }

    /**
     * Phương thức sắp xếp danh sách liên kết theo thứ tự tăng dần.
     */
    public void sortList(Comparator<Student> comparator) {
        Node<Student> current = head;
        Node<Student> index = null;
        while (current != null) {
            index = current.next;
            while (index != null) {
                if (comparator.compare(current.data, index.data) > 0) {
                    Student tmp = current.data;
                    current.data = index.data;
                    index.data = tmp;
                }
                index = index.next;
            }
            current = current.next;
        }
    }
}
