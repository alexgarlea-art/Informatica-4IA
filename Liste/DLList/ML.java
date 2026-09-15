package Liste.DLList;

public class ML {
    public static void main(String[] args) {
        List list = new List();

        list.add(0);
        list.add(1);
        list.add(2);
        list.add(5);

        list.insert(-1);
        list.insert(3);
        list.insert(6);

       System.out.println(list.toString());
    }
}
