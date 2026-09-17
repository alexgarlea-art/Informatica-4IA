package Liste.LinkedList;
public class ListItem {
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

    /*public String toString(){
        if(this.next == null){
            return "Value: " + this.value + " Next: null" + "\n";
        }else{
            return "Value: " + this.value + " Next: " + this.next.value + "\n";
        }
    }*/
}