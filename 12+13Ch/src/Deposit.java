public class Deposit extends Transaction
{
    private double amount;
    private Keypad keypad;
    private DepositSlot depositSlot;

    private final static int CANCELED = 0;

    public Deposit(int accountNumber, Screen screen, BankDatabase bankDatabase, Keypad keypad, DepositSlot depositSlot) {
        super(accountNumber, screen, bankDatabase);
        this.keypad = keypad;
        this.depositSlot = depositSlot;
    }

    @Override
    public void execute() {
        BankDatabase bankDatabase = getBankDatabase();

        Screen screen = getScreen();

        amount = promptForDepositAmount();

        if(amount == CANCELED)
            screen.displayMessageLine("\nCanceling transaction...");
        else
        {
            screen.displayMessage("\nPlease insert a deposit envelope containing ");
            screen.displayDollarAmount(amount);
            screen.displayMessageLine(".");

            boolean envelopeReceived = depositSlot.isEnvelopeReceived();

            if(envelopeReceived)
            {
                bankDatabase.credit(getAccountNumber(), amount);
                screen.displayMessageLine("\nYour envelope has been received.\nNOTE: The money " +
                        "just deposited will not be available until we verify the amount of any " +
                        "enclosed cash and your checks clear.");
            }
            else
                screen.displayMessageLine("\nYour did not insert an envelope, so the ATM has " +
                        "canceled your transaction.");
        }
    }

    private double promptForDepositAmount()
    {
        Screen screen = getScreen();

        screen.displayMessage("\nPlease enter a deposit amount in CENTS(or 0 to cancel)");
        int input = keypad.getInput();

        if(input == CANCELED)
            return CANCELED;
        else
            return (double) input / 100;
    }
}
