public class ListNode<E> {
    public E data;
    public ListNode<E> next;  
    public ListNode<E> prev;  

    public ListNode() {
        this(null, null, null);
    }

    public ListNode(E data) {
        this(data, null, null);
    }

    public ListNode(E data, ListNode<E> next, ListNode<E> prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
    
    public String toString() {
      return "[" + this.data + "]";
    }
}