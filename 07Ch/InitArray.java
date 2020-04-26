public class InitArray
{
    public static void main(String[] args)
    {
        int[][] array = { {1, 2}, {3, 4, 5} };
        for(int count = 0; count < array.length; count++)
        {
            for(int column = 0; column < array[count].length; column++)
            {
                System.out.printf("%d ", array[count][column]);
                if(array[count].length == 2 )
                    System.out.println();
            }
        }
    }
}