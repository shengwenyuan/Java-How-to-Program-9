public class StudentPoll
{
    public static void main(String[] args)
    {
        int[] responses = {1, 2, 3, 4, 5, 4, 4, 4, 2, 17};
        int[] frequency = new int[6];

        for(int answer = 0; answer < responses.length; answer++)
        {
            try
            {
                ++frequency[ responses[answer] ];
            }
            catch ( ArrayIndexOutOfBoundsException e )
            {
                System.out.println( e );
                System.out.printf(" responses[%d] = %d\n\n", answer+1, responses[answer]);
            }
        }//end for

    }
}