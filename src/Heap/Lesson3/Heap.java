package Heap.Lesson3;

import java.lang.reflect.Array;

public class Heap<E extends Comparable<E>> {
    private int currentSize;
    private final int MAX_SIZE;
    private E[] data;

    public Heap(Class<E> dataType, int size) {
        MAX_SIZE = size;
        currentSize = 0;
        data = (E[]) Array.newInstance(dataType, MAX_SIZE);
    }

    // Thêm mới một node vào heap
    public boolean add(E e) {
        currentSize++;
        if (currentSize <= MAX_SIZE) {
            data[currentSize-1] = e;
            siftUp(currentSize - 1);
            return true;
        } else {
            return false;
        }
    }

    // Sàng lên
    private void siftUp(int index) {
        int parentIndex = (index - 1) / 2;
        if (data[index].compareTo(data[parentIndex]) > 0) {
            E tmp = data[index];
            data[index] = data[parentIndex];
            data[parentIndex] = tmp;
            siftUp(parentIndex);
        }
    }

    // Xoá node có giá trị e khỏi heap
    public boolean remove(E e) {
        if (!isEmpty()) {
            var index = findNode(e);
            if (index >= 0) {
                data[index] = data[currentSize - 1];
                data[currentSize - 1] = null;
                currentSize--;
                siftDown(index);
                return true;
            }
        } else {
            System.out.println("Heap rỗng.");
        }
        return false;
    }

    private void siftDown(int index) {
        var largest = index;
        var left = 2*index + 1;
        var right = 2*index + 2;

        if (left < currentSize && data[index].compareTo(data[left]) < 0) {
            largest = left;
        }
        if (right < currentSize && data[index].compareTo(data[right]) < 0) {
            largest = right;
        }
        if (largest != index) {
            E tmp = data[largest];
            data[largest] = data[index];
            data[index] = tmp;
            siftUp(largest);
        }
    }

    public int findNode(E e) {
        for (int i = 0; i < currentSize; i++) {
            if (data[i].compareTo(e) == 0) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public E maxElement() {
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
