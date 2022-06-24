/**This class serves to simulate a person for the purposes of retail customer
information. The class stores data holding a person's first and last name,
their phone number, and their address. Multiple constructors are provided so
that the phoneNumber and address fields are optional. Public facing mutator and
accessor methods are provided.*/
class Person
{
  private String firstName;
  private String lastName;
  private String phoneNumber;
  private String address;
  private final int PHONE_NUMBER_LENGTH = 10;

  /**A version of the class constructor. It accepts arguments for all non-final
  fields, and utilizes class methods to set the fields. An exception is thrown
  if any of passed parameters are invalid.
  @param firstName The person's first name.
  @param lastName The person's last name.
  @param phoneNumber The person's phone number.
  @param address The person's address.*/
  public Person(String firstName, String lastName, String phoneNumber,
    String address) throws Exception
  {
    setFirstName(firstName);
    setLastName(lastName);
    setPhoneNumber(phoneNumber);
    setAddress(address);
  }

  /**A version of the class constructor. It accepts arguments for the person's
  first name, last name, and either their phone number or address. A boolean
  argument determines which of the fields (phoneNumber or address) is to be
  populated with the passed String. The constructor utilizes class methods to
  set the fields. An exception is thrown if any of passed parameters are
  invalid.
  @param firstName The person's first name.
  @param lastName The person's last name.
  @param flag A boolean flag to determine whether the phoneNumber or address
  field is to be populated.
  @param phoneOrAddress The person's phone number or address.*/
  public Person(String firstName, String lastName, boolean flag,
    String phoneOrAddress) throws Exception
  {
    setFirstName(firstName);
    setLastName(lastName);

    if(flag == false)
    {
      setPhoneNumber(phoneOrAddress);
    }
    else
    {
      setAddress(phoneOrAddress);
    }
  }

  /**A version of the class constructor. It accepts arguments for the firstName
  and lastName fields, and utilizes class methods to set them.
  @param firstName The person's first name. An exception is thrown if any of
  passed parameters are invalid.
  @param lastName The person's last name.*/
  public Person(String firstName, String lastName) throws Exception
  {
    setFirstName(firstName);
    setLastName(lastName);
  }

  /**A private method to determine whether or not a passed name is valid. Null
  or empty strings are not permitted, nor are any characters other than letters
  or apostrophes.
  @param name The name to be validated.
  @return True if the name is valid, false if not.*/
  private boolean nameIsValid(String name)
  {
    if(name == null || name.length() == 0)
    {
      return false;
    }
    char[] check = name.toCharArray();

    for(int i = 0; i < check.length; i++)
    {
      if(!Character.isLetter(check[i]) && check[i] != '\'')
      {
        return false;
      }
    }
    return true;
  }

  /**A private method to determine whether or not a passed phone number is
  valid. Null strings are not permitted, nor are any phone numbers with any
  number of digits other than 10. Only digit characters are permitted.
  @param phoneNumber The phone number to be validated.
  @return True if the phone number is valid, false if not.*/
  private boolean phoneNumberIsValid(String phoneNumber)
  {
    if(phoneNumber == null || phoneNumber.length() != PHONE_NUMBER_LENGTH)
    {
      return false;
    }

    char[] check = phoneNumber.toCharArray();

    for(int i = 0; i < PHONE_NUMBER_LENGTH; i++)
    {
      if(!Character.isDigit(check[i]))
      {
        return false;
      }
    }
    return true;
  }

  /**A private method to determine whether or not a passed address is valid.
  Null or empty strings are not permitted.
  @param name The address to be validated.
  @return True if the address is valid, false if not.*/
  private boolean addressIsValid(String address)
  {
    /*As the time and resources needed to implement an API to validate physical
    addresses isn't available with our time-window, and as it's beyond the scope
    of the course, I've chosen not to complete this method here. I intend to
    come back when time is available to find and correctly implement an API for
    this purpose.*/
    if(address != null && !address.trim().isEmpty())
    {
      return true;
    }
    else
    {
      return false;
    }
  }

  /**Public method to set the firstName field. Throws an exception if the name
  is invalid.
  @param firstName The name to be validated and set as the person's first name.
  */
  public void setFirstName(String firstName) throws Exception
  {
    if(nameIsValid(firstName))
    {
      this.firstName = firstName;
    }
    else
    {
      throw new Exception("Invalid first name");
    }
  }

  /**Public method to set the lastName field. Throws an exception if the name
  is invalid.
  @param lastName The name to be validated and set as the person's last name.*/
  public void setLastName(String lastName) throws Exception
  {
    if(nameIsValid(lastName))
    {
      this.lastName = lastName;
    }
    else
    {
      throw new Exception("Invalid last name");
    }
  }

  /**Public method to set the phoneNumber field. Throws an exception if the
  phone number is invalid.
  @param phoneNumber The phone number to be validated and set as the person's
  phone number.*/
  public void setPhoneNumber(String phoneNumber) throws Exception
  {
    if(phoneNumberIsValid(phoneNumber))
    {
      this.phoneNumber = phoneNumber;
    }
    else
    {
      throw new Exception("Invalid phone number");
    }
  }

  /**Public method to set the address field. Throws an exception if the address
  is invalid.
  @param address The address to be validated and set as the person's address.*/
  public void setAddress(String address) throws Exception
  {
    if(addressIsValid(address))
    {
      this.address = address;
    }
    else
    {
      throw new Exception("Invalid address");
    }
  }

  /**Public accessor method to retrieve the person's first name.
  @return The person's first name.*/
  public String getFirstName()
  {
    return this.firstName;
  }

  /**Public accessor method to retrieve the person's last name.
  @return The person's last name.*/
  public String getLastName()
  {
    return this.lastName;
  }

  /**Public accessor method to retrieve the person's phone number.
  @return The person's phone number.*/
  public String getPhoneNumber() throws Exception
  {
    if(phoneNumberIsValid(this.phoneNumber))
    {
      return this.phoneNumber;
    }
    else
    {
      throw new Exception("Phone number has not been set");
    }
  }

  /**Public accessor method to retrieve the person's address.
  @return The person's address.*/
  public String getAddress() throws Exception
  {
    if(addressIsValid(this.address))
    {
      return this.address;
    }
    else
    {
      throw new Exception("Address has not been set");
    }
  }
}
