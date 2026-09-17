package Liste.DLList;


public class Main {

    public static void main(String[] args) {

        List list = new List();

        // Caso critico: lista vuota
        System.out.println(list.isEmpty());

        list.add(10);
        list.add(20);
        list.add(30);

        System.out.println(list);
        System.out.println("Size: " + list.size());

        // Caso critico: inserimento in testa
        list.insert(5);

        // Inserimento in mezzo
        list.insert(15);

        System.out.println(list);

        // Caso critico: rimozione della testa
        list.remove(5);

        // Caso critico: rimozione di un elemento non presente
        list.remove(100);

        //caso critico: rimozione di un elemento in coda
        list.remove(30);
        System.out.println(list);
    }
}