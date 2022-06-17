/**This class serves as a simplistic simulation of an automobile's odometer.
Per the assignment specifications, the maximum mileage the odometer can track
is 999,999 miles; once this is exceeded, the odometer resets to 0. The
assignment instructions also specified that the odometer is to interact with
a FuelGauge object, decrementing the fuel gauge by one gallon of fuel for every
24 miles driven.*/
class Odometer
{
  //Private variable to hold the automobile's current mileage
  private int mileage;
  /*Private variable to track the miles driven since the fuel gauge was last
  decremented*/
  private int fuelMileCounter;
  //The maximum mileage the odometer can track, specified by the assignment
  private final int MAX_MILEAGE = 999999;
  //The fixed fuel economy of the automobile, specified by the assignment
  private final int MILES_PER_GALLON = 24;
  //The FuelGauge object the odometer will interact with
  private FuelGauge fuelGauge;

  /**Constructor method. Due to project guidelines, it deliberately assigns
  the instance fuelGauge variable the address of an externally instantiated
  FuelGauge object passed to the constructor. However, the FuelGauge object is
  designed to interact with channels outside the Odometer object, so the
  constructor does not create a security hole.*/
  public Odometer(FuelGauge fuelGauge)
  {
    this.fuelGauge = fuelGauge;
  }

  /**Public method to return the current mileage of the odometer.
  @return The current mileage of the odometer.*/
  public int getMileage()
  {
    return mileage;
  }

  /**Private method to return the current number of miles since the fuelGauge
  was last decremented.
  @return The current number of miles since the fuelGauge was last decremented.
  */
  private int getFuelMileCounter()
  {
    return fuelMileCounter;
  }

  /**Private method to add a mile to the odometer. If after incrementing, the
  mileage exceeds the maximum mileage of the odometer, the odometer is reset to
  0.*/
  private void addMile()
  {
    mileage++;
    if(this.getMileage() > MAX_MILEAGE)
    {
      this.resetOdometer();
    }
  }

  /**Private method to add a mile to the fuelMileCounter, the number of miles
  driven since the fuelGauge was last decremented. If after incrementing the
  counter, the number of miles then equals the fixed fuel economy of the
  automobile, the fuelGauge will be decremented, and the fuelMileCounter will
  be reset to 0.*/
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

  /**Private method to reset the odometer to 0.*/
  private void resetOdometer()
  {
    mileage = 0;
  }

  /**Private method to reset the fuelMileCounter to 0.*/
  private void resetFuelMileCounter()
  {
    fuelMileCounter = 0;
  }

  /**Public method to simulate driving the automobile one mile. When called,
  the method adds one mile to the odometer and to the fuelMileCounter. The
  method throws an exception if the fuel tank is empty.*/
  public void driveMile() throws Exception
  {
    if(fuelGauge.isEmpty())
    {
      this.resetFuelMileCounter();
      throw new Exception("Fuel tank is empty; mile could not be driven");
    }
    this.addMile();
    this.addFuelMileCounter();
  }
}
