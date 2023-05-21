package Heap.Lesson7;

import java.util.Scanner;

public class Exercise1 {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();

        System.out.println("Nhập số bộ test: ");
        int t = input.nextInt();
        input.nextLine();

        int i = 1;
        while (t > 0) {
            System.out.println("Nhập số phần tử của mảng: ");
            int n = input.nextInt();
            Integer[] arr = createArr(n);
            System.out.println();
            System.out.println("Bộ test " + i++ + ": ");
            System.out.println("Mảng trước khi sắp xếp: ");
            heapSort.showElements(arr);
            heapSort.heapSortASC(arr);
            System.out.println("Mảng sau khi sắp xếp tăng dần: ");
            heapSort.showElements(arr);
            System.out.println();
            t--;
        }
    }

    private static Integer[] createArr(int n) {
        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            System.out.print("arr[" + i + "] = ");
            arr[i] = input.nextInt();
        }
        return arr;
    }
}
