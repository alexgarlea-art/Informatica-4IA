package Liste.Esercizio;

import java.util.Locale;

public class Prodotto implements Comparable<Prodotto> {
     /*
    Si vuole creare un programma per gestire la lista della spesa. Ogni elemento della lista delle spesa è costituito da un prodotto e da un genere (latticini, carni, dolci, scatolame,...).
    La lista della spesa viene riempita alla rinfusa, quindi ogni elemento viene aggiunto in coda alla lista.
    Poi con il metodo sort, la lista viene riordinata, raggruppando i prodotti per generi e mettendoli in ordine per genere e nome prodotto (alfabetico).

    Il programma deve quindi permettermi le seguenti operazioni:

    creare una nuova lista eliminando la precedente
    aggiungere un elemento alla ista
    stampare la lista
    eliminare un elemento dalla lista
    riordinare la lista

    Consiglio operativo: per realizzare il sorting della lista guardare l'interfaccia Comparable di java
    Consiglio operativo 2: chiamare la classe lista OrdinableList e gestirla con i generics */

    //Attributi
    private final String name;
    private final String genere;
    private Prodotto prev;
    private Prodotto next;
    //Metodi

    /**
     * Crea un nuovo Prodotto
     *
     * @param name   nome del prodotto
     * @param genere genere del prodotto
     */
    public Prodotto(String name, String genere) {
        this.name = name;
        this.genere = genere;
    }

    public String getName() {
        return this.name;
    }

    public String getGenere() {
        return this.genere;
    }

    public Prodotto getPrev() {
        return this.prev;
    }

    public void setPrev(Prodotto p) {
        this.prev = p;
    }

    public Prodotto getNext() {
        return this.next;
    }

    public void setNext(Prodotto p) {
        this.next = p;
    }

    private String getProduct() {
        return "(" + this.name + ": " + this.genere + ")";
    }

    @Override
    public int compareTo(Prodotto o) {
        if (o != null) {
            if (this.getName().toLowerCase().charAt(0) == o.getName().toLowerCase().charAt(0)) {
                return 0;
            } else if (this.getName().charAt(0) < o.getName().charAt(0)) {
                return -1;
            } else return 1;
        } else return 0;
    }


    @Override
public String toString() {
    if(this.getNext() == null){
        if(this.getPrev() == null){
            return String.format(
                "Prev: %-25s Value: %-25s Next: %-25s%n", // %...s = String, - = align left, 25 = n of characters to reserve for each %s
                "null",
                this.getProduct(),
                "null"
            );
        }else{
            return String.format(
                "Prev: %-25s Value: %-25s Next: %-25s%n",
                this.getPrev().getProduct(),
                this.getProduct(),
               "null"
            );
        }
    }else if(this.getPrev() == null){
        return String.format(
            "Prev: %-25s Value: %-25s Next: %-25s%n",
            "null",
            this.getProduct(),
            this.getNext().getProduct()
        );
    }else{
        return String.format(
            "Prev: %-25s Value: %-25s Next: %-25s%n",
            this.getPrev().getProduct(),
            this.getProduct(),
            this.getNext().getProduct()
        );
    }
}
}
