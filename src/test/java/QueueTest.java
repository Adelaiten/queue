import exceptions.EmptyQueueException;
import exceptions.TooSmallPriorityException;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class QueueTest {


    @Test
    public void checkIfDequeueReturnsGoodValue() throws TooSmallPriorityException {
        Queue queue = new Queue();
        queue.enqueue("task");
        queue.enqueue("task");
        queue.enqueue("task");
        
    }
    @Test
    public void checkIfDequeueReturnsGoodValueWithPriority() throws TooSmallPriorityException{
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
                () -> assertEquals("tibia", queue.dequeue()));
    }
}
