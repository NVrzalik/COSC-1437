class Person
{
  private String firstName;
  private String lastName;
  private String phoneNumber;
  private String address;
  private final int phoneNumberLength = 10;

  public Person(String firstName, String lastName, String phoneNumber,
    String address) throws Exception
  {
    setFirstName(firstName);
    setLastName(lastName);
    setPhoneNumber(phoneNumber);
    setAddress(address);
  }

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

  public Person(String firstName, String lastName) throws Exception
  {
    setFirstName(firstName);
    setLastName(lastName);
  }

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

  private boolean phoneNumberIsValid(String phoneNumber)
  {
    if(phoneNumber == null || phoneNumber.length() != phoneNumberLength)
    {
      return false;
    }

    char[] check = phoneNumber.toCharArray();

    for(int i = 0; i < phoneNumberLength; i++)
    {
      if(!Character.isDigit(check[i]))
      {
        return false;
      }
    }

    return true;
  }

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

  public String getFirstName()
  {
    return this.firstName;
  }

  public String getLastName()
  {
    return this.lastName;
  }

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
