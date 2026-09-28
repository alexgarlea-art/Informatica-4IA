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
            this.head.getNext().setPrev(this.head);
        }else{
            ListItem cur = this.head/* .getNext()*/;
            //ListItem cur2 = this.head;

        while(cur.getNext() != null){
            cur = cur.getNext();
        }

        cur.setNext(new ListItem(value));
        cur.getNext().setPrev(cur);

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
            ListItem cur = this.head;

            this.head = new ListItem(value);
            this.head.setNext(cur);
            this.head.getNext().setPrev(this.head);
        }else{
            ListItem cur = this.head;
            
            while (cur.getNext() != null && cur.getNext().getValue() < value ) {
                cur = cur.getNext();
            }

            if(cur.getNext() != null){
                cur.getNext().setPrev(new ListItem(value));
                cur.getNext().getPrev().setNext(cur.getNext());
                cur.setNext(cur.getNext().getPrev());
                cur.getNext().setPrev(cur);
            }else{
                cur.setNext(new ListItem(value));
                cur.getNext().setPrev(cur);
            }
        }
    }

    public void remove(int value){
        if(this.head == null){
            System.out.println("List Empty, nothing to remove.");
        }else if (this.head.getValue() == value) {
            if(this.head.getNext() == null){
                this.head = null;
            }else{
                this.head = this.head.getNext();
                this.head.setPrev(null);
            }
        }else{
            ListItem cur = this.head;

            while (cur != null && cur.getValue() != value)  {
                cur = cur.getNext();
            }

            if(cur != null){
                if(cur.getNext() != null){
                    cur.getPrev().setNext(cur.getNext());
                    cur.getNext().setPrev(cur.getPrev());
                    cur.setPrev(null);
                    cur.setNext(null);
                }else{
                    cur.getPrev().setNext(null);
                    cur.setPrev(null);
                }
            }else{
                System.out.println("Value not found, nothing to remove.");
            }

        }
    }
    
    public void clear(){
        if(head == null){
            System.out.println("The list is empty.");
        }else{
            ListItem cur = this.head;
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