package Heap.Lesson3;

public class TestMinHeap {
    public static void main(String[] args) {
        MinHeap<Integer> heap = new MinHeap<>(Integer.class, 100);

       heap.add(1);
       heap.add(3);
       heap.add(5);
       heap.add(7);
       heap.add(9);
       heap.add(10);
       heap.add(11);
       heap.add(55);

        System.out.println("Các phần tử trong heap: ");
        heap.showElements();
        heap.add(-10);
        heap.showElements();
        System.out.println("Size: " + heap.size());
        System.out.println("Min element: " + heap.minElement());
        heap.remove(3);
        heap.showElements();
    }
}
