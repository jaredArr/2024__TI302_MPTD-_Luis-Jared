package tarea2;

/**
 * @author 
 */

public class DoubleLinkedList<E> {

    private static class Node<E> {

        private E elemento;
        private Node<E> prev;
        private Node<E> next;

        public Node(E elemento, Node<E> prev, Node<E> next) {
            this.elemento = elemento;
            this.next = next;
            this.prev = prev;
        }

        public E getElement() {
            return elemento;
        }

        public Node<E> getNext() {
            return next;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
        public void setPrev(Node<E> prev) {
    this.prev = prev;
        }
    }
    
private Node<E> header;
private Node<E> trailer;
private int size;

    public DoubleLinkedList() {
    header = new Node<>(null, null, null);
    trailer = new Node<>(null, header, null);
    header.setNext(trailer);
    }

    public int size() {
    return size;
    }

    public boolean isEmpty() {
    return size == 0 ? true:false;

    }
    
    public E first(){
    if (isEmpty())
        return null;
    
    return header.getNext().getElement();
    }
    
    private void addBetwein(E e, Node<E> predecesor, Node<E> sucessor){
    Node<E> newest = new Node<>(e, predecesor, sucessor);
    predecesor.setNext(newest);
    sucessor.setPrev(newest);
    size++;
    }

    public void addFirst(E e){
    addBetwein( e, header, header.getNext()); 
    }
    
    public void addLast(E e){
    addBetwein(e,trailer.getPrev(),trailer);
    }
    
    private E Remove(Node<E> node){
        Node<E> predecesor = node.getPrev();
        Node<E> sucessor = node.getNext();
        node.setNext(null);
        node.setPrev(null);
        predecesor.setNext(sucessor);
        sucessor.setPrev(predecesor);
        size--;
        return node.getElement();
    }
    public E removeFirst(){
        if(isEmpty()) return null;
        return Remove(header.getNext());
    }
    public E removeLast(){
        if(isEmpty()) return null;
        return Remove (trailer.getPrev());
    }

}

