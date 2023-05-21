package Heap.Lesson2;

public class PriorityQueue<E extends Comparable<E>> {
    private Node[] data;
    private final int MAX_SIZE;
    private int currentSize;
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

    public PriorityQueue(int size) {
        MAX_SIZE = size;
        currentSize = 0;
        data = new Node[MAX_SIZE];
    }

    public boolean add(E e, int priority) {
        if (!isFull()) {
            Node<E> node = new Node<>(e, priority);
            data[currentSize] = node;
            siftUp(currentSize);
            currentSize++;
            return true;
        } else {
            System.out.println("Queue rỗng!");
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

    private boolean isFull() {
        return currentSize == MAX_SIZE;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public int size() {
        return currentSize;
    }

    private void siftDown(int index) {
        var largest = index;
        var left = 2 * index + 1;
        var right = 2 * index + 2;
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

    public Node<E> peek() {
        if (isEmpty()) {
            return null;
        } else {
            return data[0];
        }
    }

    public Node<E> pop() {
        if (!isEmpty()) {
            Node<E> removedNode = data[0];
            data[0] = data[currentSize - 1];
            data[currentSize - 1] = null;
            currentSize--;
            siftDown(0);
            return removedNode;
        } else {
            return null;
        }
    }

    public void showElements() {
        for (int i = 0; i < currentSize; i++) {
            System.out.println(data[i].getValue() + "(" + data[i].getPriority() + ") ");
        }
        System.out.println();
    }
}
