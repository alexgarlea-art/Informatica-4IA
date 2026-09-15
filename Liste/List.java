package Liste;
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

    public void insert(ListItem toIns){
        if (this.head == null){
            this.head = toIns;
        }else if (this.head.getValue() > toIns.getValue()){
            toIns.setNext(this.head);
            this.head = toIns;
        }else{
            ListItem cur = this.head.getNext();
            ListItem cur2 = this.head;

            while (cur != null && cur.getValue() < toIns.getValue()  ) {
                cur2 = cur;
                cur = cur.getNext();
            }

            cur2.setNext(toIns);
            toIns.setNext(cur);
        }
    }

    public void remove(ListItem rm){
        if(this.head == null){
            System.out.println("List Empty, nothing to remove.");
        }else if (this.head.getValue() == rm.getValue()) {
            this.head = this.head.getNext();
        }{
            ListItem cur = this.head.getNext();
            ListItem cur2 = this.head;

            while (cur != null && cur.getValue() != rm.getValue()  ) {
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
                    finalString += "Value: " + cur.getValue() + " Next: null" + "\n";
            }else{
                finalString += "Value: " + cur.getValue() + " Next: " + cur.getNext().getValue() + "\n";
            }
                cur = cur.getNext();
            }
            return finalString;
        }
    }
}
