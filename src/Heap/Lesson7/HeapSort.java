package Heap.Lesson7;

import java.util.Arrays;

public class HeapSort {
    public HeapSort() {
    }

    public <E extends Comparable<E>> void heapSortASC(E[] arr) {
        int n = arr.length;
        for (int i = n/2 - 1; i >= 0; i--) {
            siftDown(arr, n, i);
        }
        for (int i = n-1; i >= 0; i--) {
            E tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            siftDown(arr, i, 0);
        }
    }

    public <E extends Comparable<E>> void heapSortDESC(E[] arr) {
        int n = arr.length;
        for (int i = n/2 - 1; i >= 0; i--) {
            siftDownForDESC(arr, n, i);
        }
        for (int i = n-1; i >= 0; i--) {
            E tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            siftDownForDESC(arr, i, 0);
        }
    }

    public <E extends Comparable<E>> void heapSortByStep(E[] arr) {
        int n = arr.length;
        for (int i = n/2 - 1; i >= 0; i--) {
            siftDown(arr, n, i);
        }
        for (int i = n-1; i >= 0; i--) {
            E tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            System.out.println(Arrays.toString(arr));
            siftDown(arr, i, 0);
        }
    }

    private <E extends Comparable<E>> void siftDownForDESC(E[] data, int n, int index) {
        var smallest = index;
        var left = 2*index + 1;
        var right = 2*index + 2;

        if (left < n && data[left].compareTo(data[smallest]) < 0) {
            smallest = left;
        }
        if (right < n && data[right].compareTo(data[smallest]) < 0) {
            smallest = right;
        }
        if (smallest != index) {
            E tmp = data[index];
            data[index] = data[smallest];
            data[smallest] = tmp;
            siftDownForDESC(data, n, smallest);
        }
    }

    private <E extends Comparable<E>> void siftDown(E[] data, int n, int index) {
        var largest = index;
        var left = 2*index + 1;
        var right = 2*index + 2;

        if (left < n && data[left].compareTo(data[largest]) > 0) {
            largest = left;
        }
        if (right < n && data[right].compareTo(data[largest]) > 0) {
            largest = right;
        }
        if (largest != index) {
            E tmp = data[index];
            data[index] = data[largest];
            data[largest] = tmp;
            siftDown(data, n, largest);
        }
    }

    public <E> void showElements(E[] arr) {
        for (var e: arr) {
            System.out.print(e + " ");
        }
        System.out.println();
    }
}
