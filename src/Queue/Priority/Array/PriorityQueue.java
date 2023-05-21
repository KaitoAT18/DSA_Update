package Queue.Priority.Array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

public class PriorityQueue<E> {
    static class Data<E>{
        private int priority;
        private E data;

        public Data(E data, int priority) {
            this.priority = priority;
            this.data = data;
        }

        public int getPriority() {
            return priority;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Data<?> data)) return false;
            return priority == data.priority;
        }

        @Override
        public int hashCode() {
            return Objects.hash(priority);
        }
    }

    class Sorting implements Comparator<Data> {
        @Override
        public int compare(Data o1, Data o2) {
            return o2.priority - o1.getPriority();
        }
    }
    private int capacity;
    private int size;
    ArrayList<Data<E>> data;

    public PriorityQueue(int capacity) {
        this.capacity = 10;
        this.size = 0;
        this.data = new ArrayList<>();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public int getSize() {
        return size;
    }

    public void add(E e, int priority) {
        if (!isFull()) {
            size++;
            int index = -1;
            for (var elements: data) {
                if (elements.getPriority() < priority) {
                    index = data.indexOf(elements);
                    break;
                }
            }
            Data<E> addData = new Data<>(e, priority);
            if (index > 0) {
                data.add(index-1, addData);
            } else {
                data.add(0, addData);
            }
        } else {
            System.out.println("Hàng đợi đầy.");
        }
    }

    public E remove() {
        if (!isEmpty()) {
            size--;
            E tmp = data.get(0).data;
            data.remove(0);
            return tmp;
        } else {
            System.out.println("Hàng đợi rỗng.");
        }
        return null;
    }

    public E peek() {
        if (!isEmpty()) {
            return data.get(0).data;
        } else {
            System.out.println("Hàng đợi rỗng.");
        }
        return null;
    }

    public void minPriority() {
        if (!isEmpty()) {
            int minPriority = data.get(0).getPriority();
            for (var e: data) {
                if (e.getPriority() < minPriority) {
                    minPriority = e.getPriority();
                }
            }
            for (var e: data) {
                if (e.getPriority() == minPriority) {
                    System.out.print(e.data + " ");
                }
            }
        } else {
            System.out.println("Hàng đợi rỗng.");
        }
    }

    public void display() {
        // Sắp xếp theo thứ tự ưu tiên
        data.sort(new Sorting());
        for (var e: data) {
            System.out.print(e.data + " ");
        }
        System.out.println();
    }
}
