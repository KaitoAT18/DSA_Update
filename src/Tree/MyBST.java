package Tree;

public class MyBST<T extends Comparable<T>>{
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

    public MyBST() {
        root = null;
    }

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

    public void ascending() {
        ascending(root);
    }

    private void ascending(Node<T> r) {
        if (r != null) {
            ascending(r.leftNode);
            System.out.print(r.data + " ");
            ascending(r.rightNode);
        }
    }

    public void descending() {
        descending(root);
    }

    private void descending(Node<T> r) {
        if (r != null) {
            descending(r.rightNode);
            System.out.print(r.data + " ");
            descending(r.leftNode);
        }
    }

    public void LRN() {
        LRN(root);
    }

    private void LRN(Node<T> r) {
        if (r != null) {
            LRN(r.leftNode);
            LRN(r.rightNode);
            System.out.print(r.data + " ");
        }
    }

    public void RLN() {
        RLN(root);
    }

    private void RLN(Node<T> r) {
        if (r != null) {
            RLN(r.rightNode);
            RLN(r.leftNode);
            System.out.print(r.data + " ");
        }
    }

    public void NLR() {
        NLR(root);
    }

    private void NLR(Node<T> r) {
        if (r != null) {
            System.out.print(r.data + " ");
            NLR(r.leftNode);
            NLR(r.rightNode);
        }
    }

    public void NRL() {
        NRL(root);
    }

    private void NRL(Node<T> r) {
        if (r != null) {
            System.out.print(r.data + " ");
            NRL(r.rightNode);
            NRL(r.leftNode);
        }
    }
}
