class a4main
{
  static FuelGauge fuelGauge;
  static Odometer odometer;

  public static void main(String[] args)
  {
    fuelGauge = new FuelGauge();
    odometer = new Odometer(fuelGauge);

    fillCar();

    System.out.println("Going for a drive...");
    while(!fuelGauge.isEmpty())
    {
      driveCar();
    }

    System.out.println("\nThe car is out of fuel.");
  }


  public static void fillCar()
  {
    System.out.println("Filling the fuel tank...");
    while(!fuelGauge.isFull())
    {
      try
      {
        fuelGauge.addFuel();
      }
      catch(Exception e)
      {
        e.printStackTrace();
        System.exit(1);
      }
      int gallons = fuelGauge.getCurrentFuelAmount();
      if(gallons == 1)
      {
        System.out.println("Fuel tank has " + gallons + " gallon.");
      }
      else
      {
        System.out.println("Fuel tank has " + gallons + " gallons.");
      }
    }

    System.out.println("The fuel tank is full.\n");
  }


  public static void driveCar()
  {
    try
    {
      odometer.driveMile();
    }
    catch(Exception e)
    {
      e.printStackTrace();
      System.exit(1);
    }
    System.out.println("Car odometer: " + odometer.getMileage() +
      "\nApproximate gallons of fuel remaining: " +
      fuelGauge.getCurrentFuelAmount());
  }
}
