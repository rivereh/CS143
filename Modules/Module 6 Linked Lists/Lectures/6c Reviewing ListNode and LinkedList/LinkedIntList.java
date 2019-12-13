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
   
   public int get(int index) {
      if (index > size - 1) {
         throw new IndexOutOfBoundsException("Index " + index + " does not exist.");
      }
      return nodeAt(index).data;
   }
   
   public void set(int index, int val) {
      nodeAt(index).data = val;
   }
   
   public void add(int index, int val) {
      if (index > size || index < 0)
         throw new IndexOutOfBoundsException("Cannot add at index " + index);
      else if (index == 0)
         addFront(val);
      else {
         nodeAt(index - 1).next = new ListNode(val, nodeAt(index));
         size++;
      }
   }
   
   public int remove(int index) {
      if (index > size || index < 0)
         throw new IndexOutOfBoundsException("Cannot remove at index " + index);
      else if (index == 0)
         return removeFront();
      else {
         ListNode<Integer> removed = nodeAt(index - 1);
         int value = removed.next.data;
         removed.next = removed.next.next;
         size--;
         return value;
      }
   }
   
   public void addFront(int val) {
      front = new ListNode<>(val, front);
      size++;
   }
   
   public void addEnd(int val) {
      ListNode<Integer> cur = front;
      while(cur.next != null) {
         cur = cur.next;
      }
      cur.next = new ListNode<>(val);
      size++;
   }
   
   public int removeFront() {
      if(size() == 0) {
         throw new IllegalArgumentException("Nothing to remove.");
      } else {
         int save = front.data;
         front = front.next;
         size--;
         return save;
      }
   }
   
   public int removeEnd() {
      if(size() == 0) {
         throw new IllegalArgumentException("Nothing to remove.");
      } else if(size() == 1) {
         return removeFront();
      } else {
         ListNode<Integer> cur = front;
         while(cur.next.next != null) {
            cur = cur.next;
         }
         int save = cur.next.data;
         cur.next = null;
         size--;
         return save;
      }
   }
   
   public boolean contains(int val) {
      ListNode<Integer> cur = front;
      while(cur != null) {
         if(cur.data == val) {
            return true;
         }
         cur = cur.next;
      }
      return false;
   }
   
   public int size() {
      // int count = 0;
//       ListNode<Integer> cur = front;
//       while(cur != null) {
//          cur = cur.next;
//          count++;
//       }
//       return count;
      return size;
   }
   
   public String toString() {
      if(size() == 0) { return "[]"; }
      
      StringBuilder build = new StringBuilder();
      ListNode<Integer> cur = front;
      while(cur.next != null) {
         build.append(cur.data + ", ");
         cur = cur.next;
      }
      build.append(cur.data);
      return "[" + build.toString() + "]";
   }
   
   private ListNode<Integer> nodeAt(int index) {
      ListNode<Integer> cur = front;
      for (int i = 0; i < index; i++) {
         cur = cur.next;
      }
      return cur;
   }
}