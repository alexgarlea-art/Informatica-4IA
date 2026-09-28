package Liste.Esercizio;


/*Si vuole creare un programma per gestire la lista della spesa. Ogni elemento della lista delle spesa è costituito da un prodotto e da un genere
 (latticini, carni, dolci, scatolame, ...). La lista della spesa viene riempita alla rinfusa, quindi ogni elemento viene aggiunto in coda alla lista.
 Poi con il metodo sort, la lista viene riordinata, raggruppando i prodotti per generi e mettendoli in ordine per genere e nome prodotto (alfabetico).
Il programma deve quindi permettermi le seguenti operazioni:

    creare una nuova lista eliminando la precedente
    aggiungere un elemento alla lista
    stampare la lista
    eliminare un elemento dalla lista
    riordinare la lista

Consiglio operativo: per realizzare il sorting della lista guardare l'interfaccia Comparable di java
Consiglio operativo 2: chiamare la classe lista OrdinableList e gestirla con i generics*/
public class OrdinableList {
    private Prodotto head;
    private Prodotto tail;

    // Constructor
    protected OrdinableList() {
    }

    // Methods

    /**
     * Adds a new ListItem to the end of the List
     *
     * @param name product to add
     * @param genere genere of the prodotto to add
     */
    protected void add(String name, String genere) {
        if (this.head == null) {
            this.head = new Prodotto(name, genere);
            this.tail = this.head;
        } else if (this.head.getNext() == null) {
            Prodotto newItem = new Prodotto(name,genere);
            this.head.setNext(newItem);
            newItem.setPrev(this.head);
            this.tail = newItem;
        }else {
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
    private String removeHead() {
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
     * @param name of the item to remove
     */
    protected void remove(String name) {
        if (this.isEmpty()) {
            System.out.println(
                    "Lista vuota, impossibile trovare " + name + "."
            );
            return;}else {
            //  Prodotto cur = this.head();

            //TODO: metodo remove per togliere un prodotto dalla lista
        }

        Prodotto cur = this.head;

        while (cur != null && cur.getName() != name) {
            cur = cur.getNext();
        }

        if (cur == null) {
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
    public void clear() {
        if (head == null) {
            System.out.println("The list is empty.");
        } else {
            Prodotto cur = this.head;
            while (cur != null) {
                if (cur.getPrev() != null) {
                    cur.setPrev(null);
                }
                if (cur.getNext() != null) {
                    cur = cur.getNext();
                    cur.getPrev().setNext(null);
                }
            }
            System.out.println("the list is clear.");
        }
    }

    /**
     * Swaps Prodotto a and Prodotto b
     * @param a will swap with b
     * @param b will swap with a
     */
    private void swap(Prodotto a, Prodotto b){
        Prodotto prev = a.getPrev();
        Prodotto next = b.getNext();

        a.setPrev(b);
        b.setPrev(prev);

        a.setNext(next);
        b.setNext(a);

        if(prev != null){
            prev.setNext(b);
        }

        if(next != null){
            a.getNext().setPrev(a);
        }
    }

    public void sort(){
        if (this.head == null){
            System.out.println("List empty, nothing to sort.");
        }else{
            Prodotto cur = this.head;
            Prodotto cur2;

            //Alphabetical order sorting
            while (cur.getNext() != null){
                if (!(cur.compareTo(cur.getNext()) > 0)) {

                    cur = cur.getNext();

                }else{
                    cur2 = cur.getNext();



                    if(cur == this.head) head = cur2;

                    cur = this.head;
                }
            }

            cur = this.head; // reset cur to head

            //Genere sorting
            while (cur.getNext() != null){
                if (cur.getGenere().equals(cur.getNext().getGenere())) {
                    cur = cur.getNext();
                }else{

                }
            }
            this.tail = cur;
        }

    }

@Override
public String toString() {
    if (this.isEmpty()) {
        return "Head: null \nTail: null";
    }

    StringBuilder finalString = new StringBuilder();

    finalString.append("Head: ").append(this.head.getName()).append(", ").append(this.head.getGenere()).append("\n");
    finalString.append("Tail: ").append(this.tail.getName()).append(", ").append(this.tail.getGenere()).append("\n");

    Prodotto cur = this.head;

    while (cur != null) {
        finalString.append(cur);
        cur = cur.getNext();
    }

    return finalString.toString();
}


}