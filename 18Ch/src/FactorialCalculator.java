import java.math.BigInteger;

public class FactorialCalculator
{
    public static BigInteger factorial(BigInteger number)
    {
        if(number.compareTo(BigInteger.ONE) <= 0)
            return BigInteger.ONE;
        else
            return number.multiply(factorial(number.subtract(BigInteger.ONE)));
    }

    public static void main(String[] args) {
        for(int count = 0; count <= 50; count++)
            System.out.printf("%d! = %d\n", count, factorial(BigInteger.valueOf(count)));
    }
}
