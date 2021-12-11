public class LinkedCounter<T>{
    private CountNode<T> head;

    private int noOfNodes;
    private int sumOfCount;

    /**
     * LinkedCounter constructor
     */
    public LinkedCounter(){
        this.head = null;
        this.noOfNodes = 0;
        this.sumOfCount = 0;
    }

    /**
     * To get the number of nodes in the list
     * @return - size of the list
     */
    public int getSize(){
        return this.noOfNodes;
    }

    /**
     * To get the sum of the counts of the nodes
     * @return - sum of the count
     */
    public int getSum(){
        return this.sumOfCount;
    }

    /**
     * To check if the list is empty or not
     * To return true if no nodes are present else false will be returned
     * @return - boolen value to check list nodes
     */
    public boolean isEmpty(){
        if(this.noOfNodes == 0){
            return true;
        }
        return false;
    }

    /**
     * To check if both the elements are equal
     * @param left - T data object
     * @param right - T data object
     * @return - return boolean value
     */
    private boolean isEqual(T left, T right){
        if(left == null && right == null){
            return true;
        }else if((left == null && right != null) || (left != null && right ==null)){
            return false;
        }
        return left.equals(right);
    }

    /**
     * To get CountNode object with the given data
     * @param elem - Node to get
     * @return - CountNode object
     */
    private CountNode<T> getNode(T elem){
        CountNode<T> start = this.head;

        if(start != null){
            while(start != null){
                if(isEqual(start.getData(), elem)){
                    return start;
                }

                start = start.next;
            }
        }
        return null;
    }

    /**
     * To increse the count of a node if not present to add the element into the list
     * @param elem - Element to increase the count 
     * @return - updated count data
     */
    public int countUp(T elem){
        CountNode<T> nodeObj = getNode(elem);

        if(nodeObj != null){
            nodeObj.countUp();
            this.sumOfCount++;
            return nodeObj.getCount();
        }else{
            nodeObj = new CountNode<T>(elem, this.head);
            this.head = nodeObj;
            this.sumOfCount++;
            this.noOfNodes++;
            return nodeObj.getCount();
        }
    }

    /**
     * To decrease the count of the node of the given element
     * @return - count after decreasing
     */
    public int countDown(T elem){
        CountNode<T> start = this.head;
        CountNode<T> prevNode = null;
        if(start != null){
            while(start != null){
                if(isEqual(start.getData(), elem)){
                    start.countDown();
                    this.sumOfCount--;
                    if(start.getCount() == 0 && prevNode == null){
                        this.head = this.head.next;
                        this.noOfNodes--;
                        return 0;
                    }else if(start.getCount() ==0 && prevNode != null){
                        prevNode.next = start.next;
                        this.noOfNodes--;
                        return 0;
                    }

                    return start.getCount();
                }

                prevNode = start;
                start = start.next;
            }
        }

        return 0;
    }

    /**
     * To get the count of a element. If a node is present count value is returned else zero is returned
     * @param elem - element data
     * @return - count data
     */
    public int getCount(T elem){
        CountNode<T> nodeObj = getNode(elem);

        if(nodeObj != null){
            return nodeObj.getCount();
        }

        return 0;
    }
 
    /**
     * To format the string of the list
     * @return - return of the string
     */
    public String toString(){
        String returnValue = "";

        CountNode<T> start = this.head;
        if(start != null){
            while(start != null){
                returnValue += start.toString();

                if(start.next != null){
                    returnValue += " -> ";
                }

                start = start.next;
            }
        }

        return returnValue;
    }
}