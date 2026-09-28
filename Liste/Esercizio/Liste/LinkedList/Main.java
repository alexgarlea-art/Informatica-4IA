package Liste.LinkedList;


public class Main {

    public static void main(String[] args) {

        List list = new List();

        // CASO CRITICO: lista vuota
        System.out.println("Lista vuota: " + list.isEmpty());
        System.out.println("Size: " + list.size());

        // CASO CRITICO: aggiunta del primo elemento
        list.add(10);
        list.add(20);
        list.add(30);

        System.out.println("\nDopo add:");
        System.out.println(list);
        System.out.println("Size: " + list.size());

        // CASO CRITICO: inserimento in testa
        list.insert(5);

        // Inserimento in mezzo
        list.insert(15);

        // Inserimento in coda
        list.insert(40);

        System.out.println("\nDopo insert:");
        System.out.println(list);

        // CASO CRITICO: rimozione della testa
        list.remove(5);

        // Rimozione di un elemento in mezzo
        list.remove(20);

        // CASO CRITICO: rimozione di un elemento inesistente
        list.remove(100);

        System.out.println("\nDopo remove:");
        System.out.println(list);

        // CASO CRITICO: rimozione dell'ultimo elemento rimasto
        List singleList = new List();
        singleList.add(50);
        singleList.remove(50);

        System.out.println("Lista con unico elemento dopo remove:");
        System.out.println(singleList);
        System.out.println("Lista vuota: " + singleList.isEmpty());
    }
}