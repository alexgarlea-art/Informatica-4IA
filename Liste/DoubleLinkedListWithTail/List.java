package Liste.DoubleLinkedListWithTail;

public class List {
    private ListItem head;
    private ListItem tail;

    //Constructor
    public List(){
    }

    //Methods
    /**
     * Adds a new ListItem to the existing List
     * @param value
     */
    public void addTail(int value){
        if(this.head == null){

            this.head = new ListItem(value);
            this.tail = this.head;

        }else{

        this.tail.setNext(new ListItem(value));
        this.tail.getNext().setPrev(this.tail);
        this.tail = this.tail.getNext();

        }
       
    }

    /**
     * Makes value the new head, adding it to the top of the list
     * @param value ListItem to add
     */
    public void addHead(int value){
        if(this.head == null){
            this.head = new ListItem(value);
            this.tail = this.head;
        }else{
            ListItem cur = new ListItem(value);
            this.head.setPrev(cur);
            cur.setNext(this.head);
            this.head = cur;
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

    /**
     * inserts value to pos index in the list
     * @param index idex where to insert value
     * @param value the value to add
     */
    public void insert(int index, int value){
        ListItem cur = this.head;
        boolean indexInRange = true;
        for(int i = 0; i < index; i++){
            if(cur.getNext() != null){
                cur = cur.getNext();
            }else{
                indexInRange = false;
                System.out.println("Index " + index + " out of list bounds.");
                break;
            }
        }
        if(indexInRange){
            cur.getPrev().setNext(new ListItem(value));
            cur.getPrev().getNext().setNext(cur);
            cur.getPrev().setPrev(cur.getPrev());
            cur.getPrev().getNext().setPrev(cur.getPrev());
            cur.setPrev(cur.getPrev().getNext());
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

    @Override 
    public String toString(){
        if(this.head == null){
            return "The list is Empty";
        }else{

            String finalString = "";
            ListItem cur = head;

            if(this.head != null){
                finalString += "Head: " + this.head.getValue() + "\n";
            }else{
                finalString += "Head: null" + "\n";
            }

            if (this.tail != null) {
                finalString += "Tail: " + this.tail.getValue() + "\n";
            }else{
                finalString += "Tail: null" + "\n";
            }
            
            

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