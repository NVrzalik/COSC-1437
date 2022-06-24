/**This class serves to simulate a customer of a business, extending the
functionality of the Person class. It adds a private boolean field to determine
whether or not the customer has elected to join the business mailing list, and
an int field to hold the customer ID. The class provides multiple constructor
methods in order to accomodate those customers who would rather not provide
certain information fields.*/
class Customer extends Person
{
  private boolean mailingList;
  private int customerNumber;

  /**Constructor method to accept input for all non-final fields, including
  those inherited from the Person class. Throws an exception if any of the
  parameters are invalid.
  @param firstName The customer's first name.
  @param lastName The customer's last name.
  @param phoneNumber The customer's phone number.
  @param customerNumber The customer's ID number.
  @param mailingList A boolean value to determine whether or not the customer
  has joined the mainling list.
  @param address The customer's address.*/
  public Customer(String firstName, String lastName, String phoneNumber,
    int customerNumber, boolean mailingList, String address) throws Exception
  {
    super(firstName, lastName, phoneNumber, address);
    setMailingList(mailingList);
    setCustomerNumber(customerNumber);
  }

  /**Constructor method to accept input for all non-final fields except a
  boolean value for the mailing list. Throws an exception if any of the
  parameters are invalid.
  @param firstName The customer's first name.
  @param lastName The customer's last name.
  @param phoneNumber The customer's phone number.
  @param customerNumber The customer's ID number.
  @param address The customer's address.*/
  public Customer(String firstName, String lastName, String phoneNumber,
    int customerNumber, String address) throws Exception
  {
    super(firstName, lastName, phoneNumber, address);
    setCustomerNumber(customerNumber);
  }

  /**Constructor method to accept input for all non-final fields except an
  address and a boolean value for the mailing list. Throws an exception if any
  of the parameters are invalid.
  @param firstName The customer's first name.
  @param lastName The customer's last name.
  @param phoneNumber The customer's phone number.
  @param customerNumber The customer's ID number.*/
  public Customer(String firstName, String lastName, String phoneNumber,
    int customerNumber) throws Exception
  {
    super(firstName, lastName, false, phoneNumber);
    setCustomerNumber(customerNumber);
  }

  /**Constructor method to accept input for all non-final fields except the
  customer's phone number. Throws an exception if any of the parameters are
  invalid.
  @param firstName The customer's first name.
  @param lastName The customer's last name.
  @param customerNumber The customer's ID number.
  @param mailingList A boolean value to determine whether or not the customer
  has joined the mainling list.
  @param address The customer's address.*/
  public Customer(String firstName, String lastName, int customerNumber,
    boolean mailingList, String address) throws Exception
  {
    super(firstName, lastName, true, address);
    setMailingList(mailingList);
    setCustomerNumber(customerNumber);
  }

  /**Constructor method to accept input for all non-final fields except a phone
  number and a boolean value for the mailing list. Throws an exception if any
  of the parameters are invalid.
  @param firstName The customer's first name.
  @param lastName The customer's last name.
  @param customerNumber The customer's ID number.
  @param address The customer's address.*/
  public Customer(String firstName, String lastName, int customerNumber,
    String address) throws Exception
  {
    super(firstName, lastName, true, address);
    setCustomerNumber(customerNumber);
  }

  /**Constructor method to accept input for the customer's first name, last
  name, and customer ID. Throws an exception if any of the parameters are
  invalid.
  @param firstName The customer's first name.
  @param lastName The customer's last name.
  @param customerNumber The customer's ID number.*/
  public Customer(String firstName, String lastName, int customerNumber)
    throws Exception
  {
    super(firstName, lastName);
    setCustomerNumber(customerNumber);
  }

  /**Private method to determine whether or not a customer ID is valid. Only
  positive integers are permitted.
  @param customerNumber The customer ID to be validated.
  @return True if the customer ID is valid, false if not.*/
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

  /**Public method to set the customer's ID field. Throws an exception if the
  provided ID is invalid.
  @param customerNumber The customer ID to be validated and set.*/
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

  /**Public method to set the customer's mailingList field, determining whether
  or not the customer wants to be added to the mailing list. If the
  mailingList field is being set to "true", but the customer's address has not
  yet been provided, an exception is thrown.
  @param mailingList The boolean value determing whether or not the customer
  wants to be added to the mailing list.*/
  public void setMailingList(boolean mailingList) throws Exception
  {
    if(mailingList == true)
    {
      try
      {
        getAddress();
      }
      catch(Exception e)
      {
        throw new Exception("Address has not been set");
      }
    }
    this.mailingList = mailingList;
  }

  /**Public method to return the value of the customer's mailingList field.
  @return The value of the customer's mailingList field.*/
  public boolean getMailingList()
  {
    return this.mailingList;
  }

  /**Public method to return the customer's ID number.
  @return The customer's ID number.*/
  public int getCustomerNumber()
  {
    return this.customerNumber;
  }
}
