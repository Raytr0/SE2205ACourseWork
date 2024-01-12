package L4Q1;

import java.util.ArrayList;
public class DoublyLinkedList<E> {
    public static class Node<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;

        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setPrev(Node<E> p) {
            prev = p;
        }

        public void setNext(Node<E> n) {
            next = n;
        }
    }
    private Node<E> header; // header sentinel
    private Node<E> trailer; // trailer sentinel
    private int size = 0; // number of elements in the list
    public DoublyLinkedList() {
        header = new Node<>(null, null, null); // create header
        trailer = new Node<>(null, header, null); // trailer is preceded by
        header.setNext(trailer); // header is followed by
    }

    public int size() { return size; }

    public boolean isEmpty() { return size == 0; }

    public void addLast(E e) {
        addBetween(e, trailer.getPrev(), trailer); // place just before the
    }
    public void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        // create and link a new node
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }

    //Finds node that matches element and returns it, returns null if nothing
    public Node<E> findNode(E e){
        Node<E> current = header.getNext();
        while (current != trailer) {
            if (current.getElement().equals(e)) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    //Overrides toString to display all elements in ArrayList
    public String toString(){
        ArrayList<E> arrayList = new ArrayList<E>();
        Node<E> current = header.next;
        while(current != trailer){
            arrayList.add(current.element);
            current = current.next;
        }
        return arrayList.toString();
    }
}
