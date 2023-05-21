package Heap.Lesson2;

public class Exercise3 {
    public static void main(String[] args) {
        Heap<Integer> heap = new Heap<>(Integer.class, 10);

        heap.add(1);
        heap.add(2);
        heap.add(3);
        heap.add(4);
        heap.add(5);
        heap.add(6);

        System.out.println("Các phần tử trong heap: ");
        heap.showElements();
        heap.add(-100);
        heap.add(-36);
        heap.showElements();
        System.out.println("Kích thước hiện tại: " + heap.getCurrentSize());
        System.out.println("Phần tử nhỏ nhất: " + heap.minElement());
    }
}
