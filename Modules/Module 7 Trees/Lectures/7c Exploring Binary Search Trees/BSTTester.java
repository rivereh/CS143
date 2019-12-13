public class BSTTester {
   public static void main(String[] args) {
      int[] numbers = {20, 30, 5, 6};
      int[] numbers2 = {13, 10, 5, -8, 2, 17, -4, 6};
      int[] numbers3 = {5, 4, 7, 3, 9, 6};
      
      BST<Integer> bst = new BST<>();
      for(int n : numbers) 
         bst.add(n);
      
      System.out.println("==== Tree Info ==== ");
      bst.print();
      System.out.println("Count of nodes = " + bst.countNodes());
      System.out.println("The largest value in the tree is " + bst.max() + ".");
      System.out.println("Node 5 has " + bst.countChildren(5) + " children.");
      System.out.println("Node 6 has " + bst.countChildren(6) + " children.");
      System.out.println("isBalanced? " + bst.isBalanced());
      System.out.println("isBST? " + bst.isBST());
   }
}