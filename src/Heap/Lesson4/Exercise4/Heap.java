package Heap.Lesson4.Exercise4;

public class Heap<E extends Student> {
     private int currentSize;
     private final int MAX_SIZE;
     private Student[] data;

     public Heap(int size) {
         MAX_SIZE = size;
         currentSize = 0;
         data = new Student[MAX_SIZE];
     }

    public boolean add(E e) {
        currentSize++;
        if (currentSize <= MAX_SIZE) {
            data[currentSize - 1] = e;
            siftUp(currentSize - 1);
            return true;
        }
        return false;
    }

    private void siftUp(int index) {
        int parentIndex = (index - 1) / 2;
        if (data[parentIndex].compareTo(data[index]) > 0) {
            Student tmp = data[index];
            data[index] = data[parentIndex];
            data[parentIndex] = tmp;
            siftUp(parentIndex);
        }
    }

    public boolean remove(E e) {
        if (!isEmpty()) {
            int index = findNode(e);
            if (index >= 0) {
                data[index] = data[currentSize - 1];
                data[currentSize - 1] = null;
                currentSize--;
                siftDown(index);
                return true;
            }
        } else {
            System.out.println("Heap rỗng.");
        }
        return false;
    }

    private void siftDown(int index) {
        int smallest = index;
        int left = 2*index + 1;
        int right = 2*index + 2;

        if (left < currentSize && data[smallest].compareTo(data[left]) > 0) {
            smallest = left;
        }
        if (right < currentSize && data[smallest].compareTo(data[right]) > 0) {
            smallest = right;
        }
        if (smallest != index) {
            Student tmp = data[index];
            data[index] = data[smallest];
            data[smallest] = tmp;
            siftDown(smallest);
        }
    }

    public int findNode(E e) {
        for (int i = 0; i < currentSize; i++) {
            if (data[i].compareTo(e) == 0) return i;
        }
        return -1;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean update(E oldNode, E newNode) {
        var index = findNode(oldNode);
        if (index >= 0) {
            data[index] = newNode;
            var parentIndex = (index - 1) / 2;
            if (data[index].compareTo(data[parentIndex]) < 0) {
                siftUp(index);
            } else {
                siftDown(index);
            }
            return true;
        }
        return false;
    }

    public void showElements() {
        if (!isEmpty()) {
            for (int i = 0; i < currentSize; i++) {
                System.out.println(data[i].toString());
            }
            System.out.println();
        } else {
            System.out.println("Heap rỗng.");
        }
    }

    public int size() {
        return currentSize;
    }

    public Student minElement() {
        return data[0];
    }
}
