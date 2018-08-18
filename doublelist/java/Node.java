
/**
 * Node
 */
public class Node {

    public Object val;
    public Node prev;
    public Node next;

    public Node(Object val){
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}