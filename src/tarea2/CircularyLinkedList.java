package tarea2;

public class CircularyLinkedList<E>{
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
        
 
 private Node<E> tail;
 private int size;
 
 public CircularyLinkedList (){
 }
     public int size(){
         return size;
     }
     public boolean isEmpty(){
         return size ==0;
     }
     
     public E first(){
     if (isEmpty()){
         return null;
     }
     return tail.getNext().element;
     }
     
     public E last(){
     if (isEmpty())
         return null;
     
     return tail.element;
     }
     public void addfirst(E e){
        if(size==0){
           tail = new Node<> (e, null);
         tail.setNext(tail);
        } else{
         Node <E> newest = new Node<> (e, tail.next);
         tail.setNext(newest);
        }
         size++; 
     }
     
     public void addfLast(E e){
         addfirst(e);
         tail = tail.getNext();
//         if(size==0){
//           tail = new Node<> (e, null);
//         tail.setNext(tail);
//        } else{
//         Node <E> newest = new Node<> (e, tail.next);
//         tail.setNext(newest);
//        }
//         size++; 
     }
     
     public E removeFirst(){
         if (isEmpty()){
             return null;
         }
            Node<E> head = tail.next;
            if (head == tail){
                tail = null;
            
            }else{
            tail.setNext(head.getNext());
            
            }     
            size --;
            return head.element;
    }
    public void rotate(){
        if (tail !=null)
            tail = tail.getNext();
    }
}
 
