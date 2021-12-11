public class Map<Key, Value>{

    //private array of type Key generic type to hold the keys of the map
    private Key[] keys;
    //private array of type Value generic type to hole the values of the map
    private Value[] values;

    //Size of the map - number of elements present in the map
    private int size;
    //Total capacity of the map - max number of elements the map can hold
    private int capacity;

    /**
     * Constructor of the class
     * @param length - size to initialize of the map
     * By default if the value passed to length is less then 1 a map of capacity 1 will be created
     */
    public Map(int length){
        if(length < 1){
            length = 1;
        }

        keys = (Key[]) new Object[length];
        values = (Value[]) new Object[length];
        this.size = 0;
        this.capacity = length;
    }

    /**
     * To get the size of the map - number of elements present in the map
     * @return - size of the map
     */
    public int size(){
        return this.size;
    }

    /**
     * To compare 2 keys if they are equal
     * null values are also handled in this case
     * @param leftKey - left key to compare
     * @param rightKey - right key to compare
     * @return - boolean value that represents the equality of the both the keys
     */
    private boolean isEqual(Key leftKey, Key rightKey){
        if((leftKey == null && rightKey != null) || (leftKey != null && rightKey == null)){
            return false;
        }

        if((leftKey == null && rightKey == null) || leftKey.equals(rightKey)){
            return true;
        }

        return false;
    }

    /**
     * To get the index of key in the map
     * if key is present the index will be returned else -1 will be returned
     * @param key - key to check if present in map
     * @return - index of the key in map
     */
    private int getIndex(Key key){
        if(this.size == 0){
            return -1;
        }

        for(int i=0; i<this.size; i++){
            if(isEqual(this.keys[i], key)){
                return i;
            }
        }

        return -1;
    }

    /**
     * To get value of the key passed
     * If the key is present the corresponding value will be returned else null will be returned
     * @param key - key to get the value for
     * @return - value of the passed key
     */
    public Value get(Key key){
        int index = getIndex(key);
        if(index != -1){
            return values[index];
        }

        return null;
    }

    /**
     * To check if the passed key is present in the map
     * if the key is present true will be returned else false will be retuened
     * @param key - key to be checked in list
     * @return - boolean to represent the availability of the key in the map
     */
    public boolean containsKey(Key key){
        if(getIndex(key) != -1){
            return true;
        }

        return false;
    }

    /**
     * To double the size of the keys and values array
     * the keys array and the values are dobuled in capacity size and the orignal contents of the value or copied to the new array
     */
    private void increaseSize(){
        Key[] tempKeys = (Key[]) new Object[this.capacity * 2];
        Value[] tempValues = (Value[]) new Object[this.capacity * 2];

        this.capacity = this.capacity * 2;

        for(int i=0; i<this.size;i++){
            tempKeys[i] = this.keys[i];
            tempValues[i] = this.values[i];
        }

        this.keys = tempKeys;
        this.values = tempValues;
    }

    /**
     * Adds a new key value pair to the map
     * If the key is already present the key is updated with the new value
     * if the key is not present a new entry will be added
     * If the map reaches its max capacity - the map size will be doubled
     * @param key - key to add
     * @param value - value to add
     */
    public void put(Key key, Value value){

        if(this.size == this.capacity){
            increaseSize();
        }

        int index = getIndex(key);
        if (index != -1){
            values[index] = value;
        }else{
            keys[size] = key;
            values[size] = value;
            this.size++;
        }
    }

}