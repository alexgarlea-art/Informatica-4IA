package Liste.DoubleLinkedListWithTail;

public class Main {
    public static void main(String[] args) {
        List list = new List();
        list.addTail(0);
        //list.addTail(1);
        //list.addTail(2);
        //list.addTail(3);

        list.removeHead();

        System.out.println(list.toString());
    } 

}
