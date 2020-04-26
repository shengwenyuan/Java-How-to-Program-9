import java.util.Scanner;
public class haha
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter:");
        String sentence = scanner.nextLine();

        if(validateInput(sentence))
            System.out.printf("true!");
        else
            System.out.printf("false!");
    }

    public static boolean validateInput(String words)
    {
        return words.matches("\\w[-\\w.+]*@([A-Za-z0-9][A-Za-z0-9]+\\.)+[A-Za-z]{2,14}");
    }
}
