public class Interest
{
    public static void main(String[] args)
    {
        double amount = 1000.0, principal = 1000.0, rate = 0.05;

        System.out.printf("%s%20s\n", "Year", "Amount on deposit");

        for(int year = 1; year <= 10; year++)
        {
            amount = amount * 1.05;

            System.out.printf("%4d%,20.2f\n", year, amount);
        }
    }
}