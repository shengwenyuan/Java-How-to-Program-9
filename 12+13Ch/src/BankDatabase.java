public class BankDatabase
{
    private Account[] accounts;

    public BankDatabase() {
        accounts = new Account[2];
        accounts[0] = new Account(110302, 12345, 1000.1, 1200.0);
        accounts[1] = new Account(110794, 00000, 200.0, 200.0);
    }

    private Account getAccount(int userNumber)
    {
        for(Account currentAccount : accounts)
        {
            if(currentAccount.getAccountNumber() == userNumber)
                return currentAccount;
        }//end for
        return null;
    }

    public boolean authenticateUser(int userNumber, int userPIN)
    {
        Account userAccount = getAccount(userNumber);

        if(userAccount != null)
            return userAccount.validatePIN(userPIN);
        else
            return false;
    }

    public double getAvailableBalance(int userNumber){
        return getAccount(userNumber).getAvailableBalance();
    }

    public double getTotalBalance(int userNumber){
        return getAccount(userNumber).getTotalBalance();
    }

    public void credit(int userNumber, double amount){
        getAccount(userNumber).credit(amount);
    }

    public void debit(int userNumber, double amount){
        getAccount(userNumber).debit(amount);
    }
}
