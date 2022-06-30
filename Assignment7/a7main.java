//For random number generation
import java.util.concurrent.ThreadLocalRandom;

/**This class serves to demonstrate the BankAccount and SavingsAccount classes,
per the assignment instructions. It instantiates a SavingsAccount object with
a random starting balance and annual interest rate, then makes a predetermined
number of random account transactions with random monetary amounts. At the end
of the simulated month, the status of the account is provided for the user.*/
class a7main
{
    //The number of random transactions to be performed
    private static final int NUMBER_OF_TRANSACTIONS = 10;
    //The maximum randomized starting balance for the account
    private static final double MAX_STARTING_BALANCE = 20000.0;
    //The minimum randomized starting balance for the account
    private static final double MIN_STARTING_BALANCE = 5.0;
    //The maximum randomized annual interest rate for the account
    private static final double MAX_ANNUAL_INTEREST_RATE = .25;
    //The maximum randomized monetary amount for an account transaction
    private static final double MAX_TRANSACTION_AMOUNT = 10000.0;

    /**Main method.*/
    public static void main(String[] args)
    {
      /*Instantiate SavingsAccount object with random starting balance and
      annual interest rate*/
      SavingsAccount account = generateAccount();
      //Perform predetermined number of account transactions
      for(int i = 0; i < NUMBER_OF_TRANSACTIONS; i++)
      {
        makeTransaction(account);
      }
      //End the simulated month, and display account status to user
      endMonth(account);
    }

    /**Helper method to generate a SavingsAccount object with a random starting
    balance and annual interest rate. The method rounds the values to the
    appropriate decimal places for each. The initial account status is displayed
    for the user.
    @return The instantiated SavingsAccount object.*/
    private static SavingsAccount generateAccount()
    {
      //Generate random starting balance
      double startingBalance =
        ThreadLocalRandom.current().nextDouble(MIN_STARTING_BALANCE,
          MAX_STARTING_BALANCE);
      startingBalance = ((int)(startingBalance * 100)) / 100.0;
      //Generate random annual interest rate
      double annualInterestRate =
        ThreadLocalRandom.current().nextDouble(MAX_ANNUAL_INTEREST_RATE);
      annualInterestRate = ((int)(annualInterestRate * 1000)) / 1000.0;
      //Instantiate SavingsAccount object
      SavingsAccount account = null;
      try
      {
        account = new SavingsAccount(startingBalance, annualInterestRate);
      }
      catch(Exception e)
      {
        e.printStackTrace();
        System.exit(1);
      }
      //Display account information
      System.out.printf("A new savings account has been opened. The starting "
        + "balance is $%.2f, and the annual interest rate is %.3f.\n\n"
        , account.getBalance(), account.getAnnualInterestRate());
      return account;
    }

    /**Helper method the generate random account transactions. It determines a
    random monetary amount for the transaction, and then randomnly determines
    whether a deposit or a withdrawal is to be performed, calling the necessary
    method to perform it.
    @param account The savings account in which the transactions are to be
    performed.*/
    private static void makeTransaction(SavingsAccount account)
    {
      //Generate random monetary amount and round it
      double amount =
        ThreadLocalRandom.current().nextDouble(MAX_TRANSACTION_AMOUNT);
      amount = ((int)(amount * 100)) / 100.0;
      //Randomnly determine which transaction to perform
      if(getRandomBoolean())
      {
        //Make a deposit
        makeDeposit(account, amount);
      }
      else
      {
        //Make a withdrawal
        makeWithdrawal(account, amount);
      }
    }

    /**Helper method to return a random boolean value.
    @return A random boolean value.*/
    private static boolean getRandomBoolean()
    {
      int flag = ThreadLocalRandom.current().nextInt(2);
      if(flag == 0)
      {
        return true;
      }
      else
      {
        return false;
      }
    }

    /**Helper method to make a deposit. It contains logic to correctly format
    and display the results of the deposit.
    @param account The savings account in which to make the deposit.
    @param amount The amount to deposit in the account.*/
    private static void makeDeposit(SavingsAccount account, double amount)
    {
      System.out.printf("Attempting to deposit $%.2f... ", amount);
      try
      {
        account.deposit(amount);
        System.out.printf("Deposit successful. Account balance is now $%.2f.\n"
          ,account.getBalance());
      }
      catch(Exception e)
      {
        System.out.printf("Deposit unsuccessful. Account balance remains " +
          "$%.2f.\n.", account.getBalance());
        //Log the error
      }
    }

    /**Helper method to make a withdrawal. It contains logic to correctly format
    and display the results of the withdrawal.
    @param account The savings account from which to make the withdrawal.
    @param amount The amount to withdraw from the account.*/
    private static void makeWithdrawal(SavingsAccount account, double amount)
    {
      System.out.printf("Attempting to withdraw $%.2f... ", amount);
      try
      {
        account.withdraw(amount);
        System.out.printf("Withdrawal successful. Account balance is now " +
          "$%.2f.\n", account.getBalance());
      }
      catch(Exception e)
      {
        System.out.printf("Withdrawal unsuccessful. Account balance remains " +
          "$%.2f\n", account.getBalance());
        //Log the error
      }
    }

    /**Helper method to end the simulated month and display the final status of
    the savings account. It utilizes only SavingsAccount methods to retrieve
    the status of the account.
    @param account The savings account from which to retrieve status
    information.*/
    private static void endMonth(SavingsAccount account)
    {
      System.out.print("\nIn one month, " + account.getDepositCount() +
        " deposit(s) were made; " + account.getWithdrawalCount() +
        " withdrawal(s) were made; withdrawals this month resulted in $" +
        (int)account.getPeriodServiceCharge() + " in service charges. ");
      account.monthlyProcess();
      System.out.printf("After service charges were deducted and monthly " +
        "interest was applied, the account balance is currently $%.2f.\n"
        , account.getBalance());
    }
}
