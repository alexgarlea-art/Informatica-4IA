package Liste.SDDL;

public class List<T> {
    private ListItem<T> head;
    private ListItem<T> tail;

    // Constructor
    protected List() {
    }

    // Methods

    /**
     * Adds a new ListItem to the end of the List
     *
     * @param value value to add
     */
    protected void addTail(T value) {
        if (this.head == null) {
            this.head = new ListItem<T>(value);
            this.tail = this.head;
        } else {
            ListItem<T> newItem = new ListItem<T>(value);

            this.tail.setNext(newItem);
            newItem.setPrev(this.tail);

            this.tail = newItem;
        }
    }

    /**
     * Adds a new ListItem to the beginning of the List
     *
     * @param value value to add
     */
    protected void addHead(T value) {
        if (this.head == null) {
            this.head = new ListItem<T>(value);
            this.tail = this.head;
        } else {
            ListItem<T> newItem = new ListItem<T>(value);

            newItem.setNext(this.head);
            this.head.setPrev(newItem);

            this.head = newItem;
        }
    }

    /**
     * Checks if the list is empty
     *
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty() {
        return this.head == null;
    }

    /**
     * @return the size of the list
     */
    public int size() {
        int size = 0;
        ListItem<T> cur = this.head;

        while (cur != null) {
            size++;
            cur = cur.getNext();
        }

        return size;
    }

    /**
     * Inserts value at index in the list.
     *
     * @param index index where to insert value
     * @param value value to add
     */
    protected void insert(int index, T value) {
        if (index <= 0) {
            this.addHead(value);
            return;
        }

        if (this.head == null) {
            System.out.println(
                "List Empty, impossible to insert in index " + index + "."
            );
            return;
        }

        ListItem<T> cur = this.head;

        for (int i = 0; i < index; i++) {
            if (cur.getNext() == null) {
                this.addTail(value);
                return;
            }

            cur = cur.getNext();
        }

        ListItem<T> newItem = new ListItem<T>(value);
        ListItem<T> previous = cur.getPrev();

        newItem.setPrev(previous);
        newItem.setNext(cur);

        previous.setNext(newItem);
        cur.setPrev(newItem);
    }

    /**
     * Removes and returns the first item in the list.
     *
     * @return removed value, or -1 if the list is empty
     */
    protected T removeHead() {
        if (this.head == null) {
            System.out.println("Nothing to remove, returning null");
            return null;
        }

        T headValue = this.head.getValue();

        if (this.head.getNext() == null) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.getNext();
            this.head.setPrev(null);
        }

        return headValue;
    }

    /**
     * Removes and returns the last item in the list.
     *
     * @return removed value or -1 if the list is empty
     */
    protected T removeTail() {
        if (this.tail == null) {
            System.out.println("Nothing to remove, returning null");
            return null;
        }

        T tailValue = this.tail.getValue();

        if (this.tail.getPrev() == null) {
            this.head = null;
            this.tail = null;
        } else {
            this.tail = this.tail.getPrev();
            this.tail.setNext(null);
        }

        return tailValue;
    }

    /**
     * Removes the item at index.
     *
     * @param index of the item to remove
     */
    protected void remove(int index) {
        if (this.head == null) {
            System.out.println(
                "List Empty, impossible to remove in index " + index + "."
            );
            return;
        }

        if (index <= 0) {
            this.removeHead();
            return;
        }

        ListItem<T> cur = this.head;

        for (int i = 0; i < index && cur.getNext() != null; i++) {
            cur = cur.getNext();
        }

        if (cur == this.tail) {
            this.removeTail();
            return;
        }

        ListItem<T> previous = cur.getPrev();
        ListItem<T> next = cur.getNext();

        previous.setNext(next);
        next.setPrev(previous);
    }
    
    /**
     * Clears the list
     */
    public void clear(){
        if(head == null){
            System.out.println("The list is empty.");
        }else{
            ListItem<T> cur = this.head;
            while(cur != null){
                if(cur.getPrev() != null){
                    cur.setPrev(null);
                }
                if(cur.getNext() != null){
                cur = cur.getNext();
                cur.getPrev().setNext(null);
                }
            }
            System.out.println("the list is clear.");
        }
    }

    /**
     * Returns the value at the specified index.
     *
     * @param index index of the item
     * @return value at the index
     */
    public T get(int index) {
        if (this.head == null) {
            System.out.println(
                "List Empty, impossible to get index " + index + ". Returning null."
            );
            return null;
        }

        if (index <= 0) {
            return this.head.getValue();
        }

        ListItem<T> cur = this.head;

        for (int i = 0; i < index && cur.getNext() != null; i++) {
            cur = cur.getNext();
        }

        return cur.getValue();
    }


     
    /**
     * Converts the list to an array.
     *
     * @return array containing all list values, or null if empty
     */
    /* 
    public T[] toArray() {
        int size = this.size();

        if (size == 0) {
            System.out.println("List empty, nothing to return.");
            return null;
        }

        T[] arr = new T[size];
        ListItem<T> cur = this.head;

        for (int i = 0; i < size; i++) {
            arr[i] = cur.getValue();
            cur = cur.getNext();
        }

        return arr;
    }*/

    @Override
    public String toString() {
        if (this.head == null) {
            return "Head: null \nTail: null";
        }

        String finalString = "";

        finalString += "Head: " + this.head.getValue() + "\n";
        finalString += "Tail: " + this.tail.getValue() + "\n";

        ListItem<T> cur = this.head;

        while (cur != null) {
            finalString += cur.toString();
            cur = cur.getNext();
        }

        return finalString;
    }
}