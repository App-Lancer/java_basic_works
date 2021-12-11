public class HuffmanCodeBook{

    private Character dataArr[];
    private BinarySequence[] binarySequences;

    private int size;
    private int capacity;

    /**
     * HuffmanCodeBook constrcutor
     */
    public HuffmanCodeBook(){
        dataArr = new Character[50];
        binarySequences = new BinarySequence[50];
        capacity = 50;
        size = 0;
    }

    /**
     * expand the size of the array if max capacity is used
     */
    private void expand(){
        Character[] tempDataArr = new Character[ capacity * 2];
        BinarySequence[] tempBinarySeq = new BinarySequence[ capacity * 2];

        for(int i=0; i<size; i++){
            tempDataArr[i] = this.dataArr[i];
            tempBinarySeq[i] = this.binarySequences[i];
        }

        this.dataArr = tempDataArr;
        this.binarySequences = tempBinarySeq;
        capacity = capacity * 2;

    }

    /**
     * To add a element into the code book
     */
    public void addSequence(char c, BinarySequence seq){
        if(size == 0){
            dataArr[size] = c;
            binarySequences[size] = seq;
            size++;
        }else if(size < capacity){
            for(int i = size-1; i>=0; i--){
                if((int)dataArr[i] > (int)c){
                    dataArr[i+1] = dataArr[i];
                    binarySequences[i+1] = binarySequences[i];
                }else if(dataArr[i].equals(c)){
                    binarySequences[i] = seq;
                }else{
                    dataArr[i + 1] = c;
                    binarySequences[i + 1] = seq;
                    break;
                }

                if(i==0){
                    dataArr[i] = c;
                    binarySequences[i] = seq;
                    break;
                }
            }
            size++;
        }else if(size == capacity){
            expand();

            for(int i= size - 1; i >= 0; i--){
                if(dataArr[i] > c){
                    dataArr[i+1] = dataArr[i];
                    binarySequences[i+1] = binarySequences[i];
                }else if(dataArr[i].equals(c)){
                    binarySequences[i] = seq;
                }else{
                    dataArr[i + 1] = c;
                    binarySequences[i + 1] = seq;
                    break;
                }

                if(i==0){
                    dataArr[i] = c;
                    binarySequences[i] = seq;
                }
            }
            size++;
        }
    }

    /**
     * to get the index of a special char
     */
    private int getIndex(char c){
        int low = 0;
        int high = size - 1;
        return getIndex(c, low, high);
    }

    /**
     * to get the index of a special char
     * overload method
     */
    private int getIndex(char c, int low, int high){
        if(low > high){
            return -1;
        }else if(low == high){
            return dataArr[low].equals(c) ? low : -1;
        }else{
            int mid = (high + low) / 2;

            int comprisonVal = Character.compare(dataArr[mid], c);
            if(comprisonVal == 0){
                return mid;
            }else if(comprisonVal > 0){
                return getIndex(c, low, mid - 1);
            }else{
                return getIndex(c, mid + 1, high);
            }
        }
    }

    /**
     * To check if the element is present in the book
     */
    public boolean contains(char letter){
        
        if(size == 0){
            return false;
        }else{
            int low = 0;
            int high = size - 1;

            int index = getIndex(letter, low, high);
            return (index == -1) ? false : true;
        }
    }

     /**
     * To check if all element is present in the book
     */
    public boolean containsAll(String letters){
        for(int i=0; i< letters.length(); i++){
            char currentChar = letters.charAt(i);

            if(!contains(currentChar)){
                return false;
            }
        }
        return true;
    }

     /**
     * To get binary sequecne of a char
     */
    public BinarySequence getSequence(char c){
        if(size == 0){
            return null;
        }else{
            int low = 0;
            int high = size - 1;

            int index = getIndex(c, low, high);
            if(index == -1){
                return null;
            }else{
                return binarySequences[index];
            }
        }
    }

     /**
     * To encode the given string
     */
    public BinarySequence encode(String s){
        BinarySequence result = new BinarySequence();

        for(int i=0; i<s.length(); i++){
            char currentChar = s.charAt(i);

            int index = getIndex(currentChar);
            if(index != -1){
                result.append(binarySequences[index]);
            }
        }

        return result;
    }

    /**
     * To get data at a particular index
     */
    public Character getDataAtIndex(int i){
        if( i >= 0 && i< size){
            return this.dataArr[i];
        }
        return null;
    }

     /**
     * To get binary sequence at a particular index
     */
    public BinarySequence getBinarySequenceAtIndex(int i){
        if(i>=0 && i < size){
            return this.binarySequences[i];
        }
    
        return null;
    }

    /**
     * To get the size
     * @return
     */
    public int getSize(){
        return this.size;
    }

    public void printAll(){
        for(int i=0; i<this.size; i++){
            Character t = dataArr[i];

            if(t.equals(' ')){
                System.out.println( i + " Space ");
            }else if(t.equals('\0')){
                System.out.println(i + " EOS ");
            }else if(t == null){
                System.out.println(i + " null ");
            }else if(t== '\t'){
                System.out.println(i + " tab ");
            }else if(t== '\n'){
                System.out.println(i + " newline ");
            }else{
                System.out.println(i + " " + t + " " + (int)t);
            }
        }
    }
}