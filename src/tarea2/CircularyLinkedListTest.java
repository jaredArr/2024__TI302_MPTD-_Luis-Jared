package tarea2;

public class CircularyLinkedListTest {
    public static void main(String ... Args){
        test1();
    }
    
    public static void test1(){
        CircularyLinkedList cll = new CircularyLinkedList ();
        cll.addFirst("D");
        cll.addFirst("C");
        cll.addFirst("B");
        cll.addFirst("A");
        System.out.println(cll.first());
        
        cll.removeFirst();
        System.out.println(cll.first());
        cll.removeFirst();
        System.out.println(cll.first());
        cll.removeFirst();
        System.out.println(cll.first());
        cll.removeFirst();
        System.out.println(cll.first());
    }
    
}