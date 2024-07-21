import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements Iterable<T> {

    // private T value;
    // private Node next, prev;
    private class Node {
        T value;
        Node next;
        Node prev;

        // public Node();
        public Node() {
            this.value = null;
            this.next = this;
            this.prev = this;
        }

        // public Node(T value);
        public Node(T value) {
            this.value = value;
        }
    }

    private Node head;
    private int size;

    public LinkedList() {
        head = new Node();
        size = 0;
    }

    // public int size();
    public int size() {
        return size;
    }

   // public boolean isEmpty();
    public boolean isEmpty() {
        return size == 0;
    }

     // private Node getNode(int index); // O(index)
    private Node getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node current = head.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

     // public T get(int pos); // calls getNode
    public T get(int index) {
        return getNode(index).value;
    }

    //  public void set(int pos, T value); // calls getNode
    public void set(int index, T value) {
        getNode(index).value = value;
    }

    // private Node firstNode();
    private Node firstNode() {
        return head.next;
    }

    // private Node lastNode();
    private Node lastNode() {
        return head.prev;
    }

    // public T first(); // calls firstNode
    public T first() {
        if (isEmpty()) throw new NoSuchElementException("List is empty");
        return firstNode().value;
    }

    // public T last(); // calls lastNode
    public T last() {
        if (isEmpty()) throw new NoSuchElementException("List is empty");
        return lastNode().value;
    }

    //  private void insertNodeBefore(Node node, Node nextNode); // only change next/prev links
    private void insertNodeBefore(Node newNode, Node beforeNode) {
        newNode.next = beforeNode;
        newNode.prev = beforeNode.prev;
        beforeNode.prev.next = newNode;
        beforeNode.prev = newNode;
    }

    //  private void addValueBefore(T value, Node beforeNode); // calls insertNodeBefore; increase size here
    private void addValueBefore(T value, Node beforeNode) {
        Node newNode = new Node(value);
        insertNodeBefore(newNode, beforeNode);
        size++;
    }




    //  public void addLast(T value);
    public void addLast(T value) {
        addValueBefore(value, head);
    }

    // public void add(T value); // calls addLast
    public void add(T value) {
        addLast(value);
    }

    // public void addFirst(T value);
    public void addFirst(T value) {
        addValueBefore(value, head.next);
    }


    // public void add(int beforeIndex, T value);
    public void add(int index, T value) {
        addValueBefore(value, (index == size ? head : getNode(index)));
    }


    // private void removeNode(Node node); // only change prev/next links
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // private T removeValue(Node node); // calls removeNode; decrease size here; returns removed value
    private T removeValue(Node node) {
        if (node == head) throw new NoSuchElementException("Node does not exist");
        T value = node.value;
        removeNode(node);
        size--;
        return value;
    }

    // public T removeLast();
    public T removeLast() {
        if (isEmpty()) throw new NoSuchElementException("List is empty");
        return removeValue(lastNode());
    }

    // public T removeFirst();
    public T removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("List is empty");
        return removeValue(firstNode());
    }

    // public T remove(int index);
    public T remove(int index) {
        return removeValue(getNode(index));
    }

    @Override

    // public Iterator iterator() {
    //        return new Iterator(_head);
    //    }
    public Iterator<T> iterator() {
        return new IteratorImpl(head.next);
    }

    //  public class Iterator implements java.util.Iterator<T>
    public class IteratorImpl implements Iterator<T> {

        // private Node node;
        private Node current;
        private Node lastReturned;

        // private Iterator(Node node);
        private IteratorImpl(Node start) {
            current = start;
            lastReturned = null;
        }

        @Override
        //    public boolean hasNext(); // true if node.next != head
        public boolean hasNext() {
            return current != head;
        }

        @Override
        // public T next();
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            lastReturned = current;
            current = current.next;
            return lastReturned.value;
        }
    }
}
