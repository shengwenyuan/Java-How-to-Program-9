import java.util.concurrent.ArrayBlockingQueue;

public class BlockingBuffer implements Buffer
{
    private final ArrayBlockingQueue<Integer> buffer;

    public BlockingBuffer() {
        buffer = new ArrayBlockingQueue<Integer>(1);
    }

    public void set(int value) throws InterruptedException
    {
        buffer.put(value);
        System.out.printf("Producer writes\t%2d\t\t%s%d\n", value, "Buffer cells occupied: ",
                buffer.size());
    }

    @Override
    public int get() throws InterruptedException
    {
        int readValue = buffer.take();
        System.out.printf("Consumer reads\t%2d\t\t%s%d\n", readValue, "Buffer cells occupied: ",
                buffer.size());
        return readValue;
    }
}
