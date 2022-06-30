/**This abstract class serves to simulate a generic bank account according to
specifications provided for the assignment. It is intended to function as a
blueprint and foundation for other real bank accounts of various types to be
instantiated. It contains various public facing methods for object
functionality, and multiple private helper methods to modularize the code.*/
abstract class BankAccount
{
  //The current balance of the account
  private double balance;
  //The current number of deposits made to the account in a given time period
  private int depositCount;
  //The current number of withdrawals made to the account in a given time period
  private int withdrawalCount;
  //The account's annual interest rate
  private double annualInterestRate;
  //The pending service charges for the account in a given time period
  private double periodServiceCharge;

  /**Class constructor. It initializes the account's starting balance and
  annual interest rate. It also rounds the starting balance to ensure that
  fractional cents are not permitted. Throws exceptions if the interest rate
  is negative, or if the starting balance isn't greater than zero.
  @param balance The starting balance
  @param annualInterestRate The annual interest rate*/
  public BankAccount(double balance, double annualInterestRate) throws Exception
  {
    balance = this.roundMoney(balance);
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

  /**Public method to make a deposit to the account. It utilizes helper methods
  the add the deposit amount to the account and increment the deposit counter.
  If the amount to be deposited isn't greater than zero, an exception is thrown.
  @param amount The deposit amount*/
  public void deposit(double amount) throws Exception
  {
    if(amount <= 0)
    {
      throw new Exception("Invalid monetary amount");
    }
    this.add(amount);
    this.addDepositCount();
  }

  /**Public facing helper method to add an amount to the account. This is the
  only method by which funds can directly be added to an account. The amount is
  rounded to ensure that fractional cents are not permitted. An exception is
  thrown if the amount is negative.
  @param amount The amount to be added to the account.*/
  public void add(double amount) throws Exception
  {
    if(amount < 0)
    {
      throw new Exception("Invalid monetary amount");
    }
    amount = roundMoney(amount);
    this.balance += amount;
    this.balance = this.roundMoney(this.balance);
  }

  /**Private helper method to round monetary amounts to whole cents.
  @param amount The monetary amount to be rounded.
  @return The rounded monetary amount.*/
  private double roundMoney(double amount)
  {
    amount = (Math.round(amount * 100) / 100.0);
    return amount;
  }

  /**Private helper method to increment the deposit counter.*/
  private void addDepositCount()
  {
    this.depositCount++;
  }

  /**Public method to make a withdrawal from the account. It utilizes helper
  methods to determine if sufficient funds exist for the withdrawal, to deduct
  the amount from the account, and to increment the withdrawal counter. An
  exception is thrown if the amount to be withdrawn isn't greater than zero, or
  if there are insufficient funds for theh withdrawal.
  @param amount The amount to be withdrawn.*/
  public void withdraw(double amount) throws Exception
  {
    if(amount <= 0)
    {
      throw new Exception("Invalid monetary amount");
    }
    if(this.cannotWithdraw(amount))
    {
      throw new Exception("Insufficient funds");
    }

    this.deduct(amount);
    this.addWithdrawCount();
  }

  /**Private helper method to determine whether sufficient funds exist in the
  account for an attempted withdrawal.
  @param amount The amount to be withdrawn.
  @return True if there are insufficient funds, false if not.*/
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

  /**Public accessor method to return the current account balance.
  @return The current account balance.*/
  public double getBalance()
  {
    return this.balance;
  }

  /**Public facing helper method to deduct an amount from the account. This is
  the only method by which funds can directly be removed from an account. The
  amount is rounded to ensure that fractional cents are not permitted. An
  exception is thrown if the amount is negative.
  @param amount The amount to be deducted from the account.*/
  public void deduct(double amount) throws Exception
  {
    if(amount < 0)
    {
      throw new Exception("Invalid monetary amount");
    }
    amount = this.roundMoney(amount);
    this.balance -= amount;
    this.balance = this.roundMoney(this.balance);
  }

  /**Private helper method to increment the withdrawal counter.*/
  private void addWithdrawCount()
  {
    this.withdrawalCount++;
  }

  /**Private helper method to calculate and apply the monthly interest on the
  account.*/
  private void calcInterest() throws Exception
  {
    double monthlyInterestRate = (this.getAnnualInterestRate() / 12);
    double monthlyInterestAmount = (monthlyInterestRate * this.getBalance());
    this.add(monthlyInterestAmount);
  }

  /**Public accessor method to return the annual interest rate of the account.
  @return The annual interest rate of the account.*/
  public double getAnnualInterestRate()
  {
    return this.annualInterestRate;
  }

  /**Public method to add a service charge amount to the account. The amount is
  rounded to ensure that fractional cents are not permitted. An exception is
  thrown if the amount is negative.
  @param amount The service charge to be applied to the account.*/
  public void addPeriodServiceCharge(double amount) throws Exception
  {
    if(amount < 0)
    {
      throw new Exception("Invalid monetary amount");
    }
    amount = this.roundMoney(amount);
    this.periodServiceCharge += amount;
    this.periodServiceCharge = this.roundMoney(this.periodServiceCharge);
  }

  /**Public method to deduct a given monetary amount from pending service
  charges. The amount is rounded to ensure that fractional cents are not
  permitted. Exceptions are thrown if the amount to be deducted is negative, or
  if the deduction would result in a negative service charge on the account.
  @param amount The amount to be deducted from the pending service charges.*/
  public void waivePeriodServiceCharge(double amount) throws Exception
  {
    if(amount < 0)
    {
      throw new Exception("Invalid monetary amount");
    }
    if(amount > this.getPeriodServiceCharge())
    {
      throw new Exception("Service charge deduction is greater than pending " +
        "service charges");
    }
    amount = this.roundMoney(amount);
    this.periodServiceCharge -= amount;
    this.periodServiceCharge = this.roundMoney(this.periodServiceCharge);
  }

  /**Public accessor method to return the current pending service charges on
  the account.
  @return The current pending service chareges.*/
  public double getPeriodServiceCharge()
  {
    return this.periodServiceCharge;
  }

  /**Public method to process the account at the end of a monthly period. It
  deducts any existing service charges, calculates and applies interest, and
  resets the withdrawal counter, deposit counter, and the pending service
  charges.*/
  public void monthlyProcess() throws Exception
  {
    this.deduct(this.getPeriodServiceCharge());
    this.calcInterest();
    this.resetWithdrawalCount();
    this.resetDepositCount();
    this.resetPeriodServiceCharge();
  }

  /**Private helper method to reset the withdrawal counter.*/
  private void resetWithdrawalCount()
  {
    this.withdrawalCount = 0;
  }

  /**Private helper method to reset the deposit counter.*/
  private void resetDepositCount()
  {
    this.depositCount = 0;
  }

  /**Private helper method to reset the pending services charges.*/
  private void resetPeriodServiceCharge()
  {
    this.periodServiceCharge = 0;
  }

  /**Accessor method to return the current withdrawal count.
  @return The current withdrawal count.*/
  public int getWithdrawalCount()
  {
    return this.withdrawalCount;
  }

  /**Accessor method to return the current deposit count.
  @return The current deposit count.*/
  public int getDepositCount()
  {
    return this.depositCount;
  }
}
