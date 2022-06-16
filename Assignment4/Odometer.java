class Odometer
{
  private int mileage, fuelMileCounter;
  private final int MAX_MILEAGE = 999999;
  private final int MILES_PER_GALLON = 24;
  private FuelGauge fuelGauge;


  public Odometer() throws Exception
  {
    try
    {
      fuelGauge = new FuelGauge();
    }
    catch(Exception e)
    {
      throw new Exception("FuelGauge class could not be located", e);
    }
  }


  public int getMileage()
  {
    return mileage;
  }


  private int getFuelMileCounter()
  {
    return fuelMileCounter;
  }


  private void addMile()
  {
    mileage++;
    if(this.getMileage() == MAX_MILEAGE)
    {
      this.resetOdometer();
    }
  }


  private void addFuelMileCounter()
  {
    fuelMileCounter++;
    if(this.getFuelMileCounter() == MILES_PER_GALLON)
    {
      try
      {
        fuelGauge.useFuel();
      }
      catch(Exception e)
      {
        e.printStackTrace();
        System.exit(1);
      }
      this.resetFuelMileCounter();
    }
  }


  private void resetFuelMileCounter()
  {
    fuelMileCounter = 0;
  }


  private void resetOdometer()
  {
    mileage = 0;
  }


  public void driveMile() throws Exception
  {
    if(fuelGauge.isEmpty())
    {
      throw new Exception("Fuel tank is empty; mile could not be driven");
    }
    this.addMile();
    this.addFuelMileCounter();
  }
}
