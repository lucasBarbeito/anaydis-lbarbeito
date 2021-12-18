package anaydis.immutable;

import org.junit.Assert;
import org.junit.Test;

public class BankersQueueTest {

    private BankersQueue<Integer> queue = new BankersQueue<>();

    @Test
    public void testQueue(){
        Assert.assertTrue(queue.isEmpty());
        queue = (BankersQueue<Integer>) queue.enqueue(1);
        queue = (BankersQueue<Integer>) queue.enqueue(2);
        queue = (BankersQueue<Integer>) queue.enqueue(3);
        queue = (BankersQueue<Integer>) queue.enqueue(4);

        Assert.assertEquals(1, queue.dequeue().value.longValue());
        Assert.assertEquals(2, queue.dequeue().queue.dequeue().value.longValue());
        Assert.assertEquals(3, queue.dequeue().queue.dequeue().queue.dequeue().value.longValue());
        Assert.assertEquals(4, queue.dequeue().queue.dequeue().queue.dequeue().queue.dequeue().value.longValue());
    }
}
