package Liste.SDDL;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<Integer>();

        queue.enqueue(9);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        System.out.println(queue);

        queue.dequeue();
        System.out.println(queue);

    }
}
