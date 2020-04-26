import java.util.Arrays;
import java.util.Random;

public class SimpleArray
{
    private final int[] array;
    private int writeIndex = 0;
    private final static Random generator = new Random();

    public SimpleArray(int size) {
        array = new int[size];
    }

    public synchronized void add(int value)
    {
        int position = writeIndex;
        try
        {
            Thread.sleep(generator.nextInt(500));
//            position = writeIndex;
        }
        catch (InterruptedException exc)
        {
            exc.printStackTrace();
        }

        array[position] = value;
        System.out.printf("%s wrote %2d to element %d.\n", Thread.currentThread().getName(),
                value, position);

        ++writeIndex;
//        writeIndex=writeIndex+1;
        System.out.printf("Next write index: %d\n\n", writeIndex);
    }

    public String toString()
    {
        return "\nContents of SimpleArray:\n" + Arrays.toString(array);
    }
}
