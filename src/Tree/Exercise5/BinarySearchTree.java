package Tree.Exercise5;

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

    /**
     * Phương thức đếm số node cành của cây
     * Node cành là node có ít nhất một cây con trái hoặc phải
     *
     * @return số node cành
     */
    public int countBranchNodes() {
        return countBranchNodes(root);
    }

    private int countBranchNodes(Node<T> r) {
        if (r == null) {
            return 0;
        }
        if (r.leftNode == null && r.rightNode == null) {
            return 0;
        }
        return 1 + countBranchNodes(r.leftNode) + countBranchNodes(r.rightNode);
    }

    // Liệt kê các node cành, node cành có thể có 1 hoặc 2 cây con
    public void listBranchNodes() {
        listBranchNodes(root);
    }

    private void listBranchNodes(Node<T> r) {
        if (r != null) {
            listBranchNodes(r.leftNode);
            if (!(r.leftNode == null && r.rightNode == null)) {
                System.out.println(r.data);
            }
            listBranchNodes(r.rightNode);
        }
    }

    /**
     * Phương thức đếm số node cành có 2 cây con
     * Node cành có 2 cây con là node có cả hai cây con trái và phải
     *
     * @return số node cành có 2 cây con
     */
    public int countTwoSubtreeNodes() {
        return countTwoSubtreeNodes(root);
    }

    private int countTwoSubtreeNodes(Node<T> r) {
        if (r == null) {
            return 0;   // cây rỗng
        }
        if (r.leftNode != null && r.rightNode != null) {
            return 1 + countTwoSubtreeNodes(r.leftNode) + countTwoSubtreeNodes(r.rightNode);
        } else {
            return countTwoSubtreeNodes(r.leftNode) + countTwoSubtreeNodes(r.rightNode);
        }
    }

    // Liệt kê các node cành có 2 cây con
    public void listNodeHava2Children() {
        listNodeHava2Children(root);
    }

    private void listNodeHava2Children(Node<T> r) {
        if (r != null) {
            listNodeHava2Children(r.leftNode);
            if (r.leftNode != null && r.rightNode != null) {
                System.out.println(r.data);
            }
            listNodeHava2Children(r.rightNode);
        }
    }

    /**
     * Phương thức tìm độ sâu của node giá trị x
     * Độ sâu của một node là số cạnh từ gốc đến node x
     *
     * @param x giá trị của node cần tìm độ sâu
     * @return độ sâu tìm được
     */
    public int deepOfX(T x) {
        return levelOfNode(x);
    }

    /**
     * Phương thức tìm độ cao của cây. Các bước thực hiện:
     * - Tìm độ cao của cây con trái
     * - Tìm độ cao của cây con phải
     * - Lấy độ cao lớn nhất trong hai kết quả trên + 1
     * Đệ quy các bước trên. Điểm dừng: đến khi node đang xét == null.
     *
     * @return độ cao của cây
     */
    public int height() {
        return height(root);
    }

    private int height(Node<T> r) {
        // Nếu cây rỗng hoặc node lá, chiều cao của r sẽ = 0
        if (r == null || (r.leftNode == null && r.rightNode == null)) {
            return 0;
        } else {
            var leftHeight = height(r.leftNode);
            var rightHeight = height(r.rightNode);
            return 1 + Math.max(leftHeight, rightHeight);
        }
    }

    /**
     * Phương thức tìm bậc của node x
     * - Node root có bậc là 0, các node khác: bậc của node bằng số đường nối từ gốc đến node đó.
     *
     * @param x giá trị của node cần tìm bậc
     * @return bậc của node có giá trị x
     */
    public int levelOfNode(T x) {
        return levelOfNode(root, x, 0);
    }

    private int levelOfNode(Node<T> r, T x, int level) {
        if (r == null) {
            return 0;
        }
        if (r.data.compareTo(x) == 0) {
            return level;
        }
        if (r.data.compareTo(x) > 0) {
            return levelOfNode(r.leftNode, x, level + 1);
        } else {
            return levelOfNode(r.rightNode, x, level + 1);
        }
    }

    // Liệt kê các node chỉ có 1 cây con trái hoặc phải
    public void listNodeHaveOnly1Child() {
        listNodeHaveOnly1Child(root);
    }

    private void listNodeHaveOnly1Child(Node<T> r) {
        if (r != null) {
            listNodeHaveOnly1Child(r.leftNode);
            if ((r.leftNode == null && r.rightNode != null) || (r.leftNode != null && r.rightNode == null)) {
                System.out.println(r.data);
            }
            listNodeHaveOnly1Child(r.rightNode);
        }
    }

    // Liệt kê các node chỉ có cây con trái
    public void listNodeHaveOnlyLeftChild() {
        listNodeHaveOnlyLeftChild(root);
    }

    private void listNodeHaveOnlyLeftChild(Node<T> r) {
        if (r != null) {
            listNodeHaveOnlyLeftChild(r.leftNode);
            if (r.leftNode != null && r.rightNode == null) {
                System.out.println(r.data);
            }
            listNodeHaveOnlyLeftChild(r.rightNode);
        }
    }

    // Liệt kê các node chỉ có cây con phải
    public void listNodeHaveOnlyRightChild() {
        listNodeHaveOnlyRightChild(root);
    }

    private void listNodeHaveOnlyRightChild(Node<T> r) {
        if (r != null) {
            listNodeHaveOnlyRightChild(r.leftNode);
            if (r.leftNode == null && r.rightNode != null) {
                System.out.println(r.data);
            }
            listNodeHaveOnlyRightChild(r.rightNode);
        }
    }

    // Thêm node vào cây
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

    // pre-order
    public void preOrder() {
        preOrder(root);
        System.out.println();
    }

    private void preOrder(Node<T> r) {
        if (r != null) {
            System.out.print(r.data + " ");
            preOrder(r.leftNode);
            preOrder(r.rightNode);
        }
    }

    // in-order
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

    // post-order
    public void postOrder() {
        postOrder(root);
        System.out.println();
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
    public int countNodes() {
        return countNodes(root);
    }

    private int countNodes(Node<T> r) {
        if (r == null) {
            return 0;
        }
        return 1 + countNodes(r.leftNode) + countNodes(r.rightNode);
    }

    // Đếm số lượng node lá của cây BST
    public int countLeafNodes() {
        return countLeafNodes(root);
    }

    private int countLeafNodes(Node<T> r) {
        if (r == null) {
            return 0;
        }
        if (r.leftNode == null && r.rightNode == null) {
            return 1;
        }
        return countLeafNodes(r.leftNode) + countLeafNodes(r.rightNode);
    }

    // liệt kê các node lá
    public void listLeafNodes() {
        showLeafNodes(root);
    }

    private void showLeafNodes(Node<T> r) {
        if (r != null) {
            showLeafNodes(r.leftNode);
            if (r.leftNode == null && r.rightNode == null) {
                System.out.println(r.data);
            }
            showLeafNodes(r.rightNode);
        }
    }
}
