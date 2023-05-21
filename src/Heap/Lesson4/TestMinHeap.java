package Heap.Lesson4;

public class TestMinHeap {
    public static void main(String[] args) {
        MinHeap<Integer> heap = new MinHeap<>(Integer.class, 20);

        heap.add(1);
        heap.add(3);
        heap.add(6);
        heap.add(-10);
        heap.add(31);
        heap.add(100);
        heap.add(0);
        heap.add(20);

        System.out.println("Danh sách: ");
        heap.showElements();
        heap.remove(6);
        System.out.println("Danh sách sau 1: ");
        heap.showElements();
        heap.update(-10, 111);
        System.out.println("Danh sách sau 2: ");
        heap.showElements();
        System.out.println("Size: " + heap.size());
        System.out.println("Min Element: " + heap.minElement());
    }
}
