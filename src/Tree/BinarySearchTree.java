package Tree;

public class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> root;
    static class Node<T> {
        private Node<T> leftNode;
        private Node<T> rightNode;
        private T data;

        public Node(T data) {
            this.data = data;
            leftNode = null;
            rightNode = null;
        }
    }

    public BinarySearchTree() {
        root = null;
    }

    // Thêm node sử dụng đệ quy
    public void add(T t) {
        root = insert(root, t);
    }

    private Node<T> insert(Node<T> r, T t) {
        if (r == null) {
            return new Node<>(t);
        } else if (r.data.compareTo(t) > 0) {
            r.leftNode = insert(r.leftNode, t);
        } else if (r.data.compareTo(t) < 0) {
            r.rightNode = insert(r.rightNode, t);
        }
        return r;
    }

    // Thêm node sử dụng vòng lặp
    public void addNewNodeUsingLoop(T t) {
        Node<T> newNode = new Node<>(t);
        if (root == null) {         // nếu cây rỗng
            root = newNode;
        } else {                    // nếu cây không rỗng
            Node<T> p = root;
            while (true) {
                if (p.data.compareTo(t) <= 0) {
                    if (p.rightNode != null) {      // nếu node mới nằm bên phải
                        p = p.rightNode;
                    } else {                        // tìm được vị trí của node mới
                        p.rightNode = newNode;      // gán node mới vào
                        break;                      // kết thúc
                    }
                } else {
                    if (p.leftNode != null) {
                        p = p.leftNode;
                    } else {
                        p.leftNode = newNode;
                        break;
                    }
                }
            }
        }
    }

    // Pre-order
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node<T> r) {
        if (r != null) {
            System.out.print(r.data + " ");
            preOrder(r.leftNode);
            preOrder(r.rightNode);
        }
    }

    // In-order
    private void inOrderRec(Node<T> r) {
        if (r != null) {
            inOrderRec(r.leftNode);
            System.out.print(r.data + " ");
            inOrderRec(r.rightNode);
        }
    }

    public void inOrder() {
        inOrderRec(root);
    }

    // Post-order
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node<T> r) {
        if (r != null) {
            postOrder(r.leftNode);
            postOrder(r.rightNode);
            System.out.print(r.data + " ");
        }
    }

    // Tìm kiếm node có giá trị x
    public boolean search(T x) {
        return search(root, x);
    }

    private boolean search(Node<T> r, T x) {
        if (r == null) {
            return false;
        }
        if (r.data.compareTo(x) == 0) {
            return true;
        } else if (r.data.compareTo(x) > 0) {
            return search(r.leftNode, x);
        } else if (r.data.compareTo(x) < 0) {
            return search(r.rightNode, x);
        }
        return false;
    }

    // Đếm tổng số node trong cây BST
    public int countNode() {
        return countNode(root);
    }

    private int countNode(Node<T> r) {
        if (r == null) {
            return 0;
        }
        return 1 + countNode(r.leftNode) + countNode(r.rightNode);
    }

    // Đếm số lượng node lá của cây BST
    public int countLeafNode() {
        return countLeafNode(root);
    }

    private int countLeafNode(Node<T> r) {
        if (r == null) {
            return 0;
        }
        if (r.leftNode == null && r.rightNode == null) {
            return 1;
        }
        return countLeafNode(r.leftNode) + countLeafNode(r.rightNode);
    }

    // Xoá node có giá trị bằng x
    public void remove(T x) {
        root = remove(root, x);
    }

    private Node<T> remove(Node<T> r, T x) {
        if (r == null) {
            return null;
        }
        if (x.compareTo(r.data) < 0) {
            r.leftNode = remove(r.leftNode, x);
        } else if (x.compareTo(r.data) > 0) {
            r.rightNode = remove(r.rightNode, x);
        } else {
            if (r.leftNode == null) {
                r = r.rightNode;
            } else if (r.rightNode == null) {
                r = r.leftNode;
            } else {
                r.data = findMinNode(r.rightNode, x);
                r.rightNode = remove(r.rightNode, r.data);
            }
        }
        return r;
    }

    private T findMinNode(Node<T> r, T x) {
        while (r.leftNode != null) {
            r = r.leftNode;
        }
        return r.data;
    }
}
