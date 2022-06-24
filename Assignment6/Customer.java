class Customer extends Person
{
  private boolean mailingList;
  private int customerNumber;

  public Customer(String firstName, String lastName, String phoneNumber,
    int customerNumber, boolean mailingList, String address) throws Exception
  {
    super(firstName, lastName, phoneNumber, address);
    this.mailingList = mailingList;
    setCustomerNumber(customerNumber);
  }

  public Customer(String firstName, String lastName, String phoneNumber,
    int customerNumber, String address) throws Exception
  {
    super(firstName, lastName, phoneNumber, address);
    setCustomerNumber(customerNumber);
  }

  public Customer(String firstName, String lastName, String phoneNumber,
    int customerNumber) throws Exception
  {
    super(firstName, lastName, false, phoneNumber);
    setCustomerNumber(customerNumber);
  }

  public Customer(String firstName, String lastName, int customerNumber,
    boolean mailingList, String address) throws Exception
  {
    super(firstName, lastName, true, address);
    this.mailingList = mailingList;
    setCustomerNumber(customerNumber);
  }

  public Customer(String firstName, String lastName, int customerNumber,
    String address) throws Exception
  {
    super(firstName, lastName, true, address);
    setCustomerNumber(customerNumber);
  }

  public Customer(String firstName, String lastName, int customerNumber)
    throws Exception
  {
    super(firstName, lastName);
    setCustomerNumber(customerNumber);
  }

  private boolean customerNumberIsValid(int customerNumber)
  {
    if(customerNumber > 0)
    {
      return true;
    }
    else
    {
      return false;
    }
  }

  public void setCustomerNumber(int customerNumber) throws Exception
  {
    if(customerNumberIsValid(customerNumber))
    {
      this.customerNumber = customerNumber;
    }
    else
    {
      throw new Exception("Invalid customer number");
    }
  }

  public boolean getMailingList()
  {
    return this.mailingList;
  }

  public int getCustomerNumber()
  {
    return this.customerNumber;
  }
}
