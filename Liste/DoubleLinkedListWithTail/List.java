package Liste.DoubleLinkedListWithTail;

public class List {
    private ListItem head;
    private ListItem tail;

    // Constructor
    public List() {
    }

    // Methods

    /**
     * Adds a new ListItem to the end of the List
     *
     * @param value value to add
     */
    public void addTail(int value) {
        if (this.head == null) {
            this.head = new ListItem(value);
            this.tail = this.head;
        } else {
            ListItem newItem = new ListItem(value);

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
    public void addHead(int value) {
        if (this.head == null) {
            this.head = new ListItem(value);
            this.tail = this.head;
        } else {
            ListItem newItem = new ListItem(value);

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
        ListItem cur = this.head;

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
    public void insert(int index, int value) {
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

        ListItem cur = this.head;

        for (int i = 0; i < index; i++) {
            if (cur.getNext() == null) {
                this.addTail(value);
                return;
            }

            cur = cur.getNext();
        }

        ListItem newItem = new ListItem(value);
        ListItem previous = cur.getPrev();

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
    public int removeHead() {
        if (this.head == null) {
            System.out.println("Nothing to remove, returning -1");
            return -1;
        }

        int headValue = this.head.getValue();

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
    public int removeTail() {
        if (this.tail == null) {
            System.out.println("Nothing to remove, returning -1");
            return -1;
        }

        int tailValue = this.tail.getValue();

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
    public void remove(int index) {
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

        ListItem cur = this.head;

        for (int i = 0; i < index && cur.getNext() != null; i++) {
            cur = cur.getNext();
        }

        if (cur == this.tail) {
            this.removeTail();
            return;
        }

        ListItem previous = cur.getPrev();
        ListItem next = cur.getNext();

        previous.setNext(next);
        next.setPrev(previous);
    }

    /**
     * Returns the value at the specified index.
     *
     * @param index index of the item
     * @return value at the index
     */
    public int get(int index) {
        if (this.head == null) {
            System.out.println(
                "List Empty, impossible to get index " + index + ". Returning 0."
            );
            return 0;
        }

        if (index <= 0) {
            return this.head.getValue();
        }

        ListItem cur = this.head;

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
    public int[] toArray() {
        int size = this.size();

        if (size == 0) {
            System.out.println("List empty, nothing to return.");
            return null;
        }

        int[] arr = new int[size];
        ListItem cur = this.head;

        for (int i = 0; i < size; i++) {
            arr[i] = cur.getValue();
            cur = cur.getNext();
        }

        return arr;
    }

    @Override
    public String toString() {
        if (this.head == null) {
            return "Head: null \nTail: null";
        }

        String finalString = "";

        finalString += "Head: " + this.head.getValue() + "\n";
        finalString += "Tail: " + this.tail.getValue() + "\n";

        ListItem cur = this.head;

        while (cur != null) {
            if (cur.getPrev() == null) {
                finalString += "Prev: null ";
            } else {
                finalString += "Prev: " + cur.getPrev().getValue() + " ";
            }

            finalString += "Value: " + cur.getValue() + " ";

            if (cur.getNext() == null) {
                finalString += "Next: null\n";
            } else {
                finalString += "Next: " + cur.getNext().getValue() + "\n";
            }

            cur = cur.getNext();
        }

        return finalString;
    }
}