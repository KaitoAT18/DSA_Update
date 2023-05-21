package Heap;

public class Test {
    public static void main(String[] args) {
        Heap<String> heap = new Heap<String>(String.class, 100);
        heap.add("A");
        heap.add("B");
        heap.add("C");
        heap.add("D");
        heap.add("E");
        heap.add("G");
        heap.add("H");
        heap.add("K");
        System.out.println("Các phần tử trong heap: ");
        heap.showElements();
        heap.add("T");
        heap.add("I");
        heap.showElements();
        heap.update("G", "A");
        heap.showElements();
    }
}
