package Liste.SDDL;

public class Queue<T> extends List<T>{
    
    /**
     * Creates a new Queue
     */
    public Queue(){
    }

    /**
     * Adds an element at the end of the Queue
     * @param value
     */
    public void enqueue(T value){
        this.addTail(value);
    }

    /**
     * Removes the head element of the queue and returns it
     * @return The head element of the queue
     */
    public T dequeue(){
        return this.removeHead();
    }
}
