public class FamilyTree{

    /**
     * To store the root node of a binary node
     */
    private Node root;

    /**
     * Constructor of FamilyTree
     * @param ego - String value of root node
     */
    public FamilyTree(String ego){
        this.root = new Node(ego);
    }

    /**
     * To find the node with the name value in node data
     * @param name - name value to be searched for in the family tree
     */
    private Node find(String name){
        return find(name, this.root);
    }

    /**
     * To search for the name value in the family tree
     * @param name - search term to look inthe family tree
     * @param root - Node to start recursive search from
     * @return Node - The found node of the name value matches
     */
    private Node find(String name, Node root){
        if(root == null) return null;

        if(root.getName().equals(name)){
            return root;
        }

        Node temp = find(name, root.getMother());
        if(temp != null){
            return temp;
        }

        return find(name, root.getFather());
    }

    /**
     * To add parents to the given name value node
     * @param name - node value to which parent nodes to be added 
     * @param father - father node value
     * @param mother - mother node value
     */
    public void addParents(String name, String father, String mother){
        Node childNode = find(name);

        if(childNode != null){
            Node fatherNode = new Node(father);
            childNode.setFather(fatherNode);

            Node motherNode = new Node(mother);
            childNode.setMother(motherNode);
        }
    }
 
    /**
     * To get mother node value of the passed in value
     * @param ego - node value to which the mother node to be returned
     * @return String - mother node value
     */
    public String getMotherByName(String ego){
        Node childNode = find(ego);
        if(childNode != null && childNode.getMother() != null){
            return childNode.getMother().getName();
        }
        return null;
    }

     /**
     * To get father node value of the passed in value
     * @param ego - node value to which the father node to be returned
     * @return String - father node value
     */
    public String getFatherByName(String ego){
        Node childNode = find(ego);

        if(childNode != null && childNode.getFather() != null){
            return childNode.getFather().getName();
        }

        return null;
    }

    /**
     * To check if the ancestor value is a ancestor value of ego
     * @param ego - child to whcich the ancestor node to be checked
     * @param ancestor - ancestor value to check from the ego node
     * @return boolean - indicating if the passed in ancestor value is a ancestor node for the ego value
     */
    public boolean isDescendant(String ego, String ancestor){
        Node childNode = find(ego);
        Node parentNode = find(ancestor);

        if(childNode!= null && parentNode != null){
            return isDescendant(childNode, parentNode);
        }

        return false;
    }

    /**
     *  To check if the ancestor value is a ancestor value of ego
     * @param root - root node to start checking the ancestors
     * @param ancestor - ancestor value to compare from the root node
     * @return boolean - indicating if the passed in ancestor value is a ancestor node for the ego value
     */
    private boolean isDescendant(Node root, Node ancestor){
        if(root == null) return false;

        if(root == ancestor && root.getName().equals(ancestor.getName())){
            return true;
        }

        boolean isAncestor = isDescendant(root.getMother(), ancestor);
        return isAncestor ? isAncestor : isDescendant(root.getFather(), ancestor);
    }
}