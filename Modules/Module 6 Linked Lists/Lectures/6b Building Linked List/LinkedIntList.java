public class LinkedIntList {
   private ListNode<Integer> front;
   
   public LinkedIntList() {
      front = null;
   }
   
   public LinkedIntList(int val) {
      front = new ListNode<>(val, null);  
   }
   
   public void addFront(int val) {
   }
   
   public void addEnd(int val) {
   }
   
   public int removeFront() {
      return -1;
   }
   
   public int removeEnd() {
      return -1;
   }
   
   public boolean contains(int val) {
      return false;
   }
   
   public int size() {
      return -1;
   }
   
   public String toString() {
      return "";
   }
}