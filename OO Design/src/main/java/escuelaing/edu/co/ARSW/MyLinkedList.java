package escuelaing.edu.co.ARSW;

import java.util.AbstractList;
import java.util.Objects;

public class MyLinkedList<E> extends AbstractList<E> {

    private static final class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;
        Node(Node<E> prev, E item, Node<E> next) {
            this.prev = prev; this.item = item; this.next = next;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(E e) { // añade al final
        linkLast(e);
        return true;
    }

    @Override
    public void add(int index, E element) {
        checkPositionIndex(index);
        if (index == size) {
            linkLast(element);
        } else {
            linkBefore(element, node(index));
        }
    }

    @Override
    public E get(int index) {
        checkElementIndex(index);
        return node(index).item;
    }

    @Override
    public E set(int index, E element) {
        checkElementIndex(index);
        Node<E> n = node(index);
        E old = n.item;
        n.item = element;
        return old;
    }

    @Override
    public E remove(int index) {
        checkElementIndex(index);
        return unlink(node(index));
    }

    @Override
    public boolean remove(Object o) {
        for (Node<E> x = head; x != null; x = x.next) {
            if (Objects.equals(o, x.item)) {
                unlink(x);
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        for (Node<E> x = head; x != null; ) {
            Node<E> next = x.next;
            x.item = null; x.next = null; x.prev = null;
            x = next;
        }
        head = tail = null;
        size = 0;
    }

    // --------- helpers internos ---------
    private void linkLast(E e) {
        Node<E> l = tail;
        Node<E> newNode = new Node<>(l, e, null);
        tail = newNode;
        if (l == null) head = newNode; else l.next = newNode;
        size++;
    }

    private void linkBefore(E e, Node<E> succ) {
        Node<E> pred = succ.prev;
        Node<E> newNode = new Node<>(pred, e, succ);
        succ.prev = newNode;
        if (pred == null) head = newNode; else pred.next = newNode;
        size++;
    }

    private E unlink(Node<E> x) {
        E element = x.item;
        Node<E> next = x.next;
        Node<E> prev = x.prev;

        if (prev == null) head = next; else prev.next = next;
        if (next == null) tail = prev; else next.prev = prev;

        x.item = null; x.next = null; x.prev = null;
        size--;
        return element;
    }

    private Node<E> node(int index) {
        // recorre por el lado más corto
        if (index < (size >>> 1)) {
            Node<E> x = head;
            for (int i = 0; i < index; i++) x = x.next;
            return x;
        } else {
            Node<E> x = tail;
            for (int i = size - 1; i > index; i--) x = x.prev;
            return x;
        }
    }

    private void checkElementIndex(int index) {
        if (!(index >= 0 && index < size))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private void checkPositionIndex(int index) {
        if (!(index >= 0 && index <= size))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }
}
