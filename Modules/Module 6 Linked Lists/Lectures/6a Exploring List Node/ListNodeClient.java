import java.util.*;

public class ListNodeClient {
   public static void main(String[] args) {
      example1();
      example2();
      example3();
      example4();
      example5();
   }
   
   public static void example1() {
      ListIntNode node1 = new ListIntNode(1);
      ListIntNode node2 = new ListIntNode(2, node1);
      ListIntNode list = new ListIntNode(3, node2);
      // list -> 3 -> 2 -> 1 -> /
      System.out.println("list -> " + printNodes(list));
      
      ListIntNode temp = new ListIntNode(4, new ListIntNode(5));
      // temp -> 4 -> 5 -> /
      System.out.println("temp -> " + printNodes(temp));
      
      // list -> 3 -> 2 -> 1 -> 4 -> 5 -> /
      node1.next = temp;
      //list.next.next.next = temp;
      System.out.println("list -> " + printNodes(list));
      
      // list -> 2 -> 1 -> 4 -> 5 -> /
      list = list.next;
      System.out.println("list -> " + printNodes(list));
      
      
      // list -> 2 -> 4 -> /
      list.next = list.next.next;
      list.next.next = null;
      System.out.println("list -> " + printNodes(list));
      
      // list -> /
      list = null;
      System.out.println("list -> " + printNodes(list));
   }
   
   public static void example2() {
      ListIntNode list = new ListIntNode(10, null);
      list.next = new ListIntNode(11);
      list.next.next = new ListIntNode(12);
      // list -> 10 -> 11 -> 12 -> /
      System.out.println("list -> " + printNodes(list));
      
      // list -> 9 -> 10 -> 11 -> 12 -> 13 -> 14 -> /
      ListIntNode node1 = new ListIntNode(14, null);
      ListIntNode node2 = new ListIntNode(13, node1);
      list.next.next.next = node2;
      ListIntNode temp = new ListIntNode(9, list);
      list = temp;
      
      System.out.println("list -> " + printNodes(list));
   }
   
   public static void example3() {
      ListIntNode list = new ListIntNode(20, new ListIntNode(30, new ListIntNode(40)));
      // list -> 20 -> 30 -> 40 -> /
      System.out.println("list -> " + printNodes(list));
      
      // list -> 40 -> 30 -> 20 -> /
      int temp = list.next.next.data;
      list.next.next.data = 20;
      list = new ListIntNode(temp, list.next);
      System.out.println("list -> " + printNodes(list));
   }
   
   public static void example4() {
      ListNode<Integer> list = new ListNode<>(111);
      list.next = new ListNode<Integer>(222);
      list = new ListNode<Integer>(333, list);
      // list -> 333 -> 111 -> 222 -> /
      System.out.println("list -> " + recursivePrintNodes(list));
      
      // list -> 111 -> 333 -> 222 -> /
      list = new ListNode<Integer>(list.next.data, list);
      list.next.next = list.next.next.next;
      System.out.println("list -> " + recursivePrintNodes(list));
   }
   
   public static void example5() {
      ListNode<String> list1 = new ListNode<>("lake", new ListNode<String>("river", new ListNode<String>("ocean")));
      // list1 -> lake -> river -> ocean -> /
      System.out.println("list1 -> " + recursivePrintNodes(list1));
      
      ListNode<String> list2 = new ListNode<>("sky", new ListNode<String>("mountain", new ListNode<String>("canyon")));
      // list2 -> sky -> mountain -> canyon -> /
      System.out.println("list2 -> " + recursivePrintNodes(list2));
      
      // list1 -> lake -> sky -> river -> mountain -> ocean -> canyon -> /
      list1.next.next = new ListNode<String>(list1.next.next.data, list2.next.next);
      list1.next.next = new ListNode<String>(list2.next.data, list1.next.next);
      list1.next = new ListNode<String>(list2.data, list1.next);
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

/*
  ----jGRASP exec: java -ea ListNodeClient
 list -> 3 -> 2 -> 1 -> /
 temp -> 4 -> 5 -> /
 list -> 3 -> 2 -> 1 -> 4 -> 5 -> /
 list -> 2 -> 1 -> 4 -> 5 -> /
 list -> 2 -> 4 -> /
 list -> /
 list -> 10 -> 11 -> 12 -> /
 list -> 9 -> 10 -> 11 -> 12 -> 13 -> 14 -> /
 list -> 20 -> 30 -> 40 -> /
 list -> 40 -> 30 -> 20 -> /
 list -> 333 -> 111 -> 222 -> /
 list -> 111 -> 333 -> 222 -> /
 list1 -> lake -> river -> ocean -> /
 list2 -> sky -> mountain -> canyon -> /
 list1 -> lake -> sky -> river -> mountain -> ocean -> canyon -> /
 
  ----jGRASP: operation complete.
*/ 