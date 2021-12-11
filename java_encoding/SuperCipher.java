public class SuperCipher{

    /**
     * @param input - input string for encoding
     * @param ciphers - Array of ciplhers object to ecode
     * @return  - Encode String based on passed ciphers object
     * The list of objects are used to contineously encrypt the string
     */
    public static String encrypt(String input, BaseCipher[] ciphers){
        for(int i=0; i < ciphers.length; i++){
            input = ciphers[i].encrypt(input);
        }

        return input;
    }

    /**
     * @param input - input string for decodinig
     * @param ciphers - Array of ciphers object to decode
     * @return - Decode String based on passed ciphers object
     * The list of objects are used to contineouslt decode the string
     */
    public static String decrypt(String input, BaseCipher[] ciphers){
        for(int i=0; i<ciphers.length; i++){
            input = ciphers[i].decrypt(input);
        }

        return input;
    }
}