public class IntTree {
   private IntTreeNode overallRoot;
   
   public IntTree(int max) {
      overallRoot = buildTree(1, max);
   }
   
   // returns a sequential tree with n as its root unless n is
   // greater than max, in which case it returns an empty tree
   private IntTreeNode buildTree(int n, int max) {
      if (n > max) {
         return null;
      } else {
         IntTreeNode left = buildTree(2 * n, max);
         IntTreeNode right = buildTree(2 * n + 1, max);
         return new IntTreeNode(n, left, right);
      }
   }
   
   
   public void printPreorder() {
      System.out.print("preorder:");
      printPreorder(overallRoot);
      System.out.println();
   }
   
   private void printPreorder(IntTreeNode root) {
      if (root != null) {
         System.out.print(" " + root.data);
         printPreorder(root.left);
         printPreorder(root.right);
      }
   }
   
   public void printInorder() {
      System.out.print("inorder:");
      printInorder(overallRoot);
      System.out.println();
   }
   
   private void printInorder(IntTreeNode root) {
      if (root != null) {
         printInorder(root.left);
         System.out.print(" " + root.data);
         printInorder(root.right);
      }
   }
   
   public void printPostorder() {
      System.out.print("inorder:");
      printPostorder(overallRoot);
      System.out.println();
   }
   
   private void printPostorder(IntTreeNode root) {
      if (root != null) {
         printPostorder(root.left);
         printPostorder(root.right);
         System.out.print(" " + root.data);
      }
   }
   
   
}