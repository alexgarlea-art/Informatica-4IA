package Liste.DLList;

public class List {
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
        }else if (this.head.getNext() == null) {
            this.head.setNext(new ListItem(value));
        }else{
            ListItem cur = this.head.getNext();
            ListItem cur2 = this.head;

        while(cur.getNext() != null){
            cur2 = cur;
            cur = cur.getNext();
        }

        cur.setNext(new ListItem(value));
        cur.getNext().setPrev(cur2);

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
        if(this.head == null){
            return 0;
        }else{
            int index = 1;
            ListItem cur = this.head;
        while(cur.getNext() != null){
            index++;
            cur = cur.getNext();
        }
        return index;
        }
    }

    public void insert(int value){
        if (this.head == null){
            this.head = new ListItem(value);
        }else if (this.head.getValue() > value){
            ListItem tempHead = this.head;
            this.head = new ListItem(value);
            this.head.setNext(tempHead);
        }else{
            ListItem cur = this.head;
            ListItem cur2 = this.head;
            while (cur != null && cur.getValue() < value ) {
                cur = cur.getNext();
            }

            cur.getPrev().setNext(new ListItem(value));
            cur.getPrev().getNext().setNext(cur);
            cur.getPrev().getNext().setPrev(cur.getPrev());
            cur.setPrev(cur.getPrev().getNext());

        }
    }

    public void remove(int value){
        if(this.head == null){
            System.out.println("List Empty, nothing to remove.");
        }else if (this.head.getValue() == value) {
            this.head = this.head.getNext();
        }{
            ListItem cur = this.head.getNext();
            ListItem cur2 = this.head;

            while (cur != null && cur.getValue() != value)  {
                cur2 = cur;
                cur = cur.getNext();
            }

            cur2.setNext(cur.getNext());
        }
    }

    @Override 
    public String toString(){
        if(this.head == null){
            return "The list is Empty";
        }else{
            String finalString = "";
            ListItem cur = head;
            while(cur != null){

                if(cur.getNext() == null){
                    if(cur.getPrev() == null){
                        finalString += "Prev: null " + " Value: " + cur.getValue() + " Next: null" + "\n";
                    }else{
                        finalString += "Prev: " + cur.getPrev().getValue() + " Value: " + cur.getValue() + " Next: null" + "\n";
                    }

                }else if (cur.getPrev() == null) {
                    finalString += "Prev: null " + " Value: " + cur.getValue() + " Next: " + cur.getNext().getValue() + "\n";

                }else{
                finalString += "Prev: " + cur.getPrev().getValue() + " Value: " + cur.getValue() + " Next: " + cur.getNext().getValue() + "\n";
                }

                cur = cur.getNext();
            }
            return finalString;
        }

    }
}

