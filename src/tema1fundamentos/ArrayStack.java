package tema1fundamentos;

public class ArrayStack<E> implements Stack<E> {
    public static final int CAPACITY = 1000; 
    private E[] data;
    private int t = -1; // Inicializa t en -1 (indica que la pila está vacía)

    public ArrayStack() {
        this(CAPACITY); // Constructor sin parámetros, llama al constructor con la capacidad predeterminada
    }

    public ArrayStack(int capacity) {
        data = (E[]) new Object[capacity]; // Safe cast, pero puede generar una advertencia de compilación
    }

    public int size() {
        return (t + 1); // El tamaño es t + 1, porque t es el índice del último elemento
    }

    public boolean isEmpty() {
        return (t == -1); // La pila está vacía cuando t es -1
    }

    public void push(E e) throws IllegalStateException {
        if (size() == data.length) {
            throw new IllegalStateException("Stack is full"); // Lanza excepción si la pila está llena
        }
        data[++t] = e; // Incrementa t antes de insertar el elemento
    }

    public E top() {
        if (isEmpty()) {
            return null; // Si la pila está vacía, devuelve null
        }
        return data[t]; // Devuelve el elemento en la parte superior
    }

    public E pop() {
        if (isEmpty()) {
            return null; // Si la pila está vacía, devuelve null
        }
        E answer = data[t]; // Guarda el elemento en la parte superior
        data[t] = null; // Elimina la referencia para permitir la recolección de basura
        t--; // Decrementa t
        return answer; // Devuelve el elemento eliminado
    }
}
