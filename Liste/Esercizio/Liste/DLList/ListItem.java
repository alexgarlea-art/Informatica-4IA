package Liste.DLList;

public class ListItem {
    private ListItem prev;
    private int value;
    private ListItem next;


    //constructor
    public ListItem(int value){
        this.value = value;
    }


    /**
     * @return the item's value
     */
    public int getValue(){
        return this.value;
    }

    /**
     * sets the current next item
     * @param next
     */
    public void setNext(ListItem next){
        this.next = next;
    }

    /**
     * @return next
     */
    public ListItem getNext(){
        return this.next;
    }

    public ListItem getPrev(){
        return this.prev;
    }

    public void setPrev(ListItem prev){
        this.prev = prev;
    }

    @Override 
    public String toString(){
    if(this.getNext() == null){
        if(this.getPrev() == null){
        return "Prev: null " + " Value: " + this.getValue() + " Next: null" + "\n";
        }else{
            return "Prev: " + this.getPrev().getValue() + " Value: " + this.getValue() + " Next: null" + "\n";
        }
    }else if (this.getPrev() == null) {
        return "Prev: null " + " Value: " + this.getValue() + " Next: " + this.getNext().getValue() + "\n";
    }else{
        return "Prev: " + this.getPrev().getValue() + " Value: " + this.getValue() + " Next: " + this.getNext().getValue() + "\n";
    }
    }
}