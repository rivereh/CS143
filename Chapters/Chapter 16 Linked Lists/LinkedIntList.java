public class LinkedIntList {
   private ListNode front; // first value in the list 
   
   // post: constructs an empty list
   public LinkedIntList() {
      front = null;
   }
   
   // post: appends the given value to end of the list
   public void add(int value) {
      if (front == null) {
         front = new ListNode(value);
      } else {
         ListNode current = front;
         while (current.next != null) {
            current = current.next;
         }
         current.next = new ListNode(value);
      }
   }
   
   public void add(int value, int index) {
      if (index == 0) {
         front = new ListNode(value, front);
      } else {
         ListNode current = front;
         for (int i = 0; i < index - 1; i++) {
            current = current.next;
         }
         current.next = new ListNode(5, current.next);
      }
   }
   
   public int get(int index) {
      return nodeAt(index).data;
   }
   
   // post: returns comma-separated, bracketed version of list
   public String toString() {
      if (front == null) {
         return "[]";
      } else {
         String result = "[" + front.data;
         ListNode current = front.next;
         while (front != null) {
            result += ", " + current.data;
            current = current.next;
         }
         result += "]";
         return result;
      }
   }
   
   // pre : 0 <= 1 < size()
   // post: returns a reference to the node at the given index
   private ListNode nodeAt(int index) {
      ListNode current = front;
      for (int i = 0; i < index; i++) {
         current = current.next;
      }
      return current;
   }
   
   
}