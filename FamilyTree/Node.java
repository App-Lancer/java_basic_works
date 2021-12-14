public class Node{

    /**
     * Basic node data to store the name of node
     */
    private String name;

    /**
     * To store the mother and father nodes in binary format
     */
    private Node mother, father;

    /**
     * Constructor of Node
     * @param name - name of Node
     */
    public Node(String name){
        this.name = name;
        this.mother = null;
        this.father = null;
    }

    /**
     * Getter method for father node
     * @return Node - father node
     */
    public Node getFather(){
        return this.father;
    }

    /**
     * Setter method for father node 
     * @param father - Node object for father
     */
    public void setFather(Node father){
        this.father = father;
    }

    /**
     * Getter method for mother node
     * @return Node - mother node
     */
    public Node getMother(){
        return this.mother;
    }

    /**
     * Setter method for mother node
     * @param mother - Node object for mother
     */
    public void setMother(Node mother){
        this.mother = mother;
    }

    /**
     * Getter method for name value
     * @return String - Node object data
     */
    public String getName(){
        return this.name;
    }
}