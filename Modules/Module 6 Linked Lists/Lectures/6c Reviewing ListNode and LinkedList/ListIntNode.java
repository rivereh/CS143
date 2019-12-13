// ListNode is a class for storing a single node of a linked list whose data
// is an integer. It has two public data fields for 1) the data and 2) the link
// to the next node in the list.

public class ListIntNode {
    public int data;          // data stored in this node
    public ListIntNode next;  // link to next node in the list

    // post: constructs a node with data 0 and null link
    public ListIntNode() {
        this(0, null);
    }

    // post: constructs a node with given data and null link
    public ListIntNode(int data) {
        this(data, null);
    }

    // post: constructs a node with given data and given link
    public ListIntNode(int data, ListIntNode next) {
        this.data = data;
        this.next = next;
    }
}