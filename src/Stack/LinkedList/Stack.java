package Stack.LinkedList;

public class Stack<T> {
    private LinkedList<T> data;
    private int counter;


    public Stack() {
        data = new LinkedList<>();
        counter = 0;
    }

    public boolean isEmpty() {
        return counter == 0;
    }

    public int size() {
        return counter;
    }

    public void push(T e) {
        counter++;
        data.add(e);
    }

    public T pop() {
        if (!isEmpty()) {
            counter--;
            return data.remove();
        }
        return null;
    }

    public T peek() {
        return data.front();
    }
}
