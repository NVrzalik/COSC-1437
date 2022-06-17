/**This class serves to demonstrate the FuelGauge and Odometer classes, per
the specifications of the project assignment. Both a FuelGauge object and a
Odometer object are instantiated, and the FuelGauge object is passed as an
argument to the Odometer constructor method.
The assignment guidelines specify that the fuel tank of the simulated automobile
is to be filled, after which the automobile is to be driven until the fuel tank
is empty. Once the fuel tank is empty, the program ends.*/
class a4main
{
  //Variable to hold the address of the FuelGauge object
  static FuelGauge fuelGauge;
  //Variable to hold the address of the Odometer object
  static Odometer odometer;

  /**Main method.*/
  public static void main(String[] args)
  {
    //Instantiate FuelGauge object
    fuelGauge = new FuelGauge();
    //Instantiate Odometer object, passing fuelGauge as an argument
    odometer = new Odometer(fuelGauge);
    //Fill the fuel tank
    fillFuelTank();
    //Drive the automobile until the fuel tank is empty
    driveCar();
  }

  /**Method to simulate filling the automobile's fuel tank until full, utilizing
  the FuelGauge class' isFull(), addFuel(), and getCurrentFuelAmount() methods.
  The method also contains logic to correctly format the status updates printed
  while filling the fuel tank.*/
  public static void fillFuelTank()
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

  /**Method to simulate driving the automobile until the fuel tank is empty,
  utilizing methods of the FuelGauge and Odometer classes. Per assignment
  specifications, the current mileage of the odometer and the approximate
  number of gallons of fuel remaining in the fuel tank are displayed for every
  mile driven.*/
  public static void driveCar()
  {
    System.out.println("Going for a drive...");
    while(!fuelGauge.isEmpty())
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
      System.out.printf("Car odometer: %06d\n" +
        "Approximate gallons of fuel remaining: %d\n\n",
        odometer.getMileage(), fuelGauge.getCurrentFuelAmount());
    }
    System.out.println("\nThe car is out of fuel.");
  }
}
