package tarea2;

public class DoubleLinkedListTest {
    public static void main(String ... Args){
        test1();
    }
    
    public static void test1(){
        DoubleLinkedList dll = new DoubleLinkedList ();
        dll.addFirst("D");
        dll.addFirst("C");
        dll.addFirst("B");
        dll.addFirst("A");
        System.out.println(dll.first());
        
        dll.removeFirst();
        System.out.println(dll.first());
        dll.removeFirst();
        System.out.println(dll.first());
        dll.removeFirst();
        System.out.println(dll.first());
        dll.removeFirst();
        System.out.println(dll.first());
    }
    
}