package Stack.Array;

import java.lang.reflect.Array;

public class Stack<T> {
    private int size;           //số phần tử thực tế có trong stack
    private int capacity;       //số phần tử tối đa có thể chứa trong stack
    private T[] data;           //mảng dùng để lưu các phần tử trong stack

    public Stack() {
        size = 0;
        capacity = 10;
        data = (T[]) Array.newInstance(Object.class, capacity);
    }

    public Stack(Class<T> t) {
        size = 0;
        capacity = 10;
        data = (T[]) Array.newInstance(t, capacity);
    }

    public Stack(Class<T> t, int capacity) {
        size = 0;
        this.capacity = capacity;
        data = (T[]) Array.newInstance(t, capacity);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public T[] getData() {
        return data;
    }

    public void setData(T[] data) {
        this.data = data;
    }

    public boolean isEmpty() {          //Kiểm tra stack có rỗng không
        return size == 0;
    }

    public boolean isFull() {           //Kiểm tra stack có đầy hay không
        return size == capacity;
    }

    public void push(T t) {             //Thêm phần tử ở đầu
        if (!isFull()) {
            data[size++] = t;
        } else {
            System.out.println("Stack đã đầy. Không thể thêm mới phần tử.");
        }
    }

    public void pop() {                //Xoá phần tử ở đầu
        if (!isEmpty()) {
            data[size--] = null;
        } else {
            System.out.println("Stack rỗng.");
        }
    }

    public T peek() {                   //Lấy phần tử ở đầu stack
        if (!isEmpty()) {
            return data[size-1];
        }
        return null;
    }
}
