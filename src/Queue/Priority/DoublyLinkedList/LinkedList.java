package Queue.Priority.DoublyLinkedList;

import java.util.ArrayList;
import java.util.List;

public class LinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    static class Node<E> {
        private E data;
        private int priority;
        private Node<E> prev;
        private Node<E> next;

        public Node(E data, int priority) {
            this.data = data;
            this.priority = priority;
            this.next = null;
            this.prev = null;
        }
    }

    public void addTail(E e, int priority) {
        Node<E> p = new Node<>(e, priority);
        tail.next = p;
        p.prev = tail;
        tail = p;
    }

    public void add(E e, int priority) {
        Node<E> p = new Node<>(e, priority);
        if (isEmpty()) {
            head = tail = p;
        } else if (p.priority > head.priority) {
            p.next = head;
            head.prev = p;
            head = p;
        } else {
            var q = head;

            while (q != null) {
                if (q.priority < p.priority) {
                    break;
                }
                q = q.next;
            }
            if (q != null) {
                p.next = q;
                p.prev = q.prev;
                q.prev.next = p;
                q.prev = p;
            } else {
                addTail(e, priority);
            }
        }
    }

    public E remove() {
        if (!isEmpty()) {
            E tmp = head.data;
            head = head.next;
            return tmp;
        }
        return null;
    }

    public E front() {
        return isEmpty() ? null : head.data;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void minPriorityElements() {
        if (isEmpty()) {
            System.out.println("Queue rỗng.");
        } else {
            int minPriority = head.priority;
            for (var p = head; p != null; p = p.next) {
                if (p.priority < minPriority) {
                    minPriority = p.priority;
                }
            }
            for (var p = head; p != null; p = p.next) {
                if (p.priority == minPriority) {
                    System.out.println(p.data + " ");
                }
            }
            System.out.println();
        }
    }

    public List<E> toList() {
        List<E> list = new ArrayList<>();
        Node<E> p = head;
        while (p != null) {
            list.add(p.data);
            p = p.next;
        }
        return list;
    }
}
