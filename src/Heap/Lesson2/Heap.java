package Heap.Lesson2;

import java.lang.reflect.Array;

/**
 * Min Heap
 *
 * @param <E> kiểu dữ liệu của heap
 */
public class Heap<E extends Comparable<E>> {
    private int currentSize;
    private final int MAX_SIZE;
    private E[] data;

    public Heap(Class<E> dataType, int size) {
        MAX_SIZE = size;
        currentSize = 0;
        data = (E[]) Array.newInstance(dataType, MAX_SIZE);
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public int getMAX_SIZE() {
        return MAX_SIZE;
    }

    public boolean add(E e) {
        currentSize++;
        if (currentSize <= MAX_SIZE) {
            data[currentSize-1] = e;
            siftUp(currentSize-1);
            return true;
        } else {
            return false;
        }
    }

    private void siftUp(int index) {
        var parentIndex = (index - 1) / 2;
        if (data[index].compareTo(data[parentIndex]) < 0) {
            E tmp = data[index];
            data[index] = data[parentIndex];
            data[parentIndex] = tmp;
            siftUp(parentIndex);
        }
    }

    public void showElements() {
        for (int i = 0; i < currentSize; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public E minElement() {
        return data[0];
    }
}
