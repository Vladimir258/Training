package fominskiy;

public class LinkList<E> {

    protected int size;
    protected Node<E> firstElement;
    protected Node<E> lastElement;

    public boolean isEmpty() {
        return firstElement == null;
    }

    public void insert(E value, int index) {
        for (int i = 0; i < index; i++) {

        }
        Node<E> newNode = new Node<>(value, firstElement, null);
        if (isEmpty()) {
            lastElement = newNode;
        } else {
            firstElement.previous = newNode;
        }
        firstElement = newNode;
        size++;
    }

    public E removeHead() {
        if (isEmpty()) {
            throw new UnsupportedOperationException("LinkList is empty.");
        }

        Node<E> removedNode = firstElement;
        firstElement = removedNode.next;
        firstElement.previous = null;
        removedNode.next = null;
        size--;
        return removedNode.value;
    }

    public boolean remove(E value) {
        Node<E> current = firstElement;

        while (current != null) {
            if (current.value.equals(value)) {
                break;
            }

            current = current.next;
        }

        if (current == null) {
            return false;
        }

        if (size == 1) {
            removeHead();
            return true;
        }

        if (current == firstElement) {
            firstElement = firstElement.next;
            firstElement.previous = null;
        } else if (current == lastElement) {
            lastElement = current.previous;
            lastElement.next = null;
        } else {
            current.previous.next = current.next;
            current.next.previous = current.previous;
        }

        current.next = null;
        current.previous = null;
        current = null;
        size--;
        return true;
    }

    public E get(int index) {
        if (index < 0 || index+1 > size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> current = firstElement;
        for (int i = 1; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    class Node<E> {
        E value;
        Node<E> next;
        Node<E> previous;

        public Node(E value, Node<E> next, Node<E> previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }
    }
}
