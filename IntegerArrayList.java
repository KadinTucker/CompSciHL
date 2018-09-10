
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
        for(int i = this.size; i > index; i--) {
            this.list[i] = this.list[i - 1];
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
        return this.list[index];
    }
    
    /**
     * Removes the element at the given index
     */
    public void remove(int index) {
        System.out.println("start remove");
        for(int i = index; i < this.size - 1; i++) {
            System.out.println(toString());
            this.list[i] = this.list[i + 1];
        }
        System.out.println("end remove");
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
            str = str + this.list[i];
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
        IntegerArrayList list = new IntegerArrayList();
        list.add(5);
        System.out.println(list.toString()); //[5]
        list.add(7);
        System.out.println(list.toString()); //[5, 7]
        list.add(0, 3);
        System.out.println(list.toString()); //[3, 5, 7]
        list.add(2, 4);
        System.out.println(list.toString()); //[3, 5, 4, 7]
        list.remove(1);
        System.out.println(list.toString()); //[3, 4, 7]
        list.remove(0);
        System.out.println(list.toString()); //[4, 7]
    }

}
