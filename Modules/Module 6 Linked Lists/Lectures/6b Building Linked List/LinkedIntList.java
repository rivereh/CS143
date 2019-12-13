public class LinkedIntList {
   private ListNode<Integer> front;
   private int size;
   
   public LinkedIntList() {
      front = null;
      size = 0;
   }
   
   public LinkedIntList(int val) {
      front = new ListNode<>(val, null);
      size = 1;  
   }
   
   public void addFront(int val) {
      ListNode<Integer> toAdd = new ListNode<>(val, front);
      front = toAdd;
      size++;
   }
   
   public void addEnd(int val) {
      ListNode<Integer> cur = front;
      while (cur.next != null) {
         cur = cur.next;
      }
      cur.next = new ListNode<Integer>(val);
      size++;
   }
   
   public int removeFront() {
      if (front == null)
         throw new IllegalStateException("nothing to remove");
      int removed = front.data;
      front = front.next;
      size--;
      return removed;
   }
   
   public int removeEnd() {
      if (front == null)
         throw new IllegalStateException("nothing to remove");
      else if (size() == 1) {
         int removed = front.data;
         front = null;
         size--;
         return removed;
      }
      ListNode<Integer> cur = front;
      while (cur.next.next != null) {
         cur = cur.next;
      }
      int removed = cur.next.data;
      cur.next = null;
      size--;
      return removed;
   }
   
   public boolean contains(int val) {
      if (front == null)
         throw new IllegalStateException("nothing to compare");
      else if (size() == 1)
         return front.data == val;
      ListNode<Integer> cur = front;
      while (cur.next != null) {
         if (cur.data == val)
            return true;
         cur = cur.next;
      }
      return false;
   }
   
   // O(1)
   public int size() {
      return size;
   }
   
   public String toString() {
      String str = "";
      ListNode<Integer> cur = front;
      while (cur != null) {
         str += cur.toString();
         cur = cur.next;
      }
      return str;
   }
}