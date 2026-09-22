package Liste.SDDL;

public class Stack<T> extends List{

    //Constructor
    /**
     * Creates a Stack, a dynamic data structure where you can only add and remove from the top element
     */
    public Stack(){
    }

    //Methods
    public void Push(T value){
        ListItem<T> toAdd = new ListItem<T>(value);
        this.addHead();
    }
}
