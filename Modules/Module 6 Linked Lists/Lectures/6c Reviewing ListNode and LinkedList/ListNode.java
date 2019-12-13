public class ListNode<E> {
    public E data;
    public ListNode<E> next;  

    public ListNode() {
        this(null, null);
    }

    public ListNode(E data) {
        this(data, null);
    }

    public ListNode(E data, ListNode<E> next) {
        this.data = data;
        this.next = next;
    }
    
    public String toString() {
      return "[" + this.data + "]";
    }
}