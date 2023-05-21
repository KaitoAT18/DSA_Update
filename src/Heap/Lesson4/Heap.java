package Heap.Lesson4;

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

    public boolean add(E e) {
        currentSize++;
        if (currentSize <= MAX_SIZE) {
            data[currentSize - 1] = e;
            siftUp(currentSize - 1);
            return true;
        }
        return false;
    }

    private void siftUp(int index) {
        int parentIndex = (index - 1) / 2;
        if (data[index].compareTo(data[parentIndex]) > 0) {
            E tmp = data[index];
            data[index] = data[parentIndex];
            data[parentIndex] = tmp;
            siftUp(parentIndex);
        }
    }

    public boolean remove(E e) {
        if (!isEmpty()) {
            int index = findNode(e);
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

        if (left < currentSize && data[largest].compareTo(data[left]) < 0) {
            largest = left;
        }
        if (right < currentSize && data[largest].compareTo(data[right]) < 0) {
            largest = right;
        }
        if (largest != index) {
            E tmp = data[largest];
            data[largest] = data[index];
            data[index] = tmp;
            siftDown(largest);
        }
    }

    public int findNode(E e) {
        if (!isEmpty()) {
            for (int i = 0; i < currentSize; i++) {
                if (data[i].compareTo(e) == 0) {
                    return i;
                }
            }
        }
        return -1;
    }

    private boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean update(E oldNode, E newNode) {
        var index = findNode(oldNode);
        if (index >= 0) {
            data[index] = newNode;
            var parentIndex = (index - 1) / 2;
            if (data[index].compareTo(data[parentIndex]) > 0) {
                siftUp(index);
            } else {
                siftDown(index);
            }
            return true;
        }
        return false;
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

    public int size() {
        return currentSize;
    }

    public E maxElement() {
        return data[0];
    }
}
