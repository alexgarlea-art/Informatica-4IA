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
        if(this.head == null){
            this.head = new ListItem(value);
        }else{
            ListItem twinHead = this.head;
        while(twinHead.getNext() != null){
            twinHead = twinHead.getNext();
        }
        twinHead.setNext(new ListItem(value));
        }
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
        if(this.head == null){
            return index;
        }else{
            ListItem twinHead = this.head;
        while(twinHead.getNext() != null){
            twinHead = twinHead.getNext();
            index++;
        }
        return index;
        }
    }

    /*public String toString(){

    }*/
}
