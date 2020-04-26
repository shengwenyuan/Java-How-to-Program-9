import com.deitel.jhtp.ch08.Time1;

public class Time1Test
{
    public static void main(String[] args)
    {
        Time1 time = new Time1();

        System.out.println( time.toUniversalString() );
        System.out.println( time.toString() );

        time.setTime(10, 44, 38);
        System.out.println( time.toUniversalString() );
        System.out.println( time.toString() );

        try{
            time.setTime(99, 99, 99);
        }
        catch(IllegalArgumentException e)
        {
            System.out.printf("Exception:%s\n\n", e.getMessage());
        }
    }
}