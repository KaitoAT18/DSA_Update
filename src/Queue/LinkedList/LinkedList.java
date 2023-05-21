package Queue.LinkedList;

public class LinkedList<T> {
     private Node<T> head;
     private Node<T> tail;

     static class Node<T> {
         private T data;
         private Node<T> next;

         public Node(T data) {
             this.data = data;
             this.next = null;
         }
     }

     public void add(T e) {
         Node<T> p = new Node<>(e);
         if (isEmpty()) {
             head = tail = p;
         } else {
             tail.next = p;
             tail = p;
         }
     }

     public boolean isEmpty() {
         return head == null;
     }

     public T remove() {
         if (!isEmpty()) {
             T tmp = head.data;
             head = head.next;
             return tmp;
         }
         return null;
     }

     public T front() {
         return isEmpty() ? null : head.data;
     }
}
