package Liste.LinkedList;
public class List {
    //Attributes
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
        }else{
            ListItem cur = this.head;
        while(cur.getNext() != null){
            cur = cur.getNext();
        }
        cur.setNext(new ListItem(value));
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
            ListItem cur = this.head.getNext();
            ListItem cur2 = this.head;

            while (cur != null && cur.getValue() < value ) {
                cur2 = cur;
                cur = cur.getNext();
            }

            cur2.setNext(new ListItem(value));
            cur2 = cur2.getNext();
            cur2.setNext(cur);
        }
    }

    public void remove(int value){
        if(this.head == null){
            System.out.println("List Empty, nothing to remove.");
        }else if (this.head.getValue() == value) {
            this.head = this.head.getNext();
        }else{
            ListItem cur = this.head.getNext();
            ListItem cur2 = this.head;

            while (cur != null && cur.getValue() != value)  {
                cur2 = cur;
                cur = cur.getNext();
            }
            if(cur != null){
                cur2.setNext(cur.getNext());
            }else{
                System.out.println("Value not found, nothing to remove.");
            }
            
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
                finalString += cur.toString();
                cur = cur.getNext();
            }
            return finalString;
        }
    }
}