/**This class serves to simulate a preferred customer of a retail business,
extending the functionality of the Customer class. The class contains private
fields that hold the cumulative dollar amount of the customer's purchases from
the business, the "preferred customer level" of the customer due to the value
of their purchases, and the discount rate that they have earned on all future
purchases as a benefit of the business' preferred customer program. The class
provides multiple constructors in order to allow customers to withold certain
fields of non-necessary information.*/
class PreferredCustomer extends Customer
{
  private double amountPurchased;
  private int customerLevel;
  private double discountAmount;
  private final double LEVEL_4_PURCHASE_AMOUNT = 2000.0;
  private final double LEVEL_3_PURCHASE_AMOUNT = 1500.0;
  private final double LEVEL_2_PURCHASE_AMOUNT = 1000.0;
  private final double LEVEL_1_PURCHASE_AMOUNT = 500.0;
  private final double LEVEL_4_DISCOUNT = .1;
  private final double LEVEL_3_DISCOUNT = .07;
  private final double LEVEL_2_DISCOUNT = .06;
  private final double LEVEL_1_DISCOUNT = .05;

  /**Constructor method to accept input for all non-final fields, including
  those inherited from super classes. Throws an exception if any of the
  parameters are invalid.
  @param firstName The customer's first name.
  @param lastName The customer's last name.
  @param phoneNumber The customer's phone number.
  @param customerNumber The customer's ID number.
  @param mailingList A boolean value to determine whether or not the customer
  has joined the mainling list.
  @param address The customer's address.
  @param amountPurchased The cumulative value of all purchases made by the
  customer from the business so far.*/
  public PreferredCustomer(String firstName, String lastName,
    String phoneNumber, int customerNumber, boolean mailingList, String address,
    double amountPurchased) throws Exception
  {
    super(firstName, lastName, phoneNumber, customerNumber, mailingList,
      address);
    setAmountPurchased(amountPurchased);
  }

  /**Constructor method to accept input for all non-final fields except
  amountPurchased. Throws an exception if any of the
  parameters are invalid.
  @param firstName The customer's first name.
  @param lastName The customer's last name.
  @param phoneNumber The customer's phone number.
  @param customerNumber The customer's ID number.
  @param mailingList A boolean value to determine whether or not the customer
  has joined the mainling list.
  @param address The customer's address.*/
  public PreferredCustomer(String firstName, String lastName,
    String phoneNumber, int customerNumber, boolean mailingList, String address)
    throws Exception
  {
    super(firstName, lastName, phoneNumber, customerNumber, mailingList,
      address);
    setAmountPurchased(0);
  }

  /**Constructor method to accept input for all non-final fields except the
  mailingList field. Throws an exception if any of the parameters are invalid.
  @param firstName The customer's first name.
  @param lastName The customer's last name.
  @param phoneNumber The customer's phone number.
  @param customerNumber The customer's ID number.
  @param address The customer's address.
  @param amountPurchased The cumulative value of all purchases made by the
  customer from the business so far.*/
  public PreferredCustomer(String firstName, String lastName,
    String phoneNumber, int customerNumber, String address,
    double amountPurchased) throws Exception
  {
    super(firstName, lastName, phoneNumber, customerNumber, address);
    setAmountPurchased(amountPurchased);
  }

  /**Constructor method to accept input for all non-final fields except for the
  mailingList and amountPurchased fields. Throws an exception if any of the
  parameters are invalid.
  @param firstName The customer's first name.
  @param lastName The customer's last name.
  @param phoneNumber The customer's phone number.
  @param customerNumber The customer's ID number.
  @param address The customer's address.*/
  public PreferredCustomer(String firstName, String lastName,
    String phoneNumber, int customerNumber, String address) throws Exception
  {
    super(firstName, lastName, phoneNumber, customerNumber, address);
    setAmountPurchased(0);
  }

  /**Constructor method to accept input for all non-final fields except the
  mailingList and address fields. Throws an exception if any of the
  parameters are invalid.
  @param firstName The customer's first name.
  @param lastName The customer's last name.
  @param phoneNumber The customer's phone number.
  @param customerNumber The customer's ID number.
  @param amountPurchased The cumulative value of all purchases made by the
  customer from the business so far.*/
  public PreferredCustomer(String firstName, String lastName,
    String phoneNumber, int customerNumber, double amountPurchased)
    throws Exception
  {
    super(firstName, lastName, phoneNumber, customerNumber);
    setAmountPurchased(amountPurchased);
  }

  /**Constructor method to accept as input only the customer's first name, last
  name, phone number, and customer ID number. Throws an exception if any of the
  parameters are invalid.
  @param firstName The customer's first name.
  @param lastName The customer's last name.
  @param phoneNumber The customer's phone number.
  @param customerNumber The customer's ID number.*/
  public PreferredCustomer(String firstName, String lastName,
    String phoneNumber, int customerNumber)
    throws Exception
  {
    super(firstName, lastName, phoneNumber, customerNumber);
    setAmountPurchased(0);
  }

  /**Constructor method to accept input for all non-final fields except the
  customer's phone number. Throws an exception if any of the parameters are
  invalid.
  @param firstName The customer's first name.
  @param lastName The customer's last name.
  @param customerNumber The customer's ID number.
  @param mailingList A boolean value to determine whether or not the customer
  has joined the mainling list.
  @param address The customer's address.
  @param amountPurchased The cumulative value of all purchases made by the
  customer from the business so far.*/
  public PreferredCustomer(String firstName, String lastName,
    int customerNumber, boolean mailingList, String address,
    double amountPurchased) throws Exception
  {
    super(firstName, lastName, customerNumber, mailingList, address);
    setAmountPurchased(amountPurchased);
  }

