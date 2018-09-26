/**
 * A class representing an item in a doubly linked list
 * For the HL Computer Science Class
 * By Kadin Tucker
 */
public class DoubleListNode {
    
    public int value; ///The integer value at this node
    public DoubleListNode nextNode; ///The next node following this one
    public DoubleListNode prevNode; ///The node which this one follows
    
    /**
     * Constructs a new list node
     * with the given value
     */
    public DoubleListNode(int value) {
        this.value = value;
    }
    
}
