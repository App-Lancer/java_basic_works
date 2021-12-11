public class CountNode<T>{

    T data;
    int count;
    CountNode<T> next;

    /**
     * CountNode constructor
     */
    public CountNode(){
        this.data = null;
        this.count = 0;
        this.next = null;
    }

    /**
     * CountNode constructor with param values
     * @param data - data value
     * @param next - next element
     */
    public CountNode(T data, CountNode<T> next){
        this.data = data;
        count = 1;
        this.next = next;
    }

    /**
     * Getter for data object
     * @return - return get data
     */
    public T getData(){
        return this.data;
    }

    /**
     * Getter for count data
     * @return - return count of the node
     */
    public int getCount(){
        return this.count;
    }

    /**
     * To increase the count value of node by 1
     */
    public void countUp(){
        this.count++;
    }

    /**
     * To decrese the count value of node by 1
     */
    public void countDown(){
        if(this.count > 0)
            this.count--;
    }

    /**
     * To get the next node value of the current node
     * @return - CountNode object
     */
    public CountNode<T> getNext(){
        return this.next;
    }

    /**
     * To set the next node for the current node
     * @param - CountNode object
     */
    public void setNext(CountNode<T> next){
        this.next = next;
    }

    /**
     * To print the string format value of the Node object
     * @return String
     */
    public String toString(){
        return this.data+":"+this.count;
    }

}