/**This class serves to simulate a savings account according to specifications
provided for the assignment. It extends the abstract BankAccount class,
overriding some of its public methods and adding helper methods of its own.*/
class SavingsAccount extends BankAccount
{
  //Boolean flag to signal whether or not the account is active
  private boolean activeAccount;
  //The minimum balance required for an account to be considered active
  private final double MINIMUM_ACTIVE_BALANCE = 25.0;
  //The number of withdrawals per month permitted without a service charge
  private final int FREE_WITHDRAWALS_PER_MONTH = 4;
  //The service charge amount
  private final double WITHDRAWAL_SERVICE_CHARGE = 1.0;

  /**Class constructor. It passes the starting balance and annual interest rate
  of the account to the parent class, then determines whether or not the account
  is active.*/
  public SavingsAccount(double startingBalance, double annualInterestRate)
    throws Exception
  {
    super(startingBalance, annualInterestRate);
    this.isActive();
  }

  /**Public helper method to determine whether or not the account is active. It
  not only returns the value of the activeAccount flag, but also sets it to
  ensure that the data never becomes stale.
  @return True if the account is active, false if not.*/
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

  /**Public method to make a withdrawal from the account. It utilizes the parent
  class' withdraw method, but adds two steps: it prevents the withdrawal if the
  account is currently inactive; if the account is active, it adds a service
  charge to the account.
  @param amount The amount to be withdrawn from the account.*/
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

  /**Private helper method to determine whether or not a service charge needs
  to be applied for a withdrawal; if so, the method also applies the charge to
  the account.*/
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

  /**Public method to make a deposit to the account. It utilizes the parent
  class' deposit method, but adds the additional step of determining if the
  account is active after the deposit is made.
  @param amount The amount to be deposited to the account.*/
  @Override
  public void deposit(double amount) throws Exception
  {
    super.deposit(amount);
    this.isActive();
  }

  /**Public method to perform the monthly processing of the account. It utilizes
  the parent class' monthlyProcess method, but adds the additional step of
  determining if the account is active after the processing has been
  completed.*/
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
