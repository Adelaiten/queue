import exceptions.TooSmallPriorityException;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {


    @Test
    public void testIfDequeueReturnsGoodValue() {
        Queue queue = new Queue();
        queue.enqueue("task");//1
        queue.enqueue("task");//2
        queue.enqueue("task");//3
//        System.out.println(queue.getQueueSize());
        assertAll(
                () -> assertEquals("task", queue.dequeue()),//2
                () -> assertEquals("task", queue.dequeue()),//1
                () -> assertEquals("task", queue.dequeue())//0
        );

    }


    @Test
    public void testIfDequeueReturnsGoodValueWithPriority() throws TooSmallPriorityException{
        Queue queue = new Queue();
        queue.enqueue("task");
        queue.enqueue("task");
        queue.enqueue("task");
        queue.enqueue("tibia", 2);
        queue.enqueue("legends", 10);
        queue.enqueue("rohan", 4);



        assertAll(
                () -> assertEquals("legends", queue.dequeue()),
                () -> assertEquals("rohan", queue.dequeue()),
                () -> assertEquals("tibia", queue.dequeue()),
                () -> assertEquals("task", queue.dequeue()),
                () -> assertEquals("task", queue.dequeue())

        );
    }

    @Test
    public void testIfPeekReturnsAlwaysTheSameValue() {
        Queue queue = new Queue();
        queue.enqueue("task");
        queue.enqueue("test");
        assertAll(
                () -> assertEquals("task", queue.peek()),
                () -> assertEquals("task", queue.peek())
        );
    }


}
