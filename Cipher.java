/**
 * An interface defining the functions of a cipher
 */
public interface Cipher {
    
    /**
     * Encodes the given string into this cipher's language
     */
    public String encode(String original);
    
    /**
     * Decodes a string given from this cipher
     * Should work that encoding then decoding will
     * return the original string
     */
    public String decode(String encoded);
}
