/**
 * An interface defining functionality of a stack
 */
public interface StackIntrfc {

    /**
     * Place d on top of the stack
     */
    void push(double d);
    
    /**
     * Remove the item from the top of the stack
     */
    double pop();
    
    /**
     * Get the item on the top of the stack
     */
    double peek();
    
    /**
     * Get the size of the stack
     */
    int size();
    
    /**
     * Clear the stack
     */
    void clear();
    
}
