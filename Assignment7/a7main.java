import java.util.concurrent.ThreadLocalRandom;

class a7main
{
    private static final int NUMBER_OF_TRANSACTIONS = 10;
    private static final double MAX_STARTING_BALANCE = 20000.0;
    private static final double MIN_STARTING_BALANCE = 5.0;
    private static final double MAX_ANNUAL_INTEREST_RATE = .1;
    private static final double MAX_TRANSACTION_AMOUNT = 1000.0;

    public static void main(String[] args)
    {
      /*Instantiate SavingsAccount object with random starting balance and
      annual interest rate*/
      SavingsAccount account = generateAccount();
      for(int i = 0; i < NUMBER_OF_TRANSACTIONS; i++)
      {
        makeTransaction(account);
      }
      endMonth(account);
    }

    private static SavingsAccount generateAccount()
    {
      //Generate random starting balance
      double startingBalance =
        ThreadLocalRandom.current().nextDouble(MIN_STARTING_BALANCE,
          MAX_STARTING_BALANCE);
      startingBalance = ((int)(startingBalance * 100)) / 100;
      //Generate random interest rate
      double annualInterestRate =
        ThreadLocalRandom.current().nextDouble(MAX_ANNUAL_INTEREST_RATE);
      //annualInterestRate = ((int)(annualInterestRate * 100)) / 100;
      //Instantiate SavingsAccount object
      SavingsAccount account = null;
      try
      {
        account = new SavingsAccount(startingBalance, annualInterestRate);
      }
      catch(Exception e)
      {
        System.out.println(startingBalance + " " + annualInterestRate);
        e.printStackTrace();
      }
      //Display account information
      System.out.println("A new savings account has been opened. The starting "
        + "balance is $" + account.getBalance() + ", and the annual interest "
        + "rate is " + account.getAnnualInterestRate() + ".");
      return account;
    }

    private static void makeTransaction(SavingsAccount account)
    {
      double amount =
        ThreadLocalRandom.current().nextDouble(MAX_TRANSACTION_AMOUNT);
      amount = ((int)(amount * 100)) / 100;
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

    private static void makeDeposit(SavingsAccount account, double amount)
    {
      System.out.print("Attempting to deposit $" + amount + "...");
      try
      {
        account.deposit(amount);
        System.out.println("Deposit successful. Account balance is now $" +
          account.getBalance() + " .");
      }
      catch(Exception e)
      {
        System.out.println("Deposit unsuccessful. Account balance remains $" +
          account.getBalance() + " .");
        //Log the error
      }
    }

    private static void makeWithdrawal(SavingsAccount account, double amount)
    {
      System.out.print("Attempting to withdraw $" + amount + "...");
      try
      {
        account.withdraw(amount);
        System.out.println("Withdrawal successful. Account balance is now $" +
          account.getBalance() + " .");
      }
      catch(Exception e)
      {
        System.out.println("Withdrawal unsuccessful. Account balance remains $"
          + account.getBalance() + " .");
        //Log the error
      }
    }

    private static void endMonth(SavingsAccount account)
    {
      System.out.print("In one month, " + account.getDepositCount() +
        " deposit(s) were made; " + account.getWithdrawalCount() +
        " withdrawal(s) were made; withdrawals this month resulted in $" +
        account.getPeriodServiceCharge() + " in service charges. ");
      account.monthlyProcess();
      System.out.println("After service charges were deducted and monthly " +
        "interest was applied, the account balance is currently $" +
        account.getBalance() + ".");
    }
}
