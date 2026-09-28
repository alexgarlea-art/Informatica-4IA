package Liste.Esercizio;

public class OrdinableList<T> {
    private Prodotto head;
    private Prodotto tail;

    // Constructor
    protected OrdinableList() {
    }

    // Methods

    /**
     * Adds a new ListItem to the end of the List
     *
     * @param value value to add
     */
    protected void add(String name, String genere) {
        if (this.head == null) {
            this.head = new Prodotto(name, genere);
            this.tail = this.head;
        } else {
            Prodotto newItem = new Prodotto(name, genere);

            this.tail.setNext(newItem);
            newItem.setPrev(this.tail);

            this.tail = newItem;
        }
    }

    /**
     * Checks if the list is empty
     *
     * @return true if the list is empty, false otherwise
     */
    private boolean isEmpty() {
        return this.head == null;
    }

    /**
     * Removes and returns the first item in the list.
     *
     * @return removed value, or -1 if the list is empty
     */
    protected String removeHead() {
        if (this.head == null) {
            System.out.println("Nothing to remove, returning null");
            return null;
        }

        String headName = this.head.getName();

        if (this.head.getNext() == null) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.getNext();
            this.head.setPrev(null);
        }

        return headName;
    }

    /**
     * Removes and returns the last item in the list.
     *
     * @return removed value or -1 if the list is empty
     */
    protected String removeTail() {
        if (this.tail == null) {
            System.out.println("Nothing to remove, returning null");
            return null;
        }

        String tailName = this.tail.getName();

        if (this.tail.getPrev() == null) {
            this.head = null;
            this.tail = null;
        } else {
            this.tail = this.tail.getPrev();
            this.tail.setNext(null);
        }

        return tailName;
    }

    /**
     * Removes the item at index.
     *
     * @param index of the item to remove
     */
    protected void remove(String name) {
        if (this.isEmpty()) {
            System.out.println(
                "Lista vuota, impossibile trovare " + name + "." 
            );
            return;
        }

        Prodotto cur = this.head;

        while (cur != null && cur.getName() != name) {
            cur = cur.getNext();
        }
        
        if(cur == null){
            System.out.println("Prodotto " + name + " non trovato.");
            return;
        }
        
        if (cur == this.tail) {
        this.removeTail();
        return;
        }

        Prodotto previous = cur.getPrev();
        Prodotto next = cur.getNext();
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
            Prodotto cur = this.head;
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

    @Override
    public String toString() {
        if (this.isEmpty()) {
            return "Head: null \nTail: null";
        }

        String finalString = "";

        finalString += "Head: " + this.head.getName() + ", " + this.head.getGenere() + "\n";
        finalString += "Tail: " + this.tail.getName() + ", " + this.tail.getGenere() + "\n";

        Prodotto cur = this.head;

        while (cur != null) {
            finalString += cur.toString();
            cur = cur.getNext();
        }

        return finalString;
    }

    
}