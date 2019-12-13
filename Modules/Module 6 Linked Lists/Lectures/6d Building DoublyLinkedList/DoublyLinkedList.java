import java.util.Iterator;

public class DoublyLinkedList<E> implements Comparable<DoublyLinkedList<E>>, Iterable<E>, List<E> {
   private ListNode<E> front;
   private int size;
   
   // creates an empty/null list
   public DoublyLinkedList() {
      front = null;
      size = 0;
   }
   
   // creates a new `front` node without a prev or next
   public DoublyLinkedList(E val) {
      front = new ListNode<>(val, null, null);  
      size = 1;
   }
   
   // Utilized add at index to add a new node at the end of the list
	public void add(E val) {
      // reuse add contructor to add node to end of lise
      add(size, val);
   }
   
   // Adds a new node at the specified index with the data `val`
   // throws IndexOutOfBounds if the index is invalid (not 0 to size-1)
   public void add(int index, E val) {
      if(index > size || index < 0) {
         throw new IndexOutOfBoundsException("Cannot add at Index " + index);
      }
      // increase size variable
      size++;
      if(index == 0) {
         // If adding to index 0 then create a new node with front
         // as it's next value.
         // Check if next node is not null to point back to front
         front = new ListNode<>(val, front, null);
         if (front.next != null)
            front.next.prev = front;
      } else {
         ListNode<E> cur = front;
         for(int i = 0; i < index - 1; i++) {
            cur = cur.next;
         }
         // create new node with pointers to prev and next
         ListNode<E> after = cur.next;
         ListNode<E> insert = new ListNode<>(val, after, cur);
         // override curr.next node with previous node
         cur.next = insert;
         if(after != null) 
            after.prev = insert;
      }   
   }
   
   // Returns the data at a given "virtual" index
   // throws IndexOutOfBounds if the index is invalid (not 0 to size)
   public E get(int index) {
      if(index > size - 1 || index < 0) {
         throw new IndexOutOfBoundsException("Index " + index + " does not exist.");
      }
      ListNode<E> cur = front;
      // go through each element in list up to given index and return data at that index
      for(int i = 0; i < index; i++) {
         cur = cur.next;
      }
      return cur.data;   
   }
   
   // return the "virtual" index of val, or -1 if not found
   public int indexOf(E val) {
      ListNode<E> cur = front;
      int index = -1;
      while (cur != null) {
         index++;
         if (cur.data == val)
            return index;
         cur = cur.next;
      }
      return index;
   }
   
   // return the data of the node at the index provided
	public E remove(int index) {
      if(index > size - 1 || index < 0) {
         throw new IndexOutOfBoundsException("Index " + index + " does not exist.");
      }
      // decrease size variable 
      size--;
      if(index == 0) {
         E data = front.data;
         // skip over front node and remove reference to previous front
         front = front.next;
         front.prev = null;
         return data;
      } else {
         // navigate to node at given index and capture it's data
         ListNode<E> cur = front;
         for (int i = 0; i < index; i++)
            cur = cur.next;
         E data = cur.data;
         // create before and after nodes
         ListNode<E> before = cur.prev;
         ListNode<E> after = cur.next;
         // relink before's next to after which skips over current
         before.next = after;
         // if after is not null then relink after's prev to before
         if (after != null)
            after.prev = before;
         return data;
      }
   }
   
   // Allows DoublyLinkedLists to be compared/sorted (done by number of nodes)
   public int compareTo(DoublyLinkedList other) {
      return size - other.size;   
   }
   
   // Allows DoublyLinkedLists to be checked for equality
   public boolean equals(DoublyLinkedList other) {
      return compareTo(other) == 0;
   }
   
   // Returns the number of nodes in the list
   // O(1) because continuously tracked during construct/add/remove
   public int size() {
      return size;
   }
   
   // Returns a String representation of this data
   public String toString() {
      if(size() == 0) { return "[]"; }
      
      StringBuilder build = new StringBuilder();
      ListNode<E> cur = front;
      while(cur.next != null) {
         build.append(cur.data + ", ");
         cur = cur.next;
      }
      build.append(cur.data);
      return "[" + build.toString() + "] size=" + size();
   }
   
   // Returns an iterator to this DoublyLinkedList
   public Iterator<E> iterator() { 
      return new DLLIterator(); 
   }
   
   // Create an iterator for this DoublyLinkedList
   private class DLLIterator implements Iterator<E> {
      // field to track the linked list node we have currently iterated to
      private ListNode<E> tracking = front;
   
      // is there another node?
      public boolean hasNext() { 
         return tracking != null;
      }
      
      // return the next piece of data in the DoublyLinkedList
      public E next() {
         E tData = tracking.data;
         tracking = tracking.next;
         return tData;
      }
      
      public void remove() {
         throw new UnsupportedOperationException("You should not remove using the Iterator.");
      }
   }
}