import java.io.File;
import java.io.FileNotFoundException;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.file.account.AccountRecord;

public class CreditInquiry
{
    private MenuOption accountType;
    private Scanner input;
    private final static MenuOption[] choices = {MenuOption.ZERO_BALANCE,
            MenuOption.CREDIT_BALANCE, MenuOption.DEBIT_BALANCE, MenuOption.END};
}
