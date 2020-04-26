import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.file.account.AccountRecordSerializable;

public class CreateSequentialFile
{
    private ObjectOutputStream output;

    public void openFile()
    {
        try
        {
            output = new ObjectOutputStream(new FileOutputStream("clients.out"));
        }
        catch (IOException ioException)
        {
            System.out.println("Error opening file.");
        }
    }

    public void addRecords()
    {
        AccountRecordSerializable record;

        int accountNumber = 0;
        String firstName;
        String lastName;
        double balance;

        Scanner input = new Scanner(System.in);
        System.out.printf("Enter <ctrl>+d to exit.\n");

        System.out.printf("Enter account number(>0), first&last name, and balance.\n? ");

        while (input.hasNext())
        {
            try {
                accountNumber = input.nextInt();
                firstName = input.next();
                lastName = input.next();
                balance = input.nextDouble();

                if(accountNumber > 0)
                {
                    record = new AccountRecordSerializable(accountNumber, firstName, lastName,
                            balance);
                    output.writeObject(record);
                }
                else
                    System.out.println("Account number must be greater than 0.");
            }
            catch (IOException ioException)
            {
                System.err.println("Error writing in file");
                return;
            }
            catch (NoSuchElementException elementException)
            {
                System.err.println("Invalid input!");
            }

            System.out.printf("Enter account number(>0), first&last name, and balance.\n? ");
        }
    }

    public void closeFile()
    {
        try
        {
            if(output != null)
                output.close();
        }
        catch (IOException ioException)
        {
            System.err.println("Error closing file!");
            System.exit(1);
        }
    }
}
