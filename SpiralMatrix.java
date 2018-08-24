import java.util.Arrays;

/**
 * A class which creates and stores a matrix of integers
 * ordered in a spiral fashion, from 1 to n^2 and n is the
 * size of the matrix (argument given)
 */
public class SpiralMatrix {
    
    private int[][] matrix; ///The matrix stored
    private int size; ///The size of the matrix; matrices are squared for this
    
    /**
     * Creates a new matrix with the given size
     */
    public SpiralMatrix(int size) {
        this.size = size;
        this.createSpiral();
    }
    
    /**
     * Sets the size of the spiral
     */
    public void setSize(int size) {
        this.size = size;
        this.createSpiral();
    }
    
    /**
     * Gets the size of the spiral
     */
    public int getSize() {
        return this.size;
    }
    
    /**
     * Using the size, creates a spiral
     * Is run on construction and when setting size
     */
    private void createSpiral() {
        int lineIncrement = 1; //How many times a 'line' has been drawn
        int increment = 1; //How many iterations have happened, assigns this to next
        int row = -1; //The row at which the matrix is currently filling
        int col = 0; //The col at which the matrix is currently filling
        int direction = 0; //The direction which the row filler is going; 0=down, 1=right, 2=up, 3=left
        this.matrix = new int[size][size];
        //Main loop; runs until increment exceeds size squared
        while(increment <= this.size * this.size) {
            for(int i = 0; i < this.size - lineIncrement / 2; i++) {
                //Moves the location of the spiral drawing according to the direction to travel
                if(direction == 0) row++;
                if(direction == 1) col++;
                if(direction == 2) row--;
                if(direction == 3) col--;
                this.matrix[row][col] = increment;
                increment++;
            }
            //Once a 'line' has been completed, increment the line and update the direction
            lineIncrement++;
            direction++;
            direction %= 4;
        }
    }
    
    /**
     * Gets the matrix as a string
     */
    public String toString() {
        String str = "";
        for(int[] row: this.matrix) {
            for(int num: row) {
                str += num + "\t";
            }
            str += "\n";
        }
        return str;
    }
    
    /**
     * Main method; for testing
     */
    public static void main(String[] args) {
        SpiralMatrix matrix = new SpiralMatrix(11);
        System.out.println(matrix.toString());
    }
}
