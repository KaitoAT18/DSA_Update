package Tree.Exercise4;

public class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> root;
    static class Node<T> {
        private Node<T> leftNode;
        private Node<T> rightNode;
        private T data;
        private int count;

        public Node(T data) {
            this.data = data;
            count = 1;
            leftNode = null;
            rightNode = null;
        }
    }

    public BinarySearchTree() {
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
        } else {
            r.count++;
        }
        return r;
    }

    public void showNode(int occ) {
        if (!findNode(root, occ)) {
            System.out.println("=> Không có kết quả.");
        } else {
            showNode(root, occ);
        }
    }

    private void showNode(Node<T> r, int occ) {
        if (r != null) {
            showNode(r.leftNode, occ);
            if (r.count == occ) {
                System.out.println(r.data + " - " + r.count);
            }
            showNode(r.rightNode, occ);
        }
    }

    private boolean findNode(Node<T> r, int occ) {
        if (r == null) {
            return false;
        } else {
            if (r.count == occ) {
                return true;
            } else {
                boolean resultLeft = findNode(r.leftNode, occ);
                boolean resultRight = findNode(r.rightNode, occ);
                return resultLeft || resultRight;
            }
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node<T> r) {
        if (r != null) {
            inOrder(r.leftNode);
            System.out.println(r.data + " - " + r.count);
            inOrder(r.rightNode);
        }
    }

    private int findMinOccurrence(Node<T> r) {
        if (r == null) {
            return 0;
        } else if (r.leftNode == null && r.rightNode == null) {
            return r.count;
        } else {
            int count = r.count;
            int countLeft = count;
            if (r.leftNode != null) {
                countLeft = findMinOccurrence(r.leftNode);
            }
            int countRight = count;
            if (r.rightNode != null) {
                countRight = findMinOccurrence(r.rightNode);
            }
            return Math.min(count, Math.min(countRight, countLeft));
        }
    }

    private void inOderMinOccurrence(Node<T> r, int min) {
        if (r != null) {
            inOderMinOccurrence(r.leftNode, min);
            if (r.count == min) {
                System.out.println(r.data + " - " + r.count);
            }
            inOderMinOccurrence(r.rightNode, min);
        }
    }

    private void inOrderMaxOccurrence(Node<T> r, int max) {
        if (r != null) {
            inOrderMaxOccurrence(r.leftNode, max);
            if (r.count == max) {
                System.out.println(r.data + " - " + r.count);
            }
            inOrderMaxOccurrence(r.rightNode, max);
        }
    }

    public void showMaxOccurence() {
        if (root != null) {
            int maxOcc = findMaxOccurrence(root);
            inOrderMaxOccurrence(root, maxOcc);
        }
    }

    public void showMinOccurence() {
        if (root != null) {
            int min = findMinOccurrence(root);
            inOderMinOccurrence(root, min);
        }
    }

    private int findMaxOccurrence(Node<T> r) {
        if (r == null) {
            return 0;
        } else if (r.leftNode == null && r.rightNode == null) {
            return r.count;
        } else {
            int count = r.count;
            int countLeft = count;
            if (r.leftNode != null) {
                countLeft = findMaxOccurrence(r.leftNode);
            }
            int countRight = count;
            if (r.rightNode != null) {
                countRight = findMaxOccurrence(r.rightNode);
            }
            return Math.max(count, Math.max(countRight, countLeft));
        }
    }
}
