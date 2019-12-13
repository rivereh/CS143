import java.util.*;

public class BST <E extends Comparable <E>> {
	private TreeNode<E> overallRoot;

	public BST() {
		overallRoot = null;
	}

	// ************ ADD ************ //
	public void add(E addThis) {
      // if there is no root create new TreeNode with passed element
		if (overallRoot == null) {
			overallRoot = new TreeNode<>(addThis);
		} else {
         // else call recursive helper method to figure out where the new
         // node will go
			add(overallRoot, addThis);
		}
	}
   
   // compare element to left and right sides using compareTo to find which
   // branch to go down. if element is greater than root it goes right, otherwise it will
   // go left
	private TreeNode<E> add(TreeNode<E> node, E addThis) {
		if (node == null) {
			return new TreeNode<>(addThis);
		} else if (node.data.compareTo(addThis) > 0) {
			node.left = add(node.left, addThis);
		} else {
			node.right = add(node.right, addThis);
		}

		return node;
	}

	// ************ SEARCH ************ //
	public TreeNode<E> search(E find) {
		return search(overallRoot, find);
	}
   
	private TreeNode<E> search(TreeNode<E> node, E find) {
      // if couldn't find element return null or if element was found
      // return the node
		if (node == null || node.data.equals(find)) {
			return node;
		}
      // recursively search each level of tree for node by comparing left
      // and right sides, if current node is greater than element go left,
      // otherwise go right
      else if (node.data.compareTo(find) > 0) {
			return search(node.left, find);
		} else {
			return search(node.right, find);
		}
	}

	// ************ REMOVE ************ //
	public void remove(E deleteThis) {
		overallRoot = remove(overallRoot, deleteThis);
	}

	private TreeNode<E> remove(TreeNode<E> node, E deleteThis) {
		if (node == null) {
         return null;
      } else if (node.data.compareTo(deleteThis) > 0) {
				node.left = remove(node.left, deleteThis);
	   } else if (node.data.compareTo(deleteThis) < 0) {
				node.right = remove(node.right, deleteThis);
	   }
		else { // if (node.data.equals(deleteThis)) {
         if (node.left == null) {
				return node.right;
			} else if (node.right == null) {
				return node.left;
         } else {
   			node.data = findMax(node.left);
   			node.left = remove(node.left, node.data);
         }
		}
      return node;
	}

   // Returns the largest value from this node + it's subtree
	private E findMax(TreeNode<E> node) {
      while (node.right != null) {
         node = node.right;
      }
		return node.data;
	}

	// ************ PRINT ************ //
	public void print() {
      System.out.print("In order = ");
		printInorder(overallRoot);
      System.out.println();
	}

	private void printInorder(TreeNode<E> root) {
		if (root != null) {
			printInorder(root.left);
			System.out.print(root.data + " ");
			printInorder(root.right);
		}
	}

	// ************ NORMAL BINARY TREE OPERATIONS ************ //
	public int countLeaves() {
		return countLeaves(overallRoot);
	}

	private int countLeaves(TreeNode<E> node) {
		if (node == null) {
			return 0;
      } else if (node.left == null && node.right == null) {
			return 1;
		} else {
			return countLeaves(node.left) + countLeaves(node.right);
      }
	}
   
   // Returns the number of nodes total in the tree
   public int countNodes() {
      return countNodes(overallRoot);
   }
   
   private int countNodes(TreeNode<E> node) {
      if (node == null)
         return 0;
      else
         return 1 + countNodes(node.left) + countNodes(node.right);
   }

   // Returns the number of children for this value
	public int countChildren(E data) {
      TreeNode<E> subtree = search(data);
		return subtree == null ? 0 : countNodes(subtree) - 1;
	}
   
   // ************ BST OPERATIONS ************ //
   public E max() {
      return findMax(overallRoot);
   }
   
   public boolean isBST() {
      return isBST(overallRoot);
   }
   
   private boolean isBST(TreeNode<E> node) {
      if (node == null) {
         return true;
      } else {
         boolean leftCheck = node.left == null ? true : node.data.compareTo(node.left.data) > 0;
         boolean rightCheck = node.right == null ? true : node.data.compareTo(node.right.data) < 0;
         return leftCheck && rightCheck && isBST(node.left) && isBST(node.right);
      }
   }
   
   // Returns if the tree is balanced or not
   public boolean isBalanced() {
      int leftNodes = countChildren(overallRoot.left.data);
      int rightNodes = countChildren(overallRoot.right.data);
      return Math.abs(leftNodes - rightNodes) <= 1;
   }
   
   // ========== MAIN ==========
   public static void main(String[] args) {
      int[] numbers = {20, 30, 5, 6};
      int[] numbers2 = {13, 10, 5, -8, 2, 17, -4, 6};
      int[] numbers3 = {5, 4, 7, 3, 9, 6};
      int[] numbers4 = {10, 6, 20, 4, 7, 29, 2, 9, 21, 15, 5, 31, 16};
      
      BST<Integer> bst = new BST<>();
      for(int n : numbers4) 
         bst.add(n);
      
      System.out.println("==== Tree Info ==== ");
      bst.print();
      System.out.println("Count of leaves = " + bst.countLeaves());
      System.out.println("Count of nodes = " + bst.countNodes());
      System.out.println("The largest value in the tree is " + bst.max() + ".");
      System.out.println("Node 5 has " + bst.countChildren(5) + " children.");
      System.out.println("Node 6 has " + bst.countChildren(6) + " children.");
      System.out.println("isBalanced? " + bst.isBalanced());
      System.out.println("isBST? " + bst.isBST());
   }

} //end of BST