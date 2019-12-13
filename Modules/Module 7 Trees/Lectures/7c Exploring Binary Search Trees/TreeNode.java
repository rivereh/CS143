import java.util.*;

public class TreeNode<E extends Comparable<E>> {
    public E data;
    public TreeNode<E> left;
    public TreeNode<E> right;
                
    // constructs a leaf node with given data
    public TreeNode(E data) {
        this(data, null, null);
    }
                        
    // constructs a branch node with given data, left subtree, right subtree
    public TreeNode(E data, TreeNode<E> left, TreeNode<E> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
    
    public int compareTo(TreeNode<E> other) {
        return this.data.compareTo(other.data);
    }
}