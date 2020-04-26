import java.util.Random;

public class Producer implements Runnable{
    private final static Random generator = new Random();
    private final Buffer sharedLocation;

    public Producer(Buffer sharedLocation) {
        this.sharedLocation = sharedLocation;
    }

    @Override
    public void run() {
        int sum = 0;

        for(int count = 1; count <= 10; count++)
        {
            try {
                Thread.sleep(generator.nextInt(300));
                sharedLocation.set(count);
                sum += count;
//                System.out.printf("\t\t\t\t%2d\n", sum);
            }

            catch (InterruptedException exc)
            {
                exc.printStackTrace();
            }
        }

        System.out.println("Producer done producing\nTerminating Producer");
    }
}
