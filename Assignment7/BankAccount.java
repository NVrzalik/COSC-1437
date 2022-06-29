abstract class BankAccount
{
  private double balance;
  private int depositCount;
  private int withdrawalCount;
  private double annualInterestRate;
  private double periodServiceCharge;

  public BankAccount(double balance, double annualInterestRate) throws Exception
  {
    if(balance <= 0)
    {
      throw new Exception("Invalid starting balance");
    }
    if(annualInterestRate < 0)
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
    if(amount <= 0)
    {
      throw new Exception("Invalid monetary amount");
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
    if(amount <= 0)
    {
      throw new Exception("Invalid monetary amount");
    }

    this.balance -= amount;
  }

  private void addWithdrawCount()
  {
    this.withdrawalCount++;
  }

  private void calcInterest() throws Exception
  {
    System.out.println("Annual interest rate: " + this.getAnnualInterestRate());
    double monthlyInterestRate = (this.getAnnualInterestRate() / 12);
    System.out.println("Monthly interest rate: " + monthlyInterestRate);
    double monthlyInterestAmount = (monthlyInterestRate * this.getBalance());
    System.out.println("Monthly interest amount: " + monthlyInterestAmount);
    double newBalance = (this.getBalance() + monthlyInterestAmount);
    System.out.println("New balance: " + newBalance);
    this.add(monthlyInterestAmount);
    System.out.println("New balance after this.add(): " + this.getBalance());
  }

  public double getAnnualInterestRate()
  {
    return this.annualInterestRate;
  }

  public void addPeriodServiceCharge(double amount) throws Exception
  {
    if(amount <= 0)
    {
      throw new Exception("Invalid monetary amount");
    }
    this.periodServiceCharge += amount;
  }

  public void waivePeriodServiceCharge(double amount) throws Exception
  {
    if(amount <= 0)
    {
      throw new Exception("Invalid monetary amount");
    }
    if(amount > this.getPeriodServiceCharge())
    {
      throw new Exception("Service charge deduction is greater than pending " +
        "service charges");
    }
    this.periodServiceCharge -= amount;
  }

  public double getPeriodServiceCharge()
  {
    return this.periodServiceCharge;
  }

  public void monthlyProcess() throws Exception
  {
    this.deduct(this.getPeriodServiceCharge());
    this.calcInterest();
    this.resetWithdrawalCount();
    this.resetDepositCount();
    this.resetPeriodServiceCharge();
  }

  private void resetWithdrawalCount()
  {
    this.withdrawalCount = 0;
  }

  private void resetDepositCount()
  {
    this.depositCount = 0;
  }

  private void resetPeriodServiceCharge()
  {
    this.periodServiceCharge = 0;
  }

  public int getWithdrawalCount()
  {
    return this.withdrawalCount;
  }

  public int getDepositCount()
  {
    return this.depositCount;
  }
}
