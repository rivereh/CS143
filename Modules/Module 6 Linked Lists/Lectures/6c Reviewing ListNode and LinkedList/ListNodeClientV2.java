import java.util.*;

public class ListNodeClientV2 {
   public static void main(String[] args) {
      example6();
   }
   
   public static void example6() {
      // creating three new nodes:
      // list -> A -> B -> C -> /
      
      
      // without creating new nodes:
      // list -> Z -> Z -> Z -> /
   }
   
   public static void example7() {
      // creating two new nodes:
      // list -> 5 -> 5 -> /
      
      // creating only 2 new nodes:
      // list -> 1 -> 5 -> 5 -> 1 -> /
   }
   
   public static void example8() {
      // creating three new nodes:
      // list -> 1.5 -> 2.7 -> 7.6 -> /
      
      // without creating new nodes:
      // list -> 7.6 -> 1.5 -> /
   }
   
   public static void example2() {
      ListIntNode list = new ListIntNode(10, null);
      list.next = new ListIntNode(11);
      list.next.next = new ListIntNode(12);
      // list -> 10 -> 11 -> 12 -> /
      System.out.println("list -> " + printNodes(list));
      
      list = new ListIntNode(9, list); // adds 9 at front
      list.next.next.next.next = new ListIntNode(13, new ListIntNode(14)); // adds on 13 & 14
      // list -> 9 -> 10 -> 11 -> 12 -> 13 -> 14 -> /
      System.out.println("list -> " + printNodes(list));
   }
   
   public static void example3() {
      ListIntNode list = new ListIntNode(20, new ListIntNode(30, new ListIntNode(40)));
      // list -> 20 -> 30 -> 40 -> /
      System.out.println("list -> " + printNodes(list));
      
      ListIntNode first = list;
      ListIntNode mid = list.next;
      ListIntNode last = list.next.next; // saves pointer to last node
      list = last;
      last.next = mid;
      mid.next = first;
      first.next = null; // ensures there's no circular links
      // list -> 40 -> 30 -> 20 -> /
      System.out.println("list -> " + printNodes(list));
   }
   
   public static void example4() {
      ListNode<Integer> list = new ListNode<>(111);
      list.next = new ListNode<Integer>(222);
      list = new ListNode<Integer>(333, list);
      // list -> 333 -> 111 -> 222 -> /
      System.out.println("list -> " + recursivePrintNodes(list));
      
      ListNode<Integer> mid = list.next; // save pointer to middle node
      list.next = list.next.next; // make first point at last
      mid.next = list; // make original middle point at original front
      list = mid; // make original middle the first node
      // list -> 111 -> 333 -> 222 -> /
      System.out.println("list -> " + recursivePrintNodes(list));
   }
   
   public static void example5() {
      ListNode<String> list1 = new ListNode<>("lake", new ListNode<String>("river", new ListNode<String>("ocean")));
      // list1 -> lake -> river -> ocean -> /
      System.out.println("list1 -> " + recursivePrintNodes(list1));
      
      ListNode<String> list2 = new ListNode<>("sky", new ListNode<String>("mountain", new ListNode<String>("canyon")));
      // list2 -> sky -> mountain -> canyon -> /
      System.out.println("list2 -> " + recursivePrintNodes(list2));
      
      ListNode<String> cur = list1;
      for (int i = 0; i < 3; i++) {
         ListNode<String> temp = list2;   // saves first node in list2
         list2 = list2.next;  // moves list2 pointer forward one
         temp.next = cur.next;  // attaches temp to latter half of list1
         cur.next = temp; // sets the current node in list1 to point at temp
         cur = cur.next.next; // advanced past the added node
      }
      // list1 -> lake -> sky -> river -> mountain -> ocean -> canyon -> /
      System.out.println("list1 -> " + recursivePrintNodes(list1));
   }
   
   public static String printNodes(ListIntNode list) {
      String str = "";
      while(list != null) {
         str += list.data + " -> ";
         list = list.next;
      }
      return str + "/";
   }
   
   public static <E> String recursivePrintNodes(ListNode<E> list) {
      if(list == null)
         return "/";
      else
         return list.data + " -> " + recursivePrintNodes(list.next);
   }
}