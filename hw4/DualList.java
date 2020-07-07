package hw4;

import java.util.Objects;

public class DualList{
    protected class Node {
        Cat c;
        DualList.Node next;
        DualList.Node previous;

        public Node(Cat c) {
            this.c = c;
        }

        @Override
        public String toString() {
            return c.toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            DualList.Node node = (DualList.Node) o;
            return c.equals(node.c);
        }

        @Override
        public int hashCode() {
            return Objects.hash(c);
        }
    }

    protected DualList.Node head;
    protected DualList.Node tail;
    protected int size;

    public DualList() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void push(Cat c) {
        DualList.Node n = new DualList.Node(c);
        n.previous = tail;
        if (tail != null)
            tail.next = n;
        tail = n;
        if (head == null){
            n.next = head;
            head = n;
        }
        size++;
    }

    public Node pushHead(Cat c){
        DualList.Node n = new DualList.Node(c);
        if (this.isEmpty())
            tail = n;
        n.next = head;
        head=n;
        return n;
    }


    public Cat pop() {
        // Удаление из head
        if (isEmpty()) return null;
        Cat temp = head.c;
        head = head.next;
        size--;
        return temp;
    }

    @Override
    public String toString() {
        DualList.Node current = head;
        StringBuilder sb = new StringBuilder("[");
        while (current != null) {
            sb.append(current);
            current = current.next;
            sb.append((current == null) ? "]" : ", ");
        }
        return sb.toString();
    }

    public boolean contains(Cat c) {
        return find(c) != null;
    }

    private DualList.Node find(Cat c) {
        if (isEmpty()) return null;
        DualList.Node current = head;
        while (!current.c.equals(c)) {
            if (current.next == null)
                return null;
            else
                current = current.next;
        }
        return current;
    }

    public boolean delete(Cat c) {
        DualList.Node current = head;
        DualList.Node previous = head;
        while (!current.c.equals(c)) {
            if (current.next == null) {
                return false;
            } else {
                previous = current;
                current = current.next;
            }
        }
        if (current == head) {
            head = head.next;
        } else {
            previous.next = current.next;
        }
        return true;
    }
}