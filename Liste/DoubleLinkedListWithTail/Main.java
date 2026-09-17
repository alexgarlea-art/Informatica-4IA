package Liste.DoubleLinkedListWithTail;

public class Main {
    public static void main(String[] args) {
        List list = new List();
        list.addHead(1);
        list.addTail(2);
        list.addTail(3);
        list.addTail(4);

        list.insert(100, 67);
        System.out.println(list.toString());
    } 

}
