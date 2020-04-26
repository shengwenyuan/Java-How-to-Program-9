public class Comparison
{
    public static void main( String[] args )
    {
        Scanner input = new Scanner(System.in);

        int number1, number2;

        System.out.print("Enter first integer:");
        number1 = input.nextInt();
        
        System.out.print("Enter second integer:");
        number2 = input.nextInt();

        if(number1 == number2)
            System.out.printf("yi yang da!");
        
        if(number1 < number2)
            System.out.printf("di 2 ge da");

        if(number1 > number2)
            System.out.printf("di 1 ge da");
    }
}