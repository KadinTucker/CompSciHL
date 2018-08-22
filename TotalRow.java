import java.util.Arrays;

/**
 * Class for the Sum of Rows assignment for
 * Computer Science HL
 * By Kadin Tucker
 */
public class TotalRow {
    
    /**
     * Returns an array of the totals of each row of a given
     * integer matrix
     */
    private static int[] getRowTotals(int[][] matrix) {
        int[] totals = new int[matrix.length];
        for(int i = 0; i < matrix.length; i++) {
            int rowTotal = 0;
            for(int item: matrix[i]) {
                rowTotal += item;
            }
            totals[i] = rowTotal;
        }
        return totals;
    }
    
    /**
     * Takes in a matrix and uses the getRowTotals method
     * to find its row totals
     * Prints to the terminal the row totals
     */
    public static void printMatrixRows(int[][] matrix) {
        System.out.println("Row totals are :: " + 
                Arrays.toString(TotalRow.getRowTotals(matrix)));
    }
    
    /**
     * Main method; for testing only
     * Uses some sample data and runs the printMatrixRows method on them
     */
    public static void main(String[] args) {
        int[][] matrix1 = {{1,2,3},{5,5,5,5}};
        int[][] matrix2 = {{1,2,3},{5},{1},{2,2}};
        int[][] matrix3 = {{1,2},{5,5},{5,5},{4,5,6,7},{123124,12312}};
        TotalRow.printMatrixRows(matrix1);
        TotalRow.printMatrixRows(matrix2);
        TotalRow.printMatrixRows(matrix3);
    }
    
}
