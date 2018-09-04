
/**
 * An implementation of an array list specifically for integers
 * For the Computer Science HL class
 * by Kadin Tucker
 */
public class IntegerArrayList {
    
    private int[] list; ///The stored array in the class
    private int size; ///The size of the array
    
    /**
     * Constructs a new IAL
     * Initializes the stored array to be of size 10
     */
    public IntegerArrayList() {
        this.clear();
    }
    
    /**
     * Increases the capacity of the list by a factor of two
     */
    private void increaseListCapacity() {
        int[] newList = new int[this.list.length * 2];
        for(int i = 0; i < this.list.length; i++) {
            newList[i] = this.list[i];
        }
        this.list = newList;
    }
    
    /**
     * Adds an item to the array list
     */
    public void add(int x) {
        if(this.size >= list.length - 1) {
            this.increaseListCapacity();
        }
        list[this.size] = x;
        size++;
    }
    
    /**
     * Adds an item to the array list, inserting it at the given index
     */
    public void add(int index, int x) {
        if(this.size >= list.length - 1) {
            this.increaseListCapacity();
        }
        this.size++;
        for(int i = index; i < this.size - 1; i++) {
            this.list[i + 1] = this.list[i];
        }
        this.list[index] = x;
    }
    
    /**
     * Clears the array list of all elements
     */
    public void clear() {
        this.list = new int[10];
        this.size = 0;
    }
    
    /**
     * Gets the item at the given index
     */
    public int get(int index) {
        if(index >= this.size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("index '" + index + "' out of array bounds"); 
        }
        return this.list[index];
    }
    
    /**
     * Removes the element at the given index
     * TODO: store ranges? would that be more efficient? probs not
     */
    public void remove(int index) {
        for(int i = this.size - 1; i >= index; i++) {
            this.list[i] = this.list[i + 1];
        }
        this.size--;
    }
    
    /**
     * Gets the size of the array list
     */
    public int size() {
        return this.size;
    }
    
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    public String toString() {
        String str = "[";
        for(int i = 0; i < this.size; i++) {
            str = str + this.list[i] + ", ";
        }
        return str;
    }

}
