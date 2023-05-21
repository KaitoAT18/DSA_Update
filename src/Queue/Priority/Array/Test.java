package Queue.Priority.Array;

import Queue.Priority.Array.PriorityQueue;

public class Test {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(10);
        queue.add(10,10);
        queue.add(9,9);
        queue.add(8,5);
        queue.add(7,6);
        queue.add(36,10);
        queue.add(71,2);
        queue.add(6,0);
        queue.add(161,1);
        queue.add(666,-1);

        System.out.println("Display: ");
        queue.display();
        System.out.println("Min: ");
        queue.minPriority();
        System.out.println("Size: " + queue.getSize());
        System.out.println("First Element: " + queue.remove());
        System.out.println("First Element: " + queue.peek());
        System.out.println("Display: ");
        queue.display();
        System.out.println("First Element: " + queue.remove());
        System.out.println("First Element: " + queue.remove());
        System.out.println("First Element: " + queue.remove());
    }
}
