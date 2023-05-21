package Queue.Array;

import java.util.ArrayList;

public class Queue<E> {
    private int currentElement;         // số lượng phần tử hiện tại
    private ArrayList<E> data;          // lưu trữ các phần tử trong queue

    public Queue() {
        currentElement = 0;
        data = new ArrayList<>();
    }

    public void enqueue(E e) {          // thêm vào cuối queue
        data.add(e);
        currentElement++;
    }

    public E dequeue() {                // lấy phần tử ở đầu nhưng xoá
        if (!isEmpty()) {
            currentElement--;
            E e = data.get(0);
            data.remove(0);
            return e;
        }
        return null;
    }

    public boolean isEmpty() {
        return currentElement == 0;
    }

    public E peek() {                   // lấy phần tử ở đầu
        return isEmpty() ? null : data.get(0);
    }

    public int size() {
        return currentElement;
    }
}
