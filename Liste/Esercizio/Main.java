package Liste.Esercizio;
public class Main {
    public static void main(String[] args){
        OrdinableList list = new OrdinableList();
        list.add("cookies", "sweets");
        list.add("Milk", "dairy");
        list.add("wrench", "mechanics");
        list.add("milkyWay", "sweets");
        list.add("cheese", "dairy");
        list.add("bolt", "mechanics");

        list.sort();

        list.remove("wrench");
        System.out.println(list);

        list.clear();
        System.out.println(list);
    }
}

/*Si vuole creare un programma per gestire la lista della spesa. Ogni elemento della lista delle spesa è costituito da un prodotto e da un genere
(latticini, carni, dolci, scatolame, ...). La lista della spesa viene riempita alla rinfusa, quindi ogni elemento viene aggiunto in coda alla lista. -done
 Poi con il metodo sort, la lista viene riordinata, raggruppando i prodotti per generi e mettendoli in ordine per genere e nome prodotto (alfabetico).
Il programma deve quindi permettermi le seguenti operazioni:

    creare una nuova lista eliminando la precedente
    aggiungere un elemento alla ista
    stampare la lista
    eliminare un elemento dalla lista
    riordinare la lista

Consiglio operativo: per realizzare il sorting della lista guardare l'interfaccia Comparable di java
Consiglio operativo 2: chiamare la classe lista OrdinableList e gestirla con i generics*/
