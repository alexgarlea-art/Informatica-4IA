package Liste.Esercizio;

public class Main {
    public static void main(String[] args) {
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

        OrdinableList<Prodotto> list = new OrdinableList<>();
        list.add("banana", "frutto");
        list.add("carota", "verdura");
        System.out.println(list);
    }
}
