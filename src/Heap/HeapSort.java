package Heap;

import java.util.Arrays;

public class HeapSort {
    // Thuật toán sắp xếp vun đống tăng dần
    public static <E extends Comparable<E>> void heapSort(E[] arr) {
        var n = arr.length;
        // Tạo max heap từ mảng đầu vào
        for (int i = n/2 - 1; i >= 0; i--) {
            siftDown(arr, n, i);            // Sàng xuống từ vị trí thứ i
        }
        // Đưa phần tử ở đầu heap về đúng vị trí
        for (int i = n-1; i >= 0; i--) {    // Tráo đổi phần tử đầu và cuối heap
            E tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            siftDown(arr, i, 0);     // Sàng xuống tái cân bằng heap mới
        }
    }

    private static <E extends Comparable<E>> void siftDown(E[] data, int n, int index) {
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

    public static <E> void showElements(E[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        Integer[] arr = {3,4,6,1,0,8,5,7,9,2};
        String[] names = {"Kaito", "A", "B", "F", "G", "C"};
        System.out.println("Mảng ban đầu: ");
        showElements(arr);
        heapSort(arr);
        System.out.println("Sau khi sắp xếp: ");
        showElements(arr);
    }
}
