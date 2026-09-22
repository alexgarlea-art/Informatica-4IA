package Liste.SDDL;

public class Stack<T> extends List<T>{

    //Constructor
    /**
     * Creates a Stack, a dynamic data structure where you can only add and remove from the top element
     */
    public Stack(){
    }

    //Methods
    public void Push(T value){
        this.addTail(value);
    }

    public T pop(){
        return this.removeTail();
    }
}
