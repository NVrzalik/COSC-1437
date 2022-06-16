class FuelGauge
{
  private int currentFuelAmount;
  private final int MAX_FUEL = 15;


  public int getCurrentFuelAmount()
  {
    return currentFuelAmount;
  }


  public void addFuel() throws Exception
  {
    if(currentFuelAmount == MAX_FUEL)
    {
      throw new Exception("Fuel tank is already full (or " +
                "nearly full); no fuel can be added");
    }
    currentFuelAmount++;
  }


  public void useFuel() throws Exception
  {
    if(currentFuelAmount == 0)
    {
      throw new Exception("Fuel tank is empty; no fuel can be used");
    }
    currentFuelAmount--;
  }
}
