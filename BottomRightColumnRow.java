import java.util.Arrays;

/**
 * A matrix-based cipher
 * Written for the Computer Science HL class 
 * By Kadin Tucker
 */
public class BottomRightColumnRow implements Cipher {
    
    /**
     * Returns the integer square root of the number
     * 'from', rounded down
     */
    private int getIntegerSqrt(int from) {
        double sqrt = Math.sqrt((double)from);
        if(sqrt % 1 == 0) {
            return (int)sqrt;
        } else {
            return (int)sqrt + 1;
        }
    }
    
    /**
     * Takes in a string and returns a square matrix representation of it
     */
    private String[][] matricizeString(String toMatricize) {
        int sideLength = this.getIntegerSqrt(toMatricize.length());
        while(toMatricize.length() < sideLength * sideLength) {
            toMatricize += "*";
        }
        String[][] matrix = new String[sideLength][sideLength];
        for(int i = 0; i < sideLength; i++) {
            for(int j = 0; j < sideLength; j++) {
                matrix[i][j] = Character.toString(toMatricize.charAt(i * sideLength + j));
            }
        }
        return matrix;
    }
    
    /**
     * Flattens a matrix of strings into a single string
     */
    private String flatten(String[][] toFlatten) {
        String flattened = "";
        for(int i = 0; i < toFlatten.length; i++) {
            for(int j = 0; j < toFlatten[i].length; j++) {
                flattened += toFlatten[i][j];
            }
        }
        return flattened;
    }
    
    /**
     * Runs the method for swapping around the matrix
     * Main functionality is identical for encoding and decoding
     */
    private String encodeOrDecode(String toActOn) {
        String[][] matrix = matricizeString(toActOn);
        String[][] rowColSwapped = new String[matrix.length][matrix.length];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix.length; j++) {
                rowColSwapped[i][j] = matrix[matrix.length - j - 1][matrix.length - i - 1];
            }
        }
        return this.flatten(rowColSwapped);
    }
    
    /**
     * Encodes a string into bottom right column row swap form
     */
    public String encode(String original) {
        return this.encodeOrDecode(original);
    }
    
    /**
     * Decodes a string from bottom right column row swap form
     * Removes asterisks used as placeholders previously
     */
    public String decode(String encoded) {
        String decoded = this.encodeOrDecode(encoded);
        return decoded.replaceAll("\\*", "");
    }
    
    /**
     * Main method; for testing only
     */
    public static void main(String[] args) {
        BottomRightColumnRow cipher = new BottomRightColumnRow();
        System.out.println(cipher.encode("friendly"));
        System.out.println(cipher.decode(cipher.encode("friendly")));
    }
     
}
