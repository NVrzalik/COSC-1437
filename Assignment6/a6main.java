//For random number generation
import java.util.concurrent.ThreadLocalRandom;

/**Per assignment specifications, this class serves as a simple demonstration
of the principles of object-oriented design featuring class inheritance,
utilizing the PreferredCustomer class. With the exception of the first name,
last name, and address fields, this program generates random values to be passed
to a PreferredCustomer object, then utilizes PreferredCustomer class methods to
manipulate and retrieve the data. The program contains logic to correctly
format and display the resulting information.*/
class a6main
{
  private static final String FIRST_NAME = "Billy";
  private static final String LAST_NAME = "McGuffy";
  private static final String ADDRESS = "1234 Lonely Rd. San Antonio, TX 78232";
  private static final int PHONE_NUMBER_LENGTH = 10;
  private static final int MAX_CUSTOMER_NUMBER = 999999999;
  private static final int MAX_NUMBER_OF_PURCHASES = 3;
  private static final int MAX_PURCHASE_VALUE = 1000;
  private static String address;
  private static String phoneNumber;

  /**Main method.*/
  public static void main(String[] args)
  {
    //Instantiate PreferredCustomer object
    PreferredCustomer customer = generatePreferredCustomer();
    //Add purchases to object
    int numberOfPurchases = makePurchases(customer);
    //Fetch the results and format them logically
    System.out.print("Our customer today is " + customer.getFirstName() + " "
      + customer.getLastName() + ". Their address ");
    try
    {
      System.out.print("is " + customer.getAddress() + "; ");
    }
    catch(Exception e)
    {
      System.out.print("has not been provided; ");
    }

    System.out.print("their phone number ");
    try
    {
      System.out.print("is " + customer.getPhoneNumber() + ". ");
    }
    catch(Exception e)
    {
      System.out.print("has not been provided. ");
    }

    System.out.print("They've chosen ");
    if(customer.getMailingList())
    {
      System.out.print("to be added to our mailing list. ");
    }
    else
    {
      System.out.print("not to be added to our mailing list. ");
    }

    System.out.print("Their customer ID is " + customer.getCustomerNumber() +
      ". This customer has made " + numberOfPurchases + " purchase(s), ");
    System.out.printf("amounting to $%.2f. This has earned them a preferred " +
      "customer level of %d, and a preferred customer discount of %.2f%%.\n",
      customer.getAmountPurchased(), customer.getCustomerLevel(),
      (customer.getDiscountAmount() * 100));
  }

  /**Method to instantiate a PreferredCustomer object. It begins by constructing
  the object with only the necessary information, and then proceeds to set the
  values that the method generates via other internal method calls.
  @return The instantiated PreferredCustomer object.*/
  public static PreferredCustomer generatePreferredCustomer()
  {
    PreferredCustomer customer = null;
    try
    {
      customer = new PreferredCustomer(FIRST_NAME, LAST_NAME,
      generateCustomerNumber());
    }
    catch(Exception e)
    {
      e.printStackTrace();
      System.exit(1);
    }
    if(generatePhoneNumber())
    {
      try
      {
        customer.setPhoneNumber(phoneNumber);
      }
      catch(Exception e)
      {
        e.printStackTrace();
        System.exit(1);
      }
    }
    if(generateAddress())
    {
      try
      {
        customer.setAddress(address);
        customer.setMailingList(generateMailingList());
      }
      catch(Exception e)
      {
        e.printStackTrace();
        System.exit(1);
      }
    }
    return customer;
  }

  /**Method to randomly generate a customer's ID number. The upper range of
  the number is determined by a final variable defined globally.
  @return A customer's ID number.*/
  public static int generateCustomerNumber()
  {
    int customerNumber =
      ThreadLocalRandom.current().nextInt(MAX_CUSTOMER_NUMBER + 1);
    return customerNumber;
  }

  /**Method to randomly determine whether or not a customer will provide a
  phone number. If a phone number is to be provided, the method will also
  randomly generate the phone number, storing the number in a global variable.
  @return True if a customer is to provide a phone number, false if not.*/
  public static boolean generatePhoneNumber()
  {
    if(getBoolean())
    {
      phoneNumber = "";
      for(int i = 0; i < PHONE_NUMBER_LENGTH; i++)
      {
        phoneNumber = phoneNumber +
        ThreadLocalRandom.current().nextInt(10);
      }
      return true;
    }
    else
    {
      return false;
    }
  }

  /**Method to randomly determine whether or not a customer will provide an
  address. If an address is to be provided, the method will also assign one to
  a global variable for later use. Currently, a predefined final String
  provides a sample address for demonstration purposes.
  @return True if a customer is to provide an address, false if not.*/
  public static boolean generateAddress()
  {
    if(getBoolean())
    {
      address = ADDRESS;
      return true;
    }
    else
    {
      return false;
    }
  }

  /**Method to randomly determine whether or not a customer will wish to be
  added to the business' mailing list.
  @return True if the customer will wish to be added to the mailing list, false
  if not.*/
  public static boolean generateMailingList()
  {
    boolean mailingList = getBoolean();
    return mailingList;
  }

  /**Method to return a randomly generated boolean value.
  @return A random boolean value.*/
  public static boolean getBoolean()
  {
    int flag = ThreadLocalRandom.current().nextInt(2);
    if(flag == 1)
    {
      return false;
    }
    else
    {
      return true;
    }
  }

  /**Method to simulate the purchases that a customer makes at a business. The
  number of purchases and the amount of money spent on each purchase are
  randomly determined. The purchases are then added to the passed
  PreferredCustomer object.
  @param The PreferredCustomer object simulating a customer.
  @return The number of purchases made.*/
  public static int makePurchases(PreferredCustomer customer)
  {
    int[] purchases = generatePurchases();
    try
    {
      for(int i = 0; i < purchases.length; i++)
      {
        customer.addPurchase(purchases[i]);
      }
    }
    catch(Exception e)
    {
      e.printStackTrace();
      System.exit(1);
    }
    return purchases.length;
  }

  /**Method to randomly determine a number of purchases to be made, as well as
  the amount of money spent on each purchase. Two final int variables with
  global scope determine the upper ranges of the number of purchases as well as
  the monetary value of any one purchase.
  @return An int array containing the monetary amounts of each purchase made.*/
  public static int[] generatePurchases()
  {
    int numberOfPurchases = ThreadLocalRandom.current().nextInt(
      MAX_NUMBER_OF_PURCHASES + 1);

    int[] purchases = new int[numberOfPurchases];
    for(int i = 0; i < purchases.length; i++)
    {
      purchases[i] = ThreadLocalRandom.current().nextInt(MAX_PURCHASE_VALUE +
        1);
    }
    return purchases;
  }
}
