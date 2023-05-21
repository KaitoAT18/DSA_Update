package Queue.LinkedList;

public class Queue<E> {
    private LinkedList<E> data;
    private int countElement;

    public Queue() {
        data = new LinkedList<>();
        countElement = 0;
    }

    public void enqueue(E e) {
        countElement++;
        data.add(e);
    }

    public E dequeue() {
        if (!isEmpty()) {
            countElement--;
        }
        return data.remove();
    }

    public boolean isEmpty() {
        return countElement == 0;
    }

    public E peek() {
        return data.front();
    }

    public int size() {
        return countElement;
    }
}
