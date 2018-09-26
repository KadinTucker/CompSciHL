import java.util.LinkedList;

/**
 * An implementation of a stack data structure
 * using java's linked list class
 * For the IB Computer Science HL class
 * By Kadin Tucker
 */
public class StackLL implements StackIntrfc {
    
    private LinkedList<Double> stack; ///The internally stored stack
    
    /**
     * Constructs a new stack
     * Initializes the abstracted linked list
     */
    public StackLL() {
        stack = new LinkedList<Double>();
    }
    
    /**
     * Pushes an item to the top of the stack
     */
    public void push(double d) {
        stack.add(0, d);
    }
    
    /**
     * Removes the first item from the stack
     */
    public double pop() {
        Double temp = peek();
        stack.remove(0);
        return temp.doubleValue();
    }
    
    /**
     * Returns the item on top of the stack
     */
    public double peek() {
        if(stack.size() == 0) {
            return Double.NaN;
        }
        return stack.get(0).doubleValue();
    }
    
    /**
     * Returns the number of items in the stack
     */
    public int size() {
        return stack.size();
    }
    
    /**
     * Completely clears the stack
     */
    public void clear() {
        stack.clear();
    }
    
    /**
     * Main method; for testing 
     */
    public static void main(String[] args) {
        StackLL stck = new StackLL();
        System.out.println(stck.size());
        stck.push(157.3);
        stck.push(22);
        stck.push(-18);
        double j = stck.pop();
        System.out.println(j);
        System.out.println(stck.peek());
        System.out.println(stck.pop());
        System.out.println(stck.size());
        stck.clear();
        System.out.println(stck.size());
    }
    
}
