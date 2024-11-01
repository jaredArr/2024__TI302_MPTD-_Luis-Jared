/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema2;

public class TestArrayStack {
    public static void main(String[] args) {
        // Crear una pila con capacidad predeterminada
        ArrayStack<Integer> stack = new ArrayStack<>();

        // Verificar si la pila está vacía
        System.out.println("Pila vacía: " + stack.isEmpty()); // Debería ser true

        // Insertar elementos en la pila
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Imprimir el tamaño de la pila
        System.out.println("Tamaño de la pila: " + stack.size()); // Debería ser 3

        // Verificar el elemento en la parte superior de la pila
        System.out.println("Elemento en la parte superior: " + stack.top()); // Debería ser 30

        // Eliminar el elemento en la parte superior
        System.out.println("Elemento eliminado: " + stack.pop()); // Debería ser 30

        // Verificar el nuevo elemento en la parte superior
        System.out.println("Nuevo elemento en la parte superior: " + stack.top()); // Debería ser 20

        // Imprimir el tamaño de la pila
        System.out.println("Tamaño de la pila después de pop: " + stack.size()); // Debería ser 2

        // Probar la inserción hasta el límite de la pila
        ArrayStack<Integer> limitedStack = new ArrayStack<>(3); // Pila con capacidad 3
        limitedStack.push(1);
        limitedStack.push(2);
        limitedStack.push(3);
        
        // Verificar que lanzar una excepción al intentar agregar más elementos
        try {
            limitedStack.push(4); // Esto debería lanzar una excepción
        } catch (IllegalStateException e) {
            System.out.println("Excepción lanzada correctamente: " + e.getMessage()); // Debería mostrar "Stack is full"
        }

        // Verificar si la pila está vacía
        System.out.println("Pila vacía: " + limitedStack.isEmpty()); // Debería ser false

        // Vaciar la pila
        while (!limitedStack.isEmpty()) {
            System.out.println("Elemento eliminado: " + limitedStack.pop()); // Elimina y muestra los elementos
        }

        // Verificar si la pila está vacía después de eliminar todos los elementos
        System.out.println("Pila vacía después de vaciarla: " + limitedStack.isEmpty()); // Debería ser true
    }
}

