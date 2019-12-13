public class ListNode {

   public int data;        // data stored in this node
   public ListNode next;   // link to next node in the list
   
   // post: constructs a node with data 0 and null link
   public ListNode() {
      this(0, null);
   }
   
   // post: constructs a node with given data and null link
   public ListNode(int data) {
      this(data, null);
   }
   
   // post: constructs a node with given data and given link
   public ListNode(int data, ListNode next) {
      this.data = data;
      this.next = next;
   }
   
   public static void main(String[] args) {
      //construct1();
      //construct2();
      
      // construct list 1, 2, 3
      ListNode list = new ListNode(1, new ListNode(2, new ListNode(3)));
      
      // example of getting rid of first node
      list = list.next;
      
      ListNode current = list;
      while (current != null) {
         System.out.println(current.data);
         current = current.next;
      }
      
      //for (ListNode current = list; current != null; current = current.next) {
      //    System.out.println(current.data);
      //}
   }
   
   // Constructs and prints the list [3, 7, 12] by setting each 2  
   // field of each node.
   public static void construct1() {
      ListNode list;
      list = new ListNode();
      
      list.data = 3;
      list.next = new ListNode();
      
      list.next.data = 7;
      list.next.next = new ListNode();
      
      list.next.next.data = 12;
      list.next.next.next = null;
      
      System.out.println(list.data + " " + list.next.data + " " + list.next.next.data);
   }
   
   // Constructs and prints the list [3, 7, 12]. This version uses 2
   // node constructors rather than setting fields of each node.
   public static void construct2() {
      ListNode list = new ListNode(3, new ListNode(7, new ListNode(12)));
      System.out.println(list.data + " " + list.next.data + " " + list.next.next.data);
   }
}



