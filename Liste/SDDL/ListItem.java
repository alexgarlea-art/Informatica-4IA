package Liste.SDDL;

public class ListItem<T> {
    private ListItem<T> prev;
    private T value;
    private ListItem<T> next;


    //constructor
    public ListItem(T value){
        this.value = value;
    }


    /**
     * @return the item's value
     */
    public T getValue(){
        return this.value;
    }

    /**
     * sets the current next item
     * @param next
     */
    public void setNext(ListItem<T> next){
        this.next = next;
    }

    /**
     * @return next
     */
    public ListItem<T> getNext(){
        return this.next;
    }

    public ListItem<T> getPrev(){
        return this.prev;
    }

    public void setPrev(ListItem<T> prev){
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
