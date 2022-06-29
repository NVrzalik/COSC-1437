class SavingsAccount extends BankAccount
{
  private boolean activeAccount;
  private final double MINIMUM_ACTIVE_BALANCE = 25.0;
  private final int FREE_WITHDRAWALS_PER_MONTH = 4;
  private final double WITHDRAWAL_SERVICE_CHARGE = 1.0;

  public SavingsAccount(double startingBalance, double annualInterestRate)
    throws Exception
  {
    super(startingBalance, annualInterestRate);
    this.isActive();
  }

  public boolean isActive()
  {
    if(super.getBalance() >= this.MINIMUM_ACTIVE_BALANCE)
    {
      this.activeAccount = true;
      return this.activeAccount;
    }
    else
    {
      this.activeAccount = false;
      return this.activeAccount;
    }
  }

  @Override
  public void withdraw(double amount) throws Exception
  {
    if(isActive())
    {
      super.withdraw(amount);
      this.addServiceCharge();
    }
    else
    {
      throw new Exception("Cannot make withdrawal from inactive account");
    }
  }

  private void addServiceCharge()
  {
    if(super.getWithdrawalCount() > this.FREE_WITHDRAWALS_PER_MONTH)
    {
      try
      {
        super.addPeriodServiceCharge(this.WITHDRAWAL_SERVICE_CHARGE);
      }
      catch (Exception e)
      {
        //Log the error
      }
    }
  }

  @Override
  public void deposit(double amount) throws Exception
  {
    super.deposit(amount);
    this.isActive();
  }

  @Override
  public void monthlyProcess()
  {
    try
    {
      super.monthlyProcess();
    }
    catch (Exception e)
    {
      //Log the error
    }
    this.isActive();
  }
}
