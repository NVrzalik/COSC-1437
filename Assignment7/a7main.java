import java.util.concurrent.ThreadLocalRandom;

class a7main
{
    private final int NUMBER_OF_TRANSACTIONS = 10;
    private final double MAX_STARTING_BALANCE = 20000.0;
    private final double MIN_STARTING_BALANCE = 5.0;
    private final double MAX_ANNUAL_INTEREST_RATE = .1;
    private final double MIN_ANNUAL_INTEREST_RATE = .0;
    private final double MAX_TRANSACTION_AMOUNT = 1000.0;

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

    private SavingsAccount generateAccount()
    {
      //Generate random starting balance
      double startingBalance =
        ThreadLocalRandom.current().nextDouble(MIN_STARTING_BALANCE,
          MAX_STARTING_BALANCE);
      startingBalance = ((int)(startingBalance * 100)) / 100;
      //Generate random interest rate
      double annualInterestRate =
        ThreadLocalRandom.current().nextDouble(MIN_ANNUAL_INTEREST_RATE,
          MAX_ANNUAL_INTEREST_RATE);
      annualInterestRate = ((int)(annualInterestRate * 100)) / 100;
      //Instantiate SavingsAccount object
      SavingsAccount account = new SavingsAccount(startingBalance,
        annualInterestRate);
      //Display account information
      System.out.println("A new savings account has been opened. The starting "
        + "balance is $" + account.getBalance() + ", and the annual interest "
        + "rate is " + account.getAnnualInterestRate() + ".");
      return account;
    }

    private void makeTransaction(account)
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

    private boolean getRandomBoolean()
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

    private void makeDeposit(SavingsAccount account, double amount)
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

    private void makeWithdrawal(SavingsAccount account, double amount)
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

    private void endMonth(SavingsAccount account)
    {
      System.out.print("In one month, " + account.getDepositCount() +
        " deposit(s) were made; " + account.getWithdrawalCount() +
        " withdrawal(s) were made; withdrawals this month resulted in $" +
        account.getPeriodServiceCharge() + " in service charges. ")
      account.monthlyProcess();
      System.out.println("After service charges were deducted and monthly " +
        "interest was applied, the account balance is currently $" +
        account.getBalance() + ".");
    }
}
