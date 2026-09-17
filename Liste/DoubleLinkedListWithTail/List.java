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
        if(index <= 0){
            this.addHead(value);
        }else if(this.head == null){
            System.out.println("List Empty, impossible to insert in index " + index + ".");
        }else{
            ListItem cur = this.head;
        boolean indexInRange = true;
        for(int i = 0; i < index; i++){
            if(cur.getNext() != null){
                cur = cur.getNext();
            }else{
                this.addTail(value);
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
        
    }   

    public int removeHead(){
        if(this.head == null){
            System.out.println("Nothing to remove, returning -1");
            return -1;
        }else if(this.head.getNext() == null){
            int headValue = this.head.getValue();
            this.head = null;
            this.tail = null;
            return headValue;
        }else{
            int headValue = this.head.getValue();
            this.head = this.head.getNext();
            this.head.setPrev(null);
            return headValue;
        }
        
    }

    public int removeTail(){
        if(this.tail == null){
            System.out.println("Nothing to remove, returning -1");
            return -1;
        }else if(this.tail.getPrev() == null){
            int tailValue = this.tail.getValue();
            this.tail = null;
            this.head = null;
            return tailValue;
        }else{
            int tailValue = this.tail.getValue();
            this.tail = this.tail.getPrev();
            this.tail.setNext(null);
            return tailValue;
        }
    }

    public void remove(int index){
      if(index <= 0){
            this.removeHead();
        }else if(this.head == null){
            System.out.println("List Empty, impossible to insert in index " + index + ".");
        }else{
            ListItem cur = this.head;
        boolean indexInRange = true;
        for(int i = 0; i < index; i++){
            if(cur.getNext() != null){
                cur = cur.getNext();
            }else{
                this.removeTail();
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
    }

    @Override 
    public String toString(){
        if(this.head == null){
            return "Head: null \nTail: null";
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