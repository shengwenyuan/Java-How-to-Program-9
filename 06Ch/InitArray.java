public class InitArray
{
    public static void main(String[] args)
    {
        int[] array = { 32, 27, 14, 623, 64, 76, 23, 25, 765, 9 };
        System.out.printf("%s%8s\n", "Index", "Value");
        for(int counter = 0; counter < array.length; counter++)
            System.out.printf("%5d%8d\n", counter, array[counter]);
    }
}