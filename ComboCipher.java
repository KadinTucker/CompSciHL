/**
 * A class which acts as a cipher and uses multiple
 * existing types of cipher to encode and decode
 * For the Computer Science HL class
 * By Kadin Tucker
 */
public class ComboCipher implements Cipher {
    
    private Cipher[] allCiphers; ///Each of the ciphers to be used by this combo cipher
    
    /**
     * Constructs a new combo cipher that uses the given ciphers
     */
    public ComboCipher(Cipher[] ciphers) {
        this.allCiphers = ciphers;
    }
    
    /**
     * Default constructor which automatically makes the ciphers to use caesar and 
     * bottom right column row
     */
    public ComboCipher() {
        Caesar caesar = new Caesar();
        BottomRightColumnRow brcr = new BottomRightColumnRow();
        this.allCiphers = new Cipher[2];
        this.allCiphers[0] = caesar;
        this.allCiphers[1] = brcr;
    }
    
    /**
     * Encodes the string by running each cipher's encode on the original,
     * in order.
     */
    public String encode(String original) {
        for(int i = 0; i < this.allCiphers.length; i++) {
            original = this.allCiphers[i].encode(original);
        }
        return original;
    }
    
    /**
     * Decodes the string by running each cipher's decode in reverse order
     */
    public String decode(String encoded) {
        for(int i = this.allCiphers.length - 1; i >= 0; i--) {
            encoded = this.allCiphers[i].decode(encoded);
        }
        return encoded;
    }
    
    /**
     * Main method; for testing
     */
    public static void main(String[] args) {
        ComboCipher combo = new ComboCipher();
        String coded = "HelloWorld";
        System.out.println(coded);
        coded = combo.encode(coded);
        System.out.println(coded);
        coded = combo.decode(coded);
        System.out.println(coded);
    }
}
