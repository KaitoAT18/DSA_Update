package Heap.Lesson3;

import java.lang.reflect.Array;

public class MinHeap<E extends Comparable<E>> {
    private int currentSize;
    private final int MAX_SIZE;
    private E[] data;

    public MinHeap(Class<E> dataType, int size) {
        MAX_SIZE = size;
        currentSize = 0;
        data = (E[]) Array.newInstance(dataType, MAX_SIZE);
    }


    public boolean add(E e) {
        currentSize++;
        if (currentSize <= MAX_SIZE) {
            data[currentSize - 1] = e;
            siftUp(currentSize - 1);
            return true;
        } else {
            return false;
        }
    }

    private void siftUp(int index) {
        int parentIndex = (index - 1) / 2;
        if (data[index].compareTo(data[parentIndex]) < 0) {
            E tmp = data[index];
            data[index] = data[parentIndex];
            data[parentIndex] = tmp;
            siftUp(parentIndex);
        }
    }

    public boolean remove(E e) {
        if (!isEmpty()) {
            var index = findNode(e);
            if (index >= 0) {       // nếu tìm thấy node có giá trị e
                data[index] = data[currentSize-1];      // gán giá trị node cần xoá bằng giá trị node cuối
                data[currentSize-1] = null;             // xoá node cuối
                currentSize--;                          // giảm kích thước mảng đi 1
                siftDown(index);                        // sàng lại để cần bằng heap
                return true;
            }
        } else {
            System.out.println("Heap rỗng.");
        }
        return false;
    }

    private void siftDown(int index) {
        var smallest = index;
        var left = 2*index + 1;
        var right = 2*index + 2;

        if (left < currentSize && data[smallest].compareTo(data[left]) > 0) {
            smallest = left;
        }
        if (right < currentSize && data[smallest].compareTo(data[right]) > 0) {
            smallest = right;
        }
        if (smallest != index) {
            E tmp = data[index];
            data[index] = data[smallest];
            data[smallest] = tmp;
            siftDown(smallest);
        }
    }

    private int findNode(E e) {
        for (int i = 0; i < currentSize; i++) {
            if (data[i].compareTo(e) == 0) {
                return i;
            }
        }
        return -1;
    }

    private boolean isEmpty() {
        return currentSize == 0;
    }

    public E minElement() {
        return data[0];
    }

    public int size() {
        return currentSize;
    }

    public void showElements() {
        if (!isEmpty()) {
            for (int i = 0; i < currentSize; i++) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println("Heap rỗng.");
        }
    }
}
