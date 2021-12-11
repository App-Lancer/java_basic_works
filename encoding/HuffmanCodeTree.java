public class HuffmanCodeTree{

    private HuffmanNode root;

    /**
     * HuffmanCodeTree constructor
     * @param root
     */
    public HuffmanCodeTree(HuffmanNode root){
        this.root = root;
    }

    /**
     * HuffmanCodeTree constructor for code book
     * @param root
     */
    public HuffmanCodeTree(HuffmanCodeBook codeBook){
        this.root = new HuffmanNode(null);

        // System.out.println("Size : " + codeBook.getSize());
        // codeBook.printAll();

        for(int i=0; i<codeBook.getSize(); i++){
            Character currentData = codeBook.getDataAtIndex(i);
            BinarySequence currentSequence = codeBook.getBinarySequenceAtIndex(i);

            //System.out.println("Character " + currentData + " Index : " + i);

            addElement(currentData, currentSequence, this.root, 0, currentSequence.size());
        }
    }

    /**
     * To recersively travers and add a element into the tree
     * @param data
     * @param seq
     * @param base
     * @param currentIndex
     * @param size
     */
    private void addElement(Character data, BinarySequence seq, HuffmanNode base, int currentIndex, int size){
        if(currentIndex == size){
            return;
        }

        HuffmanNode node;

        Boolean bit = seq.get(currentIndex);
        if(bit){
            node = base.getOne();
        }else{
            node = base.getZero();
        }

        if(node == null){
            HuffmanNode newNode = new HuffmanNode(null, null);

            if(currentIndex == size -1){
                newNode.setData(data);
            }

            if(bit){
                base.setOne(newNode);
            }else{
                base.setZero(newNode);
            }

            addElement(data, seq, newNode, currentIndex + 1, size);
        }else{
            addElement(data, seq, node, currentIndex + 1, size);
        }

    }

    /**
     * To check if the tree is valid
     * @return
     */
    public boolean isValid(){
        return this.root.isValid();
    }

    /**
     * To add a new element into the tree
     */
    public void put(BinarySequence seq, char letter){
        addElement(letter, seq, this.root, 0, seq.size());
    }
 
    /**
     * To decode the given sequence into the string
     * @param s
     * @return
     */
    public String decode(BinarySequence s){
        
        StringBuilder result = new StringBuilder();

        HuffmanNode base = this.root;
        for(int i=0; i<s.size(); i++){
            if(s.get(i)){
                base = base.getOne();
            }else{
                base = base.getZero();
            }

            if(base.isLeaf()){
                result.append(base.getData());
                base = this.root;
            }
        }
        return new String(result);
    }
}