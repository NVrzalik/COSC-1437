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

  public PreferredCustomer(String firstName, String lastName,
    String phoneNumber, int customerNumber, boolean mailingList, String address,
    double amountPurchased) throws Exception
  {
    super(firstName, lastName, phoneNumber, customerNumber, mailingList,
      address);
    setAmountPurchased(amountPurchased);
  }

  public PreferredCustomer(String firstName, String lastName,
    String phoneNumber, int customerNumber, boolean mailingList, String address)
    throws Exception
  {
    super(firstName, lastName, phoneNumber, customerNumber, mailingList,
      address);
    setAmountPurchased(0);
  }

  public PreferredCustomer(String firstName, String lastName,
    String phoneNumber, int customerNumber, String address,
    double amountPurchased) throws Exception
  {
    super(firstName, lastName, phoneNumber, customerNumber, address);
    setAmountPurchased(amountPurchased);
  }

  public PreferredCustomer(String firstName, String lastName,
    String phoneNumber, int customerNumber, String address) throws Exception
  {
    super(firstName, lastName, phoneNumber, customerNumber, address);
    setAmountPurchased(0);
  }

  public PreferredCustomer(String firstName, String lastName,
    String phoneNumber, int customerNumber, double amountPurchased)
    throws Exception
  {
    super(firstName, lastName, phoneNumber, customerNumber);
    setAmountPurchased(amountPurchased);
  }

  public PreferredCustomer(String firstName, String lastName,
    String phoneNumber, int customerNumber)
    throws Exception
  {
    super(firstName, lastName, phoneNumber, customerNumber);
    setAmountPurchased(0);
  }

  public PreferredCustomer(String firstName, String lastName,
    int customerNumber, boolean mailingList, String address,
    double amountPurchased) throws Exception
  {
    super(firstName, lastName, customerNumber, mailingList, address);
    setAmountPurchased(amountPurchased);
  }

  public PreferredCustomer(String firstName, String lastName,
    int customerNumber, boolean mailingList, String address) throws Exception
  {
    super(firstName, lastName, customerNumber, mailingList, address);
    setAmountPurchased(0);
  }

  public PreferredCustomer(String firstName, String lastName,
    int customerNumber, String address, double amountPurchased) throws Exception
  {
    super(firstName, lastName, customerNumber, address);
    setAmountPurchased(amountPurchased);
  }

  public PreferredCustomer(String firstName, String lastName,
    int customerNumber, String address) throws Exception
  {
    super(firstName, lastName, customerNumber, address);
    setAmountPurchased(0);
  }

  public PreferredCustomer(String firstName, String lastName,
    int customerNumber, double amountPurchased) throws Exception
  {
    super(firstName, lastName, customerNumber);
    setAmountPurchased(amountPurchased);
  }

  public PreferredCustomer(String firstName, String lastName,
    int customerNumber) throws Exception
  {
    super(firstName, lastName, customerNumber);
    setAmountPurchased(0);
  }

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

  public double getAmountPurchased()
  {
    return this.amountPurchased;
  }

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
