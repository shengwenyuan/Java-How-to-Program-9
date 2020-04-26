import java.util.Random;

public class RollDie
{
    public static void main(String[] args)
    {
        Random randomNumbers = new Random();

        int value1 = 0;
        int value2= 0;
        int value3= 0;
        int value4= 0;
        int value5= 0;
        int value6= 0;
        int face;

        for (int roll = 1; roll <= 6000000; roll++)
        {
            face = 1 + randomNumbers.nextInt(6);

            switch (face)
            {
                case 1:
                    value1 ++;
                    break;

                case 2:
                    value2 ++;
                    break;

                case 3:
                    value3 ++;
                    break;

                case 4:
                    value4 ++;
                    break;

                case 5:
                    value5 ++;
                    break;

                case 6:
                    value6 ++;
                    break;
            }//end switch
        }//end for

        System.out.println("Face\tFrequency");
        System.out.printf("1\t%d\n2\t%d\n3\t%d\n4\t%d\n5\t%d\n6\t%d\n",
            value1, value2, value3, value4, value5, value6);
    }
}