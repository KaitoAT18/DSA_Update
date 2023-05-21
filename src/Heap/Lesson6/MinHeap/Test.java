package Heap.Lesson6.MinHeap;

public class Test {
    public static void main(String[] args) {
        PriorityQueue<String> queue = new PriorityQueue<>(10);

        queue.add("Kaito", 10);
        queue.add("Linh", 1);
        queue.add("Nam", 6);

        System.out.println("List: ");
        queue.showElements();
        queue.add("A", 2);
        queue.add("B", -2);
        queue.add("Buồi", -1);
        System.out.println("List 1: ");
        queue.showElements();

        System.out.println(queue.peek().getValue());
        System.out.println(queue.pop().getValue());
        queue.showElements();
        System.out.println("Size: " + queue.size());
        System.out.println("Empty?: " + queue.isEmpty());
        System.out.println("Full?: " + queue.isFull());
    }
}
