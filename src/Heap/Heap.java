package Heap;

import java.lang.reflect.Array;

public class Heap<E extends Comparable<E>> {
    private E[] data;
    private final int MAX_SIZE;
    private int currentSize;

    public Heap(Class<E> dataType, int size) {
        MAX_SIZE = size;
        currentSize = 0;
        data = (E[]) Array.newInstance(dataType, MAX_SIZE);
    }

    public int getCurrentSize() {
        return currentSize;
    }

    // Thêm phân tử vào heap
    public boolean add(E e) {
        currentSize++;
        if (currentSize <= MAX_SIZE) {
            data[currentSize-1] = e;
            siftUp(currentSize-1);
            return true;    // thêm thành công
        } else {
            return false;  // thêm thất bại
        }
    }

    /**
     * Sàng lên để cân bằng heap
     *
     * @param index vị trí phần tử cần sàng
     */
    private void siftUp(int index) {
        var parentIndex = (index - 1) / 2;
        if (data[index].compareTo(data[parentIndex]) > 0) {
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

    public E maxElement() {
        return data[0];
    }

    // Xoá phần tử trong heap
    public boolean remove(E e) {
        var index = findNode(e);
        if (index >= 0) {
            data[index] = data[currentSize - 1];
            data[currentSize - 1] = null;
            currentSize--;
            siftDown(index);
            return true;        // xoá thành công
        } else {
            return false;       // xoá thất bại
        }
    }

    private void siftDown(int index) {
        var largest = index;
        var left = 2*index + 1;
        var right = 2*index + 2;
        if (left < currentSize && data[left].compareTo(data[largest]) > 0) {
            largest = left;
        }
        if (right < currentSize && data[right].compareTo(data[largest]) > 0) {
            largest = right;
        }
        if (largest != index) {
            E tmp = data[index];
            data[index] = data[largest];
            data[largest] = tmp;
            siftDown(largest);
        }
    }

    public boolean update (E oldNode, E newNode) {
        var index = findNode(oldNode);              // tìm vị trí node cần update
        if (index >= 0) {       // nếu tìm thấy
            data[index] = newNode;      // update node đó
            var parentIndex = (index - 1) / 2;      // tìm vị trí của node cha
            if (data[parentIndex].compareTo(data[index]) < 0) {     // nếu cha < con (index) thì sàng lên
                siftUp(index);
            } else {        // ngược lại, vun xuống
                siftDown(index);
            }
            return true;        // cập nhập thành công
        }
        return false;           // cập nhập thất bại
    }

    private int findNode(E e) {
        for (int i = 0; i < currentSize; i++) {
            if (data[i].compareTo(e) == 0) {
                return i;
            }
        }
        return -1;          // không tìm thấy node có giá trị e trong heap
    }
}
