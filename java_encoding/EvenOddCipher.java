public class EvenOddCipher extends BaseCipher{

    /**Even Odd Cipher Constructor */
    public EvenOddCipher(){
        super("EvenOddCipher");
    }

    /**To check of the chipher is valid
     * All even odd ciphers will be valid by default
     */
    public boolean isValid(){
        return true;
    }

    /**
     * @param input - input string to encrypt
     * @return - encrypted string
     * In the input string all even char strings are added first and all odd char strings follows them
     */
    public String encrypt(String input){

        String evenString = "";
        String oddString = "";

        for(int i=0; i< input.length(); i++){
            if(i%2==0){
                evenString += input.charAt(i);
            }else{
                oddString += input.charAt(i);
            }
        }

        return evenString + oddString;
    }

    /**
     * @param input - input string to decrypt
     * @return - decrypted string
     * The method is used to decrypt the string
     */
    public String decrypt(String input){

        int stringLen = input.length();
        int oddIndex = 0;

        if(stringLen %2 == 0){
            oddIndex = stringLen / 2;
        }else{
            oddIndex = (stringLen / 2) + 1;
        }

        String returnValue = "";

        for(int i=0; i < stringLen / 2; i++){
            returnValue += input.charAt(i) +""+ input.charAt(oddIndex);
            oddIndex++;
        }

        return returnValue;
    }

    /**
     * @param obj - Object to compare
     * @return boolean - value
     * To compare to differnet objects if they are equal
     * All Even Odd objects are equal
     */
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }else if(obj == null){
            return false;
        }else if(obj instanceof EvenOddCipher){
            EvenOddCipher evenOdd = (EvenOddCipher) obj;
            return true;
        }else{
            return false;
        }
    }
}