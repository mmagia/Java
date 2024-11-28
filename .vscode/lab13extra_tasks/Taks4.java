import java.util.EmptyStackException;

public class Taks4 {
    public static void main(String[] args) {
        try {
            Stack<String> stack = new Stack<>();
            stack.push("hello");
            stack.push("hello");
            System.out.println(stack.pop());
        } catch (EmptyStackException ex) {
            System.out.println("No elements in stack!");
        }
    }
}

class Stack<T> {
    private T[] buffer;
    private int size = 0;

    private static final int DEFAUT_CAPACITY = 16;
    private static final int CAPACITY_MULT = 2;

    public Stack() {
        buffer = (T[]) new Object[DEFAUT_CAPACITY];
    }

    public Stack(int capacity) {
        buffer = (T[]) new Object[capacity];
    }

    public void push(T element) {
        if (size == buffer.length) {
            enlargeBuffer();
        }
        buffer[size] = element;
        size++;
    }

    public T pop() throws EmptyStackException {
        if (size == 0) {
            throw new EmptyStackException();
        }
        size--;
        return buffer[size];
    }

    public void listStack() {
        for (int i = 0; i < size; i++) {
            System.out.println(buffer[i]);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void enlargeBuffer() {
        T[] tmpArray = (T[]) new Object[buffer.length * CAPACITY_MULT];
        for (int i = 0; i < size; i++) {
            tmpArray[i] = buffer[i];
        }
        buffer = tmpArray;
    }
}
