package hw3;

import java.io.IOException;
import java.util.NoSuchElementException;

public class Deque {
    // ДЗ  Задание № 2
    private int capacity;
    public int[] deque;
    private int head;
    private int headSecond;
    private int items;

    public Deque(int capacity) {
        this.capacity = capacity;
        this.deque = new int[capacity];
        this.head = -1;
        this.headSecond = capacity;
        this.items = 0;
    }

    public boolean isEmpty() {
        return (this.head == -1) & (this.headSecond == capacity);
    }

    public boolean isFull() {
        return this.head == this.headSecond - 1;
    }

    public int size() {
        return items;
    }

    public void push(int value) {
        if (isFull()) {
            capacity *= 2;
            int[] newDeque = new int[capacity];
            System.arraycopy(deque, 0, newDeque, 0, head + 1);
            System.arraycopy(deque, headSecond, newDeque, deque.length + headSecond, deque.length - headSecond);
            headSecond = deque.length + headSecond;
            deque = newDeque;
        }
        if (items % 2 == 0) {
            deque[++head] = value;
            items++;
        } else {
            deque[--headSecond] = value;
            items++;
        }
    }

    public int pop() {
        if (isEmpty()) throw new NoSuchElementException("Empty");
        if (!(items % 2 == 0)) {
            items--;
            return deque[head--];
        } else {
            items--;
            return deque[headSecond++];
        }
    }

    public int peek() {
        if (!(items % 2 == 0)) {
            items--;
            return deque[head];
        } else {
            items--;
            return deque[headSecond];
        }
    }
    public static void main ( String [] args ) throws IOException {
        Deque q = new Deque ( 5 );
        q.push ( 30 );
        q.push( 50 );
        q.push ( 10 );
        q.push( 40 );
        q.push( 20 );
        while ( ! q . isEmpty () )
        {
            int item = q .peek();
            System . out . print ( item + " " );
        }
        System . out . println ( "" );
    }
}