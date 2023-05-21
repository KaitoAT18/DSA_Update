package Queue.Priority.SinglyLinkedList;

public class PriorityQueue<E> {
    private int currentSize;
    private LinkedList<E> data;

    public PriorityQueue() {
        currentSize = 0;
        data = new LinkedList<>();
    }

    public void add(E e, int priority) {
        currentSize++;
        data.add(e, priority);
    }

    public E peek() {
        return data.front();
    }

    public E remove() {
        if (!isEmpty()) {
            currentSize--;
        }
        return data.remove();
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public int size() {
        return currentSize;
    }
}
