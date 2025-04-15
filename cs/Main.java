import java.util.EmptyStackException;

public class Main {
    public static void main(String args[]) {
        int size = 10;
        Queue<Integer> queue = new Queue<>();
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < size; i++) {
            queue.offer(i);
            stack.push(i);
        }
        System.out.println("QUEUE");
        for (int i = 0; i < size; i++) {
            System.out.print(queue.poll() + " ");
        }
        System.out.println("\nSTACK");
        for (int i = 0; i < size; i++) {
            System.out.print(stack.pop() + " ");
        }
    }
}

class Queue<T> {
    private class Node {
        T value;
        Node next;

        Node(T value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node front;
    private Node rear;
    private int size = 0;

    public Queue() {
        front = rear = null;
    }

    public void offer(T item) {
        Node newNode = new Node(item);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public T poll() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        T value = front.value;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return value;
    }

    public T peek() {
        if (size == 0) {
            throw new RuntimeException("Queue is empty");
        }
        return front.value;
    }
}

class Stack<T> {
    private int top = 0;
    private Object[] value;

    Stack() {
        this(10);
    }

    Stack(int size) {
        value = new Object[size];
    }

    public void push(T a) {
        int len = value.length;
        if (top > len - 1) {
            Object[] newValue = new Object[len * 2];
            for (int i = 0; i < len; i++) {
                newValue[i] = value[i];
            }
            value = newValue;
        }
        value[top++] = a;
    }

    public T pop() {
        if (top <= 0) {
            throw new EmptyStackException();
        }
        return (T) value[--top];
    }
}