  /**Constructor method to accept input for all non-final fields except the
  customer's phone number and cumulative purchase amount. Throws an exception
  if any of the parameters are invalid.
  @param firstName The customer's first name.
  @param lastName The customer's last name.
  @param customerNumber The customer's ID number.
  @param mailingList A boolean value to determine whether or not the customer
  has joined the mainling list.
  @param address The customer's address.*/
  public PreferredCustomer(String firstName, String lastName,
    int customerNumber, boolean mailingList, String address) throws Exception
  {
    super(firstName, lastName, customerNumber, mailingList, address);
    setAmountPurchased(0);
  }

  /**Constructor method to accept input for all non-final fields except the
  customer's phone number and mailingList fields. Throws an exception if any of
  the parameters are invalid.
  @param firstName The customer's first name.
  @param lastName The customer's last name.
  @param customerNumber The customer's ID number.
  @param address The customer's address.
  @param amountPurchased The cumulative value of all purchases made by the
  customer from the business so far.*/
  public PreferredCustomer(String firstName, String lastName,
    int customerNumber, String address, double amountPurchased) throws Exception
  {
    super(firstName, lastName, customerNumber, address);
    setAmountPurchased(amountPurchased);
  }

  /**Constructor method to accept as input only the customer's first name, last
  name, customer ID number, and address. Throws an exception if any of the
  parameters are invalid.
  @param firstName The customer's first name.
  @param lastName The customer's last name.
  @param customerNumber The customer's ID number.
  @param address The customer's address.*/
  public PreferredCustomer(String firstName, String lastName,
    int customerNumber, String address) throws Exception
  {
    super(firstName, lastName, customerNumber, address);
    setAmountPurchased(0);
  }

  /**Constructor method to accept as input only the customer's first name, last
  name, customer ID number, and cumulative purchase amount. Throws an exception
  if any of the parameters are invalid.
  @param firstName The customer's first name.
  @param lastName The customer's last name.
  @param customerNumber The customer's ID number.
  @param amountPurchased The cumulative value of all purchases made by the
  customer from the business so far.*/
  public PreferredCustomer(String firstName, String lastName,
    int customerNumber, double amountPurchased) throws Exception
  {
    super(firstName, lastName, customerNumber);
    setAmountPurchased(amountPurchased);
  }

  /**Constructor method to accept as input only the customer's first name, last
  name, and customer ID number. Throws an exception if any of the parameters
  are invalid.
  @param firstName The customer's first name.
  @param lastName The customer's last name.
  @param customerNumber The customer's ID number.*/
  public PreferredCustomer(String firstName, String lastName,
    int customerNumber) throws Exception
  {
    super(firstName, lastName, customerNumber);
    setAmountPurchased(0);
  }

  /**Private method to determine if a given purchase amount is valid. Only
  non-negative amounts are permitted.
  @param amount The purchase amount to be validated.
  @return True if the amount is valid, false if not.*/
  private boolean amountIsValid(double amount)
  {
    if(amount >= 0)
    {
      return true;
    }
    else
    {
      return false;
    }
  }

  /**Public mutator method to set the customer's cumulative purchase amount.
  Throws an exception if the passed amount is invalid.
  @param amountPurchased The purchase amount to be validated and set.*/
  public void setAmountPurchased(double amountPurchased) throws Exception
  {
    if(amountIsValid(amountPurchased))
    {
      this.amountPurchased = amountPurchased;
    }
    else
    {
      throw new Exception("Invalid purchase amount");
    }
  }

  /**Public method to add to the customer's cumulative purchase amount. Throws
  an exception if the passed amount is invalid.
  @param amountPurchased The purchase amount to be validated and added.*/
  public void addPurchase(double purchaseAmount) throws Exception
  {
    if(amountIsValid(purchaseAmount))
    {
      this.amountPurchased += purchaseAmount;
    }
    else
    {
      throw new Exception("Invalid purchase amount");
    }
  }

  /**Public accessor method to retrieve the customer's cumulative purchase
  amount.
  @return The customer's cumulative purchase amount.*/
  public double getAmountPurchased()
  {
    return this.amountPurchased;
  }

  /**Public accessor method to determine and retrieve the customer's preferred
  customer level. This level is determined by the customer's cumulative purchase
  amount.
  @return The customer's preferred customer level.*/
  public int getCustomerLevel()
  {
    double amountPurchased = getAmountPurchased();
    if(amountPurchased >= LEVEL_4_PURCHASE_AMOUNT)
    {
      return 4;
    }
    else if(amountPurchased >= LEVEL_3_PURCHASE_AMOUNT)
    {
      return 3;
    }
    else if(amountPurchased >= LEVEL_2_PURCHASE_AMOUNT)
    {
      return 2;
    }
    else if(amountPurchased >= LEVEL_1_PURCHASE_AMOUNT)
    {
      return 1;
    }
    else
    {
      return 0;
    }
  }

  /**Public accessor method to determine and retrieve the customer's discount
  rate. This rate is determined by the customer's cumulative purchase amount.
  @return The customer's discount rate.*/
  public double getDiscountAmount()
  {
    double amountPurchased = getAmountPurchased();
    if(amountPurchased >= LEVEL_4_PURCHASE_AMOUNT)
    {
      return LEVEL_4_DISCOUNT;
    }
    else if(amountPurchased >= LEVEL_3_PURCHASE_AMOUNT)
    {
      return LEVEL_3_DISCOUNT;
    }
    else if(amountPurchased >= LEVEL_2_PURCHASE_AMOUNT)
    {
      return LEVEL_2_DISCOUNT;
    }
    else if(amountPurchased >= LEVEL_1_PURCHASE_AMOUNT)
    {
      return LEVEL_1_DISCOUNT;
    }
    else
    {
      return 0.0;
    }
  }
}
