//For random number generation
import java.util.Random;

/**This class simulates a coin to be flipped. It has a String field to store
the name of the side currently facing up, and it utilizes a Random object to
simulate a coin toss. It includes two methods: one to toss the coin, and another
to return the name of the side facing up.*/
class Coin
{
  //Private String to hold the name of the side facing up
  private String sideUp;
  //Instantiate Random object for use in coin toss
  private Random random = new Random();

  /**No-arg constructor. It calls the internal toss() method to initialize
  sideUp.*/
  public Coin()
  {
    toss();
  }

  /**Void method to simulate a coin toss. It utilizes the instantiated Random
  object to randomly choose a side to face up, and assigns the value to
  sideUp.*/
  public void toss()
  {
    int side = random.nextInt(2);
    if(side == 0)
    {
      sideUp = "heads";
    }
    else
    {
      sideUp = "tails";
    }
  }

  /**Method to return the name of the coin side currently facing up.
  @return The current value of sideUp.*/
  public String getSideUp()
  {
    return sideUp;
  }
}
