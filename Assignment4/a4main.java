class a4main
{
  static FuelGauge fuelGauge;
  static Odometer odometer;

  public static void main(String[] args)
  {
    FuelGauge fuelGauge = new FuelGauge();
    Odometer odometer = new Odometer(fuelGauge);

    fillCar();

    while(!fuelGauge.isEmpty())
    {
      driveCar();
    }

    System.out.println("The car is out of fuel.");
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
      System.out.println("Fuel tank has " + fuelGauge.getCurrentFuelAmount() +
        " gallons.");
    }

    System.out.println("The fuel tank is full.");
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
    System.out.println("Car odometer: " + odometer.getMileage() + " miles" +
      "\nApproximate fuel remaining: " + fuelGauge.getCurrentFuelAmount() +
      " gallons");
  }
}
