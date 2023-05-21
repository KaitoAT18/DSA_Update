package Heap.Lesson6.MaxHeap;

/**
 * Class Priority Queue - Hàng đợi ưu tiên
 * Xây dựng dựa trên Max Heap
 *
 * @param <E> kiểu dữ liệu bất kỳ được truyền vào
 */
public class PriorityQueue<E extends Comparable<E>> {
    private Node[] data;
    private final int MAX_SIZE;
    private int currentSize;

    public PriorityQueue(int size) {
        MAX_SIZE = size;
        currentSize = 0;
        data = new Node[MAX_SIZE];
    }

    static class Node<E extends Comparable<E>> {
        private E value;
        private int priority;

        public Node(E e, int priority) {
            this.value = e;
            this.priority = priority;
        }

        public E getValue() {
            return value;
        }

        public int getPriority() {
            return priority;
        }
    }

    public boolean isFull() {
        return currentSize == MAX_SIZE;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public int size() {
        return currentSize;
    }

    public boolean add(E e, int priority) {
        if (!isFull()) {
            Node<E> node = new Node<>(e, priority);
            data[currentSize] = node;
            siftUp(currentSize);
            currentSize++;
            return true;
        } else {
            System.out.println("Queue đầy!");
            return false;
        }
    }
    private void siftUp(int index) {
        var parentIndex = (index - 1) / 2;
        if (data[index].getPriority() > data[parentIndex].getPriority()) {
            Node<E> tmp = data[index];
            data[index] = data[parentIndex];
            data[parentIndex] = tmp;
            siftUp(parentIndex);
        }
    }

    private void siftDown(int index) {
        var largest = index;
        var left = 2*index + 1;
        var right = 2*index + 2;

        if (left < currentSize && data[left].getPriority() > data[largest].getPriority()) {
            largest = left;
        }
        if (right < currentSize && data[right].getPriority() > data[largest].getPriority()) {
            largest = right;
        }
        if (largest != index) {
            Node<E> tmp = data[index];
            data[index] = data[largest];
            data[largest] = tmp;
            siftDown(largest);
        }
    }

    /**
     * Phương thức lấy phần tử ở đầu queue nhưng không xoá
     *
     * @return phần tử đầu hàng đợi
     */
    public Node<E> peek() {
        if (isEmpty()) {
            return null;
        } else {
            return data[0];
        }
    }


    /**
     * Phương thức lấy phần tử ở đầu queue nhưng xoá
     *
     * @return phần tử đầu hàng đợi
     */
    public Node<E> pop() {
        if (isEmpty()) {
            return null;
        } else {
            Node<E> temp = data[0];
            data[0] = data[currentSize-1];
            data[currentSize-1] = null;
            currentSize--;
            siftDown(0);
            return temp;
        }
    }

    /**
     * Phương thức tìm kiếm phần tử trong queue
     *
     * @return trả về chỉ số của phần tử nếu tìm thấy, ngược lại trả về -1
     */
    public int search(E e) {
        if (!isEmpty()) {
            for (int i = 0; i < currentSize; i++) {
                if (data[i].getValue().compareTo(e) == 0) return i;
            }
        }
        return -1;
    }

    /**
     * Phương thức hiển thị ra danh sách các phần tử có trong queue
     *
     */
    public void showElements() {
        if (!isEmpty()) {
            for (int i = 0; i < currentSize; i++) {
                System.out.println(data[i].getValue()+ "-" + "(" + data[i].getPriority() + ")");
            }
        } else {
            System.out.println("Queue rỗng.");
        }
    }

    public void getInfoElement(Node<E> e) {
        System.out.println("Dữ liệu: " + e.getValue());
        System.out.println("Độ ưu tiên: " + e.getPriority());
    }
}
