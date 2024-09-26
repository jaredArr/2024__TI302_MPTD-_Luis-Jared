package tema2;

public class SinglyLinkedList<E> {
    
private static class Node <E>{
    private  E element;
    private Node<E> next ;

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
        
 private Node<E> head;
 private Node<E> tail;
 private int size;
 
 public SinglyLinkedList (){
 }
     public int size(){
         return size;
     }
     public boolean isEmpty(){
         return size ==0;
     }
     
     public E first(){
     if (isEmpty())
         return null;
     
     return head.element;
     }
     
     public E last(){
     if (isEmpty())
         return null;
     
     return tail.element;
     }
     public void addfirst(E e){
         head = new Node(e,head);
         if(size==0)
          tail=head;
         size++;
        /*Node<E> newest = new Node<> (e, null);
        newest.next = head;
        head = newest;
        size = size +1;
        */
     }
     public void addfLast(E e){
         Node<E> newest = new Node<> (e, null);
         if(isEmpty())
           head=newest;
         else
             tail.setNext(newest);
         tail=newest;
         size++;
     }
     public E removeFirst(){
         if (isEmpty())
         return null;
         E answer = head.getElement();
         head=head.next;
         size--;
         if(size==0)
           tail=null;
         return answer;
     }
     }
 