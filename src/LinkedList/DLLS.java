package LinkedList;

public class DLLS {
    private Node<Student> head;
    private Node<Student> tail;

    static class Node<Student> {
        private Student data;
        private Node<Student> next;
        private Node<Student> prev;

        public Node(Student data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

        public Student getData() {
            return data;
        }

        public void setData(Student data) {
            this.data = data;
        }
    }

    //Chèn vào đầu danh sách
    public void insertHead(Student data) {
        Node<Student> p = new Node<>(data);
        if (isEmpty()) {
            head = tail = p;
        } else {
            p.next = head;      //next của p là head cũ
            head.prev = p;      //prev của head cũ là p
            head = p;           //cập nhập head mới là p
        }
    }

    //Chèn vào cuối danh sách
    public void insertTail(Student data) {
        Node<Student> p = new Node<>(data);
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
    public void insertAfterX(Student data, Student x) {
        Node<Student> p = new Node<>(data);
        Node<Student> nodeX = head;

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
    public void insertBeforeX(Student data, Student x) {
        Node<Student> p = new Node<>(data);
        Node<Student> nodeX = head;

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
    public void insertAferK(Student data, int k) {
        Node<Student> p = new Node<Student>(data);

        if (isEmpty()) {
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
    public Node<Student> findMidNode() {
        Node<Student> currentNode = head;
        Node<Student> midNode = head;

        while (currentNode != null && currentNode.next != null && currentNode.next.next != null) {
            currentNode = currentNode.next.next;
            midNode = midNode.next;
        }
        return midNode;
    }

    //Tìm dữ liệu cho midNode (node giữa)
    public Student findDataMidNode() {
        Node<Student> midNode = findMidNode();
        return midNode == null ? null : midNode.data;
    }

    public void showMidNode() {
        Node<Student> midNode = findMidNode();
        midNode.data = findDataMidNode();
        System.out.println(midNode.data);
    }

    //Thêm node vào sau node giữa danh sách liên kết
    public void insertAfterMidNode(Student data) {
        Node<Student> midNode = findMidNode();
        Node<Student> p = new Node<Student>(data);

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
    public boolean updateNodeData(Node target, Student newData) {
        for (var node = head; node != null; node = node.next) {
            if (node.data.equals(target.data)) {
                node.data = newData;
                return true;
            }
        }
        return false;
    }

    //Tìm node
    public Node<Student> getNode(Student data) {
        for (var node = head; node != null; node = node.next) {
            if (node.data.equals(data)) {
                return node;
            }
        }
        return null;
    }

    //Xoá node
    public boolean removeNode(Student data) {
        Node<Student> x = head;
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

    private void remove(Node<Student> x) {
        Node<Student> prevX = x.prev;
        Node<Student> nextX = x.next;
        prevX.next = x.next;
        nextX.prev = x.prev;
        x.prev = null;
        x.next = null;
    }

    private void removeTail(Node<Student> x) {
        Node<Student> prevX = x.prev;
        prevX.next = null;
        tail = prevX;
        x.prev = null;
    }

    private void removeHead(Node<Student> x) {
        Node<Student> nextX = x.next;
        if (nextX != null) {
            nextX.prev = null;
        }
        head = nextX;
        x.next = null;
    }

    /**
     * Phương thức xóa một node khỏi danh sách liên kết đơn.
     *
     * data: dữ liệu của node cần xóa
     * @return true nếu xóa thành công và false nếu ngược lại
     */
    
    private boolean removeSwitcher(Node<Student> x) {
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

    public boolean removeStudentByName(String name) {
        Node<Student> x = head;
        
        while (x != null) {
            if (x.data.getFullName().equals(name)) {
                break;
            }
            x = x.next;
        }
        return removeSwitcher(x);
    }

    // xóa sinh viên có điểm < gpa
    public boolean removeStudentByGPA(double gpa) {
        Node<Student> x = head;

        while (x != null) {
            if (x.data.getGpa() < gpa) {
                break;
            }
            x = x.next;
        }
        return removeSwitcher(x);
    }

    // xóa sinh viên có tuổi bằng x
    public boolean removeStudentByAge(int age) {
        Node<Student> x = head;

        while (x != null) {
            if (x.data.getAge() == age) {
                break;
            }
            x = x.next;
        }
        return removeSwitcher(x);
    }
}
