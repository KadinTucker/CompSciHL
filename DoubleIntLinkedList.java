/**
 * An implementation of a linked list with integer values
 * For the Computer Science HL class
 * By Kadin Tucker
 */
public class DoubleIntLinkedList {
    
    private DoubleListNode head; ///The head node of the linked list
    private DoubleListNode tail; ///The head node of the linked list
    private int size; ///The size of the list
    
    /**
     * Constructs a new integer linked list
     */
    public DoubleIntLinkedList() {
        this.clear();
    }
    
    /**
     * Adds a node to the end of the list
     */
    public void add(int value) {
        DoubleListNode toAppend = new DoubleListNode(value);
        if(this.head == null) {
            this.head = toAppend;
            this.tail = toAppend;
        } else {
            this.tail.nextNode = toAppend;
            toAppend.prevNode = this.tail;
            this.tail = toAppend;
        }
        this.size++;
    }
    
    /**
     * Inserts a node at the given index
     */
    public void add(int index, int value) {
        DoubleListNode toInsert = new DoubleListNode(value);
        if(index == 0) {
            toInsert.nextNode = this.head;
            this.head = toInsert;
        } else if(index == this.size - 1) {
            this.tail.nextNode = toInsert;
            toInsert.prevNode = this.tail.prevNode;
            this.tail = toInsert;
        } else {
            DoubleListNode atIndex = this.getNodeAt(index);
            toInsert.nextNode = atIndex;
            toInsert.prevNode = atIndex.prevNode;
            atIndex.prevNode = toInsert;
        }
        this.size++;
    }
    
    /**
     * Sets the value at the given index to be as given
     */
    public void set(int index, int value) {
        this.getNodeAt(index).value = value;
    }
    
    /**
     * Removes the given index from the list
     */
    public void remove(int index) {
        if(index == 0) {
            this.head = this.head.nextNode;
        } else {
            this.getNodeAt(index - 1).nextNode = this.getNodeAt(index + 1);
        }
        this.size--;
    }
    
    /**
     * Returns the list node at the given index
     * For internal use only
     */
    private DoubleListNode getNodeAt(int index) {
        DoubleListNode currentTracked;
        if(index < this.size / 2) {
            currentTracked = this.head;
            for(int i = 0; i < index; i++) {
                currentTracked = currentTracked.nextNode;
            }
        } else {
            currentTracked = this.tail;
            for(int i = 0; i < this.size - index; i++) {
                currentTracked = currentTracked.prevNode;
            }
        }
        return currentTracked;
    }
    
    /**
     * Gets the value of the node at the given index
     */
    public int get(int index) {
        return this.getNodeAt(index).value;
    }
    
    /**
     * Gets the size of the list
     */
    public int size() {
        return this.size;
    }
    
    /**
     * Clears the linked list of all elements
     */
    public void clear() {
        this.head = null;
        this.size = 0;
    }
    
    /**
     * Returns whether or not the linked list is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * Returns the linked list as a string
     */
    public String toString() {
        String str = "[";
        DoubleListNode currentNode = this.head;
        for(int i = 0; i < this.size; i++) {
            str += currentNode.value;
            currentNode = currentNode.nextNode;
            if(i < this.size - 1) {
                str += ", ";
            }
        }
        return str + "]";
    }
    
    /**
     * Main method; for testing
     */
    public static void main(String[] args) {
        IntegerLinkedList list = new IntegerLinkedList();
        list.add(5);
        System.out.println(list.toString()); //[5]
        list.add(7);
        System.out.println(list.toString()); //[5, 7]
        list.add(0, 3);
        System.out.println(list.toString()); //[3, 5, 7]
        list.add(2, 6);
        System.out.println(list.toString()); //[3, 5, 6, 7]
        list.remove(1);
        System.out.println(list.toString()); //[3, 6, 7]
        list.remove(0);
        System.out.println(list.toString()); //[6, 7]
    }
    
}
