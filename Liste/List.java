package Liste;
public class List {
    //Attributes
    private ListItem head;

    //Constructor
    public List(){
        this.head = null;
    }

    //Methods

    /**
     * Adds a new ListItem to the existing List
     * @param value
     */
    public void add(int value){
        ListItem twinHead = this.head;
        while(this.head != null){
            twinHead = twinHead.getNext();
        }
        twinHead.setNext(new ListItem(value));
    }

    /**
     * Checks if the list is empty
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty(){
        return this.head == null;
    }

    /**
     * @return the size of the list
     */
    public int size(){
        int index = 0;
        while(this.head != null){
            this.head = this.head.getNext();
            index++;
        }
        return index;
    }

    /*public String toString(){

    }*/
}
