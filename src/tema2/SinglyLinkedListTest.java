package tema2;


public class SinglyLinkedListTest {
    public static void main(String[] args){
        SinglyLinkedList<String> sll= new SinglyLinkedList<>();
        System.out.println("size:"+sll.size());
        System.out.println("firs:"+sll.first());
        System.out.println("last:"+sll.last());
        sll.addfirst("jared");
        System.out.println("size:"+sll.size());
        System.out.println("firs:"+sll.first());
        System.out.println("last:"+sll.last());
        sll.addfirst("juan");
        System.out.println("size:"+sll.size());
        System.out.println("firs:"+sll.first());
        System.out.println("last:"+sll.last());
         System.out.println("remove:"+sll.removeFirst());
        
    }
}
