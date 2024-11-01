package tema2;

// Clase de lista enlazada simple
class SinglyLinkedList<E> {

    // Clase anidada para el nodo de la lista
    private static class Node<E> {
        private E element; // Elemento almacenado en este nodo
        private Node<E> next; // Referencia al siguiente nodo en la lista

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    private Node<E> head = null; // Primer nodo de la lista
    private Node<E> tail = null; // Último nodo de la lista
    private int size = 0; // Número de elementos en la lista

    public SinglyLinkedList() {
    } // Constructor para crear una lista vacía

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() { // Devuelve el primer elemento (sin eliminarlo)
        if (isEmpty()) return null;
        return head.getElement();
    }

    public void addFirst(E e) { // Añade un nuevo elemento al inicio de la lista
        head = new Node<>(e, head); // Crear y enlazar el nuevo nodo
        if (size == 0) tail = head; // Si la lista estaba vacía, el nuevo nodo es también el último
        size++;
    }

    public void addLast(E e) { // Añade un nuevo elemento al final de la lista
        Node<E> newNode = new Node<>(e, null); // El nuevo nodo no tiene un siguiente
        if (isEmpty()) {
            head = newNode; // Si la lista está vacía, el nuevo nodo es el primero
        } else {
            tail.setNext(newNode); // Conecta el último nodo actual con el nuevo nodo
        }
        tail = newNode; // El nuevo nodo es ahora el último
        size++;
    }

    public E removeFirst() { // Elimina y devuelve el primer elemento
        if (isEmpty()) return null; // Si la lista está vacía, no se puede eliminar nada
        E answer = head.getElement();
        head = head.getNext(); // Mueve el puntero de la cabeza al siguiente nodo
        size--;
        if (size == 0) tail = null; // Si la lista está vacía, tail debe ser null
        return answer;
    }
}

// Clase LinkedStack que utiliza la lista enlazada
public class LinkedStack<E> implements Stack<E> {
    private SinglyLinkedList<E> list = new SinglyLinkedList<>(); // una lista vacía

    public LinkedStack() {
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void push(E element) {
        list.addFirst(element); // Añade el elemento al inicio de la lista
    }

    public E top() {
        return list.first(); // Devuelve el primer elemento de la lista (cima de la pila)
    }

    public E pop() {
        return list.removeFirst(); // Elimina y devuelve el primer elemento de la lista (cima de la pila)
    }
}
