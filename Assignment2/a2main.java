//For user input and reading data from file
import java.util.Scanner;
//For dynamic array
import java.util.ArrayList;
//For file interaction
import java.io.*;

/**This class determines how many times an MLB team has won the World Series
between the years of 1903 and 2009. The program reads this data from an external
file. The user is prompted to provide the name of an MLB team to search for, and
the program returns the number of times they've won the World Series, if any.
The user is then asked if they would like to search again for another team.*/
class a2main
{
  //Constant to hold the name of the file that the data will be read from
  static final String FILENAME = "WorldSeriesWinners.txt";

  /**Main method*/
  public static void main(String[] args)
  {
    //Initialize array of Strings to "null" to allow for try-catch block
    String[] champions = null;
    //Attempt to scan the data from the file into an array
    try
    {
      champions = scanFile();
    }
    catch(FileNotFoundException e)
    {
      System.out.println("The necessary file could not be located.");
      System.exit(1);
    }
    catch(IOException e)
    {
      System.out.println("The necessary file could not be accessed.");
      System.exit(1);
    }
    catch(Exception e)
    {
      System.out.println(e.getMessage());
      System.exit(1);
    }

    do
    {
      //Prompt the user for a team name
      String team = requestTeam();
      //Find the number of times the team has won
      int wins = findWins(team, champions);
      //Display the number of wins for the user
      displayWins(wins, team);
    //If the user wishes, search again for another team
    } while (goAgain());
  }

  /**Method to scan the data from the input file into an array of Strings. It
  utilizes an ArrayList to dynamically enlarge the array as new data is read
  from the file. All exceptions are thrown.
  @return An array of Strings, listing the name of the winning team of each
  World Series from 1903 to 2009.*/
  static String[] scanFile() throws FileNotFoundException, IOException,
                                    Exception
  {
    //Create File object of the constant filename
    File file = new File(FILENAME);
    //Create Scanner object utilizing the file
    Scanner inputFile = new Scanner(file);
    //Declare ArrayList of type String to hold the names of winning teams
    ArrayList<String> champions = new ArrayList<String>();

    /*While there is still data to be read from the file, add the next line to
    the array.*/
    while(inputFile.hasNext())
    {
      String name = inputFile.nextLine();
      champions.add(name);
    }
    inputFile.close();

    /*If the ArrayList is empty, and the file operations above threw no
    exceptions, the input file must be empty.*/
    if(champions.isEmpty())
    {
      throw new Exception("Input file is empty.");
    }

    //Convert the ArrayList to a String[], then return
    String[] championsArray = new String[champions.size()];
    championsArray = champions.toArray(championsArray);
    return championsArray;
  }

  /**Method to request a team name to seach for from the user. The request will
  be repeated until input from the user is received.
  @return The name of the team to search for.*/
  static String requestTeam()
  {
    //Initialize name of team to null
    String team = null;
    //Until a name is provided by the user, continue to request a name
    do
    {
      System.out.println("Please enter the full name of a team to search " +
                          "for: ");
      //Call to class defined method to obtain user input
      team = getInput();
    } while (team.isEmpty());
    return team;
  }

  /**Method to obtain input from the user. Utilizes System.in to obtain input.
  @return The String input from the user.*/
  static String getInput()
  {
    //Instantiate Scanner object for System.in
    Scanner keyboard = new Scanner(System.in);
    //Obtain user input from console
    String input = keyboard.nextLine();
    return input;
  }

  /**Method to count the number of World Series wins a team has had, utilizing
  the data scanned from the input file.
  @param team The team chosen by the user
  @param champions The array of winning teams
  @return The number of wins the given team has had.*/
  static int findWins(String team, String[] champions)
  {
    //Accumulator for number of wins
    int wins = 0;
    //Iterate through scanned array, counting repititions of team name
    for(int i = 0; i < champions.length; i++)
    {
      if(champions[i].equalsIgnoreCase(team))
      {
        wins++;
      }
    }
    return wins;
  }

  /**Void method to display the number of wins a particular team has had for
  the user. Contains simple logic to format the displayed message.
  @param wins The number of team wins
  @param team The team chosen by the user*/
  static void displayWins(int wins, String team)
  {
    if(wins > 0)
    {
      System.out.println("The " + team + " have won " + wins + " World Series" +
                          " during the period spanning from 1903 to 2009.");
    }
    else
    {
      System.out.println("This team hasn't won any World Series from 1903 " +
                          "to 2009.");
    }
  }

  /**Method to determine whether the user would like to run the program again.
  It will prompt the user until valid input is received.
  @return True if the user wants to repeat the program; false if not.*/
  static boolean goAgain()
  {
    String answer;
    do
    {
      System.out.println("Would you like to search for another team? " +
                        "(Yes or No)");
      answer = getInput();
    } while(!answer.equalsIgnoreCase("Yes") && !answer.equalsIgnoreCase("No"));

    if(answer.equalsIgnoreCase("Yes"))
    {
      return true;
    }
    else
    {
      return false;
    }
  }
}
