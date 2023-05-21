package Heap.Lesson7;

import java.util.Scanner;

public class Exercise5 {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int t = input.nextInt();
        input.nextLine();

        while (t > 0) {
            int n = input.nextInt();
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextInt();
            }
            heapSort.heapSortByStep(arr);
            t--;
        }
    }
}
