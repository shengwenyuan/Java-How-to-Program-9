import java.util.Random;

public class Consumer implements Runnable
{
    private final static Random generator = new Random();
    private final Buffer sharedLocation;

    public Consumer(Buffer sharedLocation) {
        this.sharedLocation = sharedLocation;
    }

    @Override
    public void run() {
        int sum = 0;

        for(int count = 1; count <= 10; count++)
        {
            try {
                Thread.sleep(generator.nextInt(300));
                sum += sharedLocation.get();
//                System.out.printf("\t\t\t\t\t\t\t%2d\n", sum);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("\nConsumer read values totaling %d\n%s\n", sum, "Terminating Consumer");
    }
}
