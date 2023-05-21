package Tree.Exercise3;

public class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> root;
    static class Node<T> {
        private Node<T> leftNode;
        private Node<T> rightNode;
        private T data;

        public Node(T data) {
            this.leftNode = null;
            this.rightNode = null;
            this.data = data;
        }
    }

    public BinarySearchTree() {
        this.root = null;
    }

    // Thêm 1 node vào cây
    public void add(T e) {
        root = insert(root, e);
    }

    private Node<T> insert(Node<T> r, T e) {
        if (r == null) {
            return new Node<>(e);
        }
        if (r.data.compareTo(e) > 0) {
            r.leftNode = insert(r.leftNode, e);
        } else if (r.data.compareTo(e) < 0) {
            r.rightNode = insert(r.rightNode, e);
        }
        return r;
    }

    //Duyệt cây in-order
    public void inOrder() {
        inOrder(root);
        System.out.println();
    }

    private void inOrder(Node<T> r) {
        if (r != null) {
            inOrder(r.leftNode);
            System.out.print(r.data + " ");
            inOrder(r.rightNode);
        }
    }

    // Tìm kiếm node có giá trị x
    public boolean search(T x) {
        return searchByLoop(root, x);
    }

    // Recursion
    private boolean search(Node<T> r, T x) {
        if (r == null) return false;
        if (r.data.compareTo(x) == 0) {
            return true;
        } else if (r.data.compareTo(x) > 0) {
            return search(r.leftNode, x);
        } else if (r.data.compareTo(x) < 0) {
            return search(r.rightNode, x);
        }
        return false;
    }

    // Loop
    private boolean searchByLoop(Node<T> r, T x) {
        while (true) {
            if (r == null) return false;
            if (r.data.compareTo(x) == 0) {
                return true;
            } else if (r.data.compareTo(x) > 0) {
                r = r.leftNode;
            } else if (r.data.compareTo(x) < 0) {
                r = r.rightNode;
            }
        }
    }
}
