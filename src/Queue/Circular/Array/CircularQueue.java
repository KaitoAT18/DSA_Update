package Queue.Circular.Array;

import java.util.ArrayList;

public class CircularQueue<E> {
    private int headIndex;      // chỉ số phần tử đầu hàng đợi
    private int tailIndex;      // chỉ số phần tử cuối hàng đợi
    private int capacity;       // số phần tử tối đa có thể chứa trong hàng đợi
    private int currentElement; // số lượng phần ử hiện có trong hàng đợi
    private ArrayList<E> data;  // lưu các phần tử của hàng đợi vòng


    public CircularQueue(int capacity) {
        this.capacity = capacity;
        headIndex = -1;
        tailIndex = -1;
        currentElement = 0;
        data = new ArrayList<>();
    }

    public boolean isFull() {       // Kiểm tra xem hàng đợi đầy chưa
        return currentElement == capacity;
    }

    public boolean isEmpty() {     // Kiểm tra xem hàng đợi có rỗng không
        return currentElement == 0;
    }

    public int size() {             // Trả về số phần tử hiện có trong hàng đợi
        return currentElement;
    }

    public boolean enqueue(E e) {
        if (isFull()) {
            System.out.println("Hàng đợi đầy.");
            return false;       // Thêm thất bại
        } else {
            currentElement++;
            if (headIndex == -1) {
                headIndex++;
            }
            tailIndex = (tailIndex + 1) % capacity;
            if (data.size() == capacity) {
                data.set(tailIndex, e);
            } else {
                data.add(e);
            }
            return true;
        }
    }

    public E dequeue() {
        if (isEmpty()) {
            System.out.println("Queue rỗng.");
            return null;
        } else {
            E front = data.get(headIndex);
            currentElement--;
            if (headIndex == tailIndex) {
                headIndex = tailIndex = -1;
            } else {
                headIndex = (headIndex + 1) % capacity;
            }
            return front;
        }
    }

    public E peek() {
        return isEmpty() ? null : data.get(headIndex);
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue rỗng.");
        } else {
            System.out.println("Phần tử head: " + data.get(headIndex));
            System.out.println("Thứ tự các phần tử trong queue: ");
            for (int i = headIndex; i != tailIndex; i = (i+1) % capacity) {
                System.out.println(data.get(i) + " ");
            }
            System.out.println(data.get(tailIndex));
            System.out.println("Phần tử tail: " + data.get(tailIndex));
        }
    }
}


