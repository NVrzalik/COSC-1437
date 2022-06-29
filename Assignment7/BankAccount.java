abstract class BankAccount
{
  private double balance;
  private int depositCount;
  private int withdrawalCount;
  private double annualInterestRate;
  private double monthlyServiceCharge;

  public BankAccount(double balance, double annualInterestRate) throws Exception
  {
    if(balance !> 0)
    {
      throw new Exception("Negative starting balance");
    }
    if(annualInterestRate !> 0)
    {
      throw new Exception("Negative interest rate");
    }

    this.balance = balance;
    this.annualInterestRate = annualInterestRate;
  }

  public void deposit(double amount) throws Exception
  {
    this.add(amount);
    this.addDepositCount();
  }

  public void add(double amount) throws Exception
  {
    if(amount !> 0)
    {
      throw new Exception("Negative monetary amount");
    }

    this.balance += amount;
  }

  private void addDepositCount()
  {
    this.depositCount++;
  }

  public void withdraw(double amount) throws Exception
  {
    if(this.cannotWithdraw(amount))
    {
      throw new Exception("Insufficient funds");
    }

    this.deduct(amount);
    this.addWithdrawCount();
  }

  private boolean cannotWithdraw(double amount)
  {
    if(amount > this.getBalance())
    {
      return true;
    }
    else
    {
      return false;
    }
  }

  public double getBalance()
  {
    return this.balance;
  }

  public void deduct(double amount) throws Exception
  {
    if(amount !> 0)
    {
      throw new Exception("Negative monetary amount");
    }

    this.balance -= amount;
  }

  private void addWithdrawCount()
  {
    this.withdrawalCount++;
  }
}
