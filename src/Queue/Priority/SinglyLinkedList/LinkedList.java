package Queue.Priority.SinglyLinkedList;

public class LinkedList<E> {
    private Node<E> head;

    static class Node<E> {
        private E data;
        private int priority;
        private Node<E> next;

        public Node(E data, int priority) {
            this.data = data;
            this.priority = priority;
            this.next = null;
        }
    }

    public void add(E e, int priority) {
        Node<E> p = new Node<>(e, priority);
        if (isEmpty()) {
            head = p;
        } else if (p.priority > head.priority) {
            p.next = head;
            head = p;
        } else {
            var r = head;
            for (var q = head.next; q != null; q = q.next) {
                if (q.priority < p.priority) {
                    break;
                }
                r = q;
            }
            p.next = r.next;
            r.next = p;
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
}
