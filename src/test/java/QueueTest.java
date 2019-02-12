import org.junit.Test;

public class QueueTest {

    @Test
    public void test() {
        Queue queue = new Queue();
        queue.enqueue("task");
        queue.enqueue("task");
        queue.enqueue("task");
        queue.enqueue("tibia", 2);
        queue.enqueue("legends", 10);
        queue.enqueue("rohan", 4);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
