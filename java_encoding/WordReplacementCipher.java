public class WordReplacementCipher extends BaseCipher{
    
    private String fromString;
    private String toString;

    /**
     * @param fromString - from string to replace during encoding
     * @param toString - to string to place in the string during encoding
     */
    public WordReplacementCipher(String fromString, String toString){
        super("WordReplacementCipher");
        this.fromString = fromString;
        this.toString = toString;
    }

    /**
     * To check if the cipher is valid
     * The cipher is validi only when both fromString and toString are no null
     */
    @Override
    public boolean isValid(){
        return fromString != null && toString != null;
    }

    /**
     * @param input - input string to encode
     * @return encoded string
     * Replaces all occurences of fromString in input string to toString
     */
    @Override
    public String encrypt(String input){
        return input.replace(this.fromString, this.toString);
    }

    /**
     * @param input - input string to decode
     * @return decoded string
     * Relaces all occurences of toString in input string to fromString
     */
    @Override
    public String decrypt(String input){
        return input.replace(this.toString, this.fromString);
    }

    /**
     * @param obj - object to compare
     * @return boolean
     * Checks if both the fromString and toString of both the objects are same
     */
    @Override
    public boolean equals(Object obj){
        if(obj == this){
            return true;
        }else if(obj == null){
            return false;
        }else if(obj instanceof WordReplacementCipher){
            WordReplacementCipher cipher = (WordReplacementCipher) obj;
            return cipher.fromString.equals(this.fromString) && cipher.toString.equals(this.toString);
        }else{
            return false;
        }
    }
}