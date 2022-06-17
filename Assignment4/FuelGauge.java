/**This class is a simplistic simulation of an automobile's fuel gauge. The
project specifications for this assignment detailed that the fuel gauge should
increment and decrement by units of 1 gallon, and that the maximum capacity of
the fuel tank should be 15 gallons.*/
class FuelGauge
{
  //Variable to hold the current amount of fuel in the fuel tank
  private int currentFuelAmount;
  //Maximum capacity of the fuel tank in gallons
  private final int MAX_FUEL = 15;

  /**Public method to return the current amount of fuel in the fuel tank.
  @return The current amount of fuel in gallons.*/
  public int getCurrentFuelAmount()
  {
    return currentFuelAmount;
  }

  /**Public method to simulate adding fuel to the fuel tank. An exception is
  thrown if the fuel tank is already full.*/
  public void addFuel() throws Exception
  {
    if(getCurrentFuelAmount() == MAX_FUEL)
    {
      throw new Exception("Fuel tank is already full (or " +
                "nearly full); no fuel can be added");
    }
    currentFuelAmount++;
  }

  /**Public method to simulate the automobile's consumption of fuel. An
  exception is thrown if the fuel tank is already empty.*/
  public void useFuel() throws Exception
  {
    if(this.isEmpty())
    {
      throw new Exception("Fuel tank is empty; no fuel can be used");
    }
    currentFuelAmount--;
  }

  /**Public method to report whether or not the fuel tank is empty.
  @return The method returns "true" if the fuel tank is empty.*/
  public boolean isEmpty()
  {
    if(getCurrentFuelAmount() == 0)
    {
      return true;
    }
    else
    {
      return false;
    }
  }

  /**Public method to report whether or not the fuel tank is full.
  @return The method returns "true" if the fuel tank is full.*/
  public boolean isFull()
  {
    if(getCurrentFuelAmount() == MAX_FUEL)
    {
      return true;
    }
    else
    {
      return false;
    }
  }
}
