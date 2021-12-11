public class HuffmanNode{

    private HuffmanNode zero, one;
    private Character data;

    /**
     * HuffmanNode constructor
     */
    public HuffmanNode(HuffmanNode zero, HuffmanNode one){
        this.zero = zero;
        this.one = one;
    }

    /**
     * HuffmanNode constructor with data
     */
    public HuffmanNode(Character data){
        this.data = data;
        this.zero = null;
        this.one = null;
    }

    /**
     * Getter for zero node
     */
    public HuffmanNode getZero(){
        return this.zero;
    }

    /**
     * setter for zero node
     */
    public void setZero(HuffmanNode zero){
        this.zero = zero;
    }

     /**
     * Getter for one node
     */
    public HuffmanNode getOne(){
        return this.one;
    }

    /**
     * setter for one node
     */
    public void setOne(HuffmanNode one){
        this.one = one;
    }

    /**
     * Getter for date
     */
    public Character getData(){
        return this.data;
    }

    /**
     * setter for one node
     */
    public void setData(char data){
        this.data = data;
    }

    /**
     * To check if a node is a leaf node
     * @return
     */
    public boolean isLeaf(){
        return (this.data != null && this.zero == null && this.one == null);
    }

    /**
     * To check if a node is a valid node
     */
    public boolean isValid(){
        if(this.data == null && this.one==null && this.zero ==null) return false;

        boolean left = (this.zero == null) ? true : this.zero.isValid();
        boolean right = (this.one == null) ? true : this.one.isValid();

        boolean currentNode  = ((this.data == null && this.zero != null && this.one != null) || (this.data != null && this.zero == null && this.one == null));

        return currentNode && left && right;
    }
}