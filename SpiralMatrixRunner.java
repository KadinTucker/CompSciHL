
/**
 * A class used to create spiral matrices and
 * run them, given some sample data
 */
public class SpiralMatrixRunner {
    
    /**
     * Using given size data, create spiral matrices
     * and print out their string representations
     */
    public static void run(int[] data) {
        for(int datum: data) {
            SpiralMatrix matrix = new SpiralMatrix(datum);
            System.out.println(matrix.toString() + " ");
        }
    }
    
}
