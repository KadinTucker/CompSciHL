
/**
 * An implementation of the cipher interface 
 * which performs a caesar cipher
 * By Kadin Tucker; part of the HL Computer Science class
 */
public class Caesar implements Cipher {
    
    private String originalAlphabet; ///The original order of the alphabet
    private String shiftedAlphabet; ///The shifted alphabet to use in ciphering
    
    /**
     * Constructs a new Caesar cipher
     * Sets the shift to be a random integer on the interval [0, 26)
     * And stores the resulting shifted alphabet from that
     */
    public Caesar() {
        this.originalAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        this.shiftedAlphabet = "";
        int shift = (int)(Math.random() * (double)originalAlphabet.length());
        for(int i = shift; i < originalAlphabet.length(); i++) {
            this.shiftedAlphabet += originalAlphabet.charAt(i);
        }
        for(int i = 0; i < shift; i++) {
            this.shiftedAlphabet += originalAlphabet.charAt(i);
        }
    }
    
    /**
     * Performs a caesar cipher operation, either encoding or decoding
     * Takes in the string to operate on, the string from which to serach for indices
     * and the string containing characters to code to
     */
    private String doCaesarOperation(String toOperateOn, String to, String from) {
        String result = "";
        String upperCased = toOperateOn.toUpperCase();
        for(int i = 0; i < upperCased.length(); i++) {
            int index = to.indexOf(upperCased.charAt(i));
            if(index >= 0) {
                result += from.charAt(index);
            }
        }
        return result;
    }
   
    /**
     * Encodes the given string into the cipher
     */
    public String encode(String original) {
        return this.doCaesarOperation(original, this.originalAlphabet, this.shiftedAlphabet);
    }
    
    /**
     * Decodes the given string from the cipher
     */
    public String decode(String encoded) {
        return this.doCaesarOperation(encoded, this.shiftedAlphabet, this.originalAlphabet);
    }
    
    /**
     * Main method; for testing the class
     */
    public static void main(String[] args) {
        Caesar cipher = new Caesar();
        String encoded = cipher.encode("HelloWorld");
        System.out.println(encoded);
        String decoded = cipher.decode(encoded);
        System.out.println(decoded);
    }
    
}
