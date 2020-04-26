import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class SharedArray_test
{
    public static void main(String[] args) {
        SimpleArray sharedSimpleArray = new SimpleArray(6);

        ArrayWriter writer1 = new ArrayWriter(sharedSimpleArray, 1);
        ArrayWriter writer2 = new ArrayWriter(sharedSimpleArray, 11);

        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(writer1);
        executor.execute(writer2);

        executor.shutdown();

        try {
            boolean tasksEnded = executor.awaitTermination(1, TimeUnit.MINUTES);

            if(tasksEnded)
                System.out.println(sharedSimpleArray);
            else
                System.out.println("Timed out while waiting for tasks to finish.");
        }

        catch (InterruptedException ex)
        {
            System.out.println("Interrupted ");
        }
    }
}
