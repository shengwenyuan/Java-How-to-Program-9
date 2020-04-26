public class Withdrawal extends Transaction
{
    private int amount;
    private Keypad keypad;
    private CashDispenser cashDispenser;

    private final static int CANCELED = 6;

    public Withdrawal(int accountNumber, Screen screen, BankDatabase bankDatabase, Keypad keypad, CashDispenser cashDispenser) {
        super(accountNumber, screen, bankDatabase);
        this.keypad = keypad;
        this.cashDispenser = cashDispenser;
    }

    @Override
    public void execute() {
        boolean cashDispensed = false;
        double availableBalance;

        BankDatabase bankDatabase = getBankDatabase();
        Screen screen = getScreen();

        do {
            amount = displayMenuOfAmounts();

            if(amount == CANCELED)
            {
                screen.displayMessageLine("\nCanceling transaction...");
                return;
            }
            else
            {
                availableBalance = bankDatabase.getAvailableBalance(getAccountNumber());
                if(amount <= availableBalance)
                {
                    if(this.cashDispenser.isSufficientCashAvailable(amount)) {
                        bankDatabase.debit(getAccountNumber(), amount);
                        cashDispensed = true;
                        screen.displayMessageLine("\nYour cash has been dispensed. Please take " +
                                "your cash now.");
                    }
                    else    //取款机余额不足
                        screen.displayMessageLine("\nInsufficient cash available in the ATM" +
                                ".\n\nPlease choose a smaller amount.");
                }
                else    //用户存款不足
                    screen.displayMessageLine("\nInsufficient funds in your account.\n\nPlease " +
                            "choose a smaller amount.");
            }
        }while (!cashDispensed);
    }

    private int displayMenuOfAmounts()
    {
        int userChoice = 0;
        Screen screen = getScreen();
        int[] withdraw = {0, 20, 40, 60, 100, 200};

        while (userChoice == 0)
        {
            screen.displayMessageLine("\nWithdrawal Menu:");
            screen.displayMessageLine("1 - $20");
            screen.displayMessageLine("2 - $40");
            screen.displayMessageLine("3 - $60");
            screen.displayMessageLine("4 - $100");
            screen.displayMessageLine("5 - $200");
            screen.displayMessageLine("6 - Cancel transaction");
            screen.displayMessageLine("\nChoose a withdrawal amount: ");

            int input = keypad.getInput();

            switch (input)
            {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    userChoice = withdraw[input];
                    break;
                case CANCELED:
                    userChoice = CANCELED;
                    break;
                default:
                    screen.displayMessageLine("\nInvalid selection. Try again.");
            }
        }

        return userChoice;
    }
}
