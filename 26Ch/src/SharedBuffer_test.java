import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SharedBuffer_test
{
    public static void main(String[] args) {
        ExecutorService application = Executors.newCachedThreadPool();

        Buffer sharedLocation = new BlockingBuffer();
//        Buffer sharedLocation = new UnsynchronizedBuffer();

//        System.out.println("Action\t\t\tValue\tSum of Produced\t\tSum of Consumed");
        System.out.println("");

        application.execute(new Producer(sharedLocation));
        application.execute(new Consumer(sharedLocation));

        application.shutdown();
    }
}
