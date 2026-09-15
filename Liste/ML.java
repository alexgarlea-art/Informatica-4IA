package Liste;

public class ML {
    public static void main(String[] args) {
        List list = new List();

        list.add(0);
        list.add(5);
        list.add(6);
        list.add(7);

        list.insert(new ListItem(8));

        list.remove(new ListItem(8));

        System.out.println(list.toString());
        System.out.println(list.size());
    }
}
