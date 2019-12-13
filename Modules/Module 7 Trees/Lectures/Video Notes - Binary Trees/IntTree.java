import java.util.*;

public class IntTree {
    private static final Random rand = new Random();
    private TreeNode<Integer> overallRoot;

    // post: constructs an empty tree
    public IntTree() {
        overallRoot = null;
    }

    // pre : max > 0
    // post: constructs a tree with the given number of levels
    public IntTree(int levels) {
        if (levels <= 0) {
            throw new IllegalArgumentException("level must be at least 1");
        }
        overallRoot = buildTree(1, levels);
    }

    // post: returns a random tree with the number of levels specified
    private TreeNode<Integer> buildTree(int n, int levels) {
        if (n > levels) {
            return null;
        } else {
            // generates random nums to decide if there should or should not be right/left children
            TreeNode<Integer> left = rand.nextInt(n + 1) == 0 ? null : buildTree(n + 1, levels);
            TreeNode<Integer> right = rand.nextInt(n + 1) == 0 ? null : buildTree(n + 1, levels);
            // generates a new node with a random value 0-100 and the right/left generated above
            return new TreeNode<Integer>(rand.nextInt(100), left, right);
        }
    }

    // post: prints the tree contents using a preorder traversal
    public void printPreorder() {
        System.out.print("preorder:");
        printPreorder(overallRoot);
        System.out.println();
    }

    // post: prints in preorder the tree with given root
    private void printPreorder(TreeNode<Integer> root) {
        if (root != null) {
            System.out.print(" " + root.data);
            printPreorder(root.left);
            printPreorder(root.right);
        }
    }

    // post: prints the tree contents using an inorder traversal
    public void printInorder() {
        System.out.print("inorder:");
        printInorder(overallRoot);
        System.out.println();
    }

    // post: prints in inorder the tree with given root
    private void printInorder(TreeNode<Integer> root) {
        if (root != null) {
            printInorder(root.left);
            System.out.print(" " + root.data);
            printInorder(root.right);
        }
    }

    // post: prints the tree contents using a postorder traversal
    public void printPostorder() {
        System.out.print("postorder:");
        printPostorder(overallRoot);
        System.out.println();
    }

    // post: prints in postorder the tree with given root
    private void printPostorder(TreeNode<Integer> root) {
        if (root != null) {
            printPostorder(root.left);
            printPostorder(root.right);
            System.out.print(" " + root.data);
        }
    }

    // post: prints the tree contents, one per line, following an
    //       inorder traversal and using indentation to indicate node
    //       depth; prints right to left so that it looks correct when
    //       the output is rotated; prints "empty" for an empty tree
    public void printSideways() {
        if (overallRoot == null) {
            System.out.println("empty tree");
        } else {
            printSideways(overallRoot, 0);
        }
    }

    // post: prints in reversed preorder the tree with given
    //       root, indenting each line to the given level
    private void printSideways(TreeNode<Integer> root, int level) {
        if (root != null) {
            printSideways(root.right, level + 1);
            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }
            System.out.println(root.data);
            printSideways(root.left, level + 1);
        }
    }
}