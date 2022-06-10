/**This class serves to demonstrate the Coin class by way of a game called
"Tossing Coins for a Dollar". It instantiates three simulated coins of varying
value, and tosses them until the accumulated value reaches $1 (only coins that
land heads up contribute to the accumulated value). If the final value is
exactly $1, the user wins; if the value exceeds $1, the user loses the game.*/
class a1main
{
  //Declare Coin variables with global scope
  static Coin quarter, dime, nickel;
  //Declare int variables with global scope to hold the current accumulated
  //value and the number of turns taken.
  static int balance, turns;

  /**Main method.*/
  public static void main(String[] args)
  {
    //Instantiate Coin objects to represent a quarter, dime, and nickel
    quarter = new Coin();
    dime = new Coin();
    nickel = new Coin();
    //Initialize balance and turns to zero
    balance = 0;
    turns = 0;
    //While the balance is less than $1, take a turn
    while(balance < 100)
    {
      takeTurn();
    }
    //Once $1 is reached, end the game
    gameEnd();
  }

  /**Void method the take a turn. It uses the Coin class to toss the coins,
  then checks to see which sides are facing up. Whenever a heads side is up,
  the value of the coin is added to the accumulated value. After the turn is
  finished, the turn count is incremented.*/
  static void takeTurn()
  {
    quarter.toss();
    dime.toss();
    nickel.toss();
    if(quarter.getSideUp() == "heads")
    {
      balance += 25;
    }
    if(dime.getSideUp() == "heads")
    {
      balance += 10;
    }
    if(nickel.getSideUp() == "heads")
    {
      balance += 5;
    }
    turns++;
  }

  /**Void method to end the game and print the results for the user.*/
  static void gameEnd()
  {
    //Display the number of turns taken
    System.out.println("You took " + turns + " turns.");
    //If the accumulated value is exactly $1, the user wins
    if(balance == 100)
    {
      System.out.println("You threw a dollar! You win!");
    }
    //Otherwise, the user loses the game
    else
    {
      double amount = balance / 100.0;
      System.out.printf("You threw $%.2f. You lost.\n", amount);
    }
  }
}
