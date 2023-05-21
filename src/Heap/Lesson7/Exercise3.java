package Heap.Lesson7;

import java.util.Scanner;

public class Exercise3 {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int t = input.nextInt();
        input.nextLine();

        while (t > 0) {
            String str = input.nextLine();
            String[] arrStr = str.split("\\s+");
            heapSort.heapSortASC(arrStr);
            heapSort.showElements(arrStr);
            t--;
        }
    }
}
