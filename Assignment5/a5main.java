//For use of the Scanner class
import java.util.Scanner;

/**This class serves to demonstrate the PigLatinator class. It prompts the user
for an English word, phrase, or sentence to be converted to Pig Latin, then
utilizes the PigLatinator class to make the conversion. When finished, the
program displays the results for the user.*/
class a5main
{

  /**The main method.*/
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    boolean repeat = true;
    String latin = null;
    while(repeat)
    {
      System.out.print("Enter an English word, phrase, or sentence to " +
        "convert to Pig Latin: ");
      String input = keyboard.nextLine();
      try
      {
        latin = PigLatinator.pigLatinate(input);
        repeat = false;
      }
      catch(Exception e)
      {
        System.out.println("Please enter valid input.\n");
      }
    }
    System.out.println("Input converted to Pig Latin:\n" + latin);
  }
}
