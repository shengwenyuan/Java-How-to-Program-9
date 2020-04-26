public class ArrayWriter implements Runnable
{
    private final SimpleArray sharedSimpleArray;
    private final int startValue;

    public ArrayWriter(SimpleArray sharedSimpleArray, int startValue) {
        this.sharedSimpleArray = sharedSimpleArray;
        this.startValue = startValue;
    }

    public void run()
    {
        for(int i = startValue; i < startValue + 3; i++)
        {
            sharedSimpleArray.add(i);
        }
    }
}
