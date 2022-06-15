//For generating random integers
import java.util.concurrent.ThreadLocalRandom;
/**This class serves to demonstrate the ArrayOperations2D class methods. In lieu
of accepting user input with which to initialize a test array, the assignment
specifications requested that the class itself generate the array. This class
initializes a randomly sized jagged 2D array of randomly generated integers with
which to test the ArrayOperations2D class, then calls the ArrayOperations2D
class methods for demonstration, displaying the results for the user.*/
class a3main
{

  //Variable to hold a 2D array of integers to be randomly sized and populated
  static int[][] testArray;
  //Variable to hold the lengths of the outer and inner arrays
  static int outerLength, innerLength;
  //The maximum length of the outer and inner arrays
  static final int MAX_LENGTH = 10;
  //The maximum value of an element within the array
  static final int MAX_VALUE = 50;
  /**The main method.*/
  public static void main(String[] args)
  {
    //Randomly generate the size of the outer array
    outerLength = ThreadLocalRandom.current().nextInt(MAX_LENGTH + 1);
    //Initialize outer array
    testArray = new int[outerLength][];
    System.out.println("Array has " + outerLength + " row(s).");
    //Iterate through outer array, randomly sizing each inner array
    for(int i = 0; i < outerLength; i++)
    {
      //Randomly generate the size of the current inner array
      innerLength = ThreadLocalRandom.current().nextInt(MAX_LENGTH + 1);
      //Initialize current inner array
      testArray[i] = new int[innerLength];
      System.out.println("Row " + (i + 1) + " has " + innerLength +
      " column(s).");
      //Iterate through current inner array, populating it with random integers
      for(int j = 0; j < innerLength; j++)
      {
        //Assign random integer value
        testArray[i][j] = ThreadLocalRandom.current().nextInt(MAX_VALUE + 1);
        System.out.print(testArray[i][j] + " ");
        if(j + 1 == innerLength)
        {
          System.out.println();
        }
      }
    }
    //Call each ArrayOperations2D class method, and display the results
    displayTotal();
    displayAverage();
    displayRowTotal();
    displayColumnTotal();
    displayHighestInRow();
    displayLowestInRow();
  }


  /**Void method to display the sum total of all elements within the generated
  2D array of integers. Utilizes method from ArrayOperations2D class.*/
  public static void displayTotal()
  {
    int total = ArrayOperations2D.getTotal(testArray);
    System.out.println("Total of all array elements is: " + total);
  }


  /**Void method to display the average of all elements within the generated
  2D array of integers. Utilizes method from ArrayOperations2D class.*/
  public static void displayAverage()
  {
    double average = ArrayOperations2D.getAverage(testArray);
    System.out.println("Average of all array elements is: " + average);
  }


  /**Void method to display the sum total of all elements within a particular
  row of the generated 2D array of integers. Utilizes method from
  ArrayOperations2D class. Contains logic to correctly format the results if
  the randomly selected row produces exceptions in ArrayOperations2D.*/
  public static void displayRowTotal()
  {
    //Generate random row number
    int subscript = ThreadLocalRandom.current().nextInt(MAX_LENGTH);
    //Display the row total
    try
    {
      int rowTotal = ArrayOperations2D.getRowTotal(testArray, subscript);
      System.out.println("Total of elements in row " + (subscript + 1) + ": " +
      rowTotal);
    }
    //If the row does not exist in the array, notify the user
    catch(IllegalArgumentException e)
    {
      System.out.println("The requested row number, (row " + (subscript + 1) +
      "), does not exist in the array. Therefore, the total for the elements" +
      " in the row cannot be calculated.");
    }
  }


  /**Void method to display the sum total of all elements within a particular
  column of the generated 2D array of integers. Utilizes method from
  ArrayOperations2D class. Contains logic to correctly format the results if
  the randomly selected column produces exceptions in ArrayOperations2D.*/
  public static void displayColumnTotal()
  {
    //Generate random column number
    int subscript = ThreadLocalRandom.current().nextInt(MAX_LENGTH);
    //Display the column total
    try
    {
      int columnTotal = ArrayOperations2D.getColumnTotal(testArray, subscript);
      System.out.println("Total of elements in column " + (subscript + 1) +
      ": " + columnTotal);
    }
    //If the column does not exist in the array, notify the user
    catch(IllegalArgumentException e)
    {
      System.out.println("The requested column number, (column " +
      (subscript + 1) + "), does not exist in the array. Therefore, the " +
      "total for the elements in the column cannot be calculated.");
    }
  }


  /**Void method to display the highest value integer within a particular row of
  the generated 2D array of integers. Utilizes method from ArrayOperations2D
  class. Contains logic to correctly format the results if the randomly selected
  row produces exceptions in ArrayOperations2D.*/
  public static void displayHighestInRow()
  {
    //Generate random row number
    int subscript = ThreadLocalRandom.current().nextInt(MAX_LENGTH);
    //Display the highest integer value contained in the row
    try
    {
      int rowHighest = ArrayOperations2D.getHighestInRow(testArray, subscript);
      System.out.println("Greatest element in row " + (subscript + 1) +
      ": " + rowHighest);
    }
    //If the row does not exist in the array, notify the user
    catch(IllegalArgumentException e)
    {
      System.out.println("The requested row number, (row " +
      (subscript + 1) + "), does not exist in the array. There is therefore" +
      " no element in the row with a highest value.");
    }
    //If the row is empty, notify the user
    catch(Exception e)
    {
      System.out.println("The requested row number, (row " +
      (subscript + 1) + "), is empty. There is therefore no element in the " +
      "row with a highest value.");
    }
  }


  /**Void method to display the lowest value integer within a particular row of
  the generated 2D array of integers. Utilizes method from ArrayOperations2D
  class. Contains logic to correctly format the results if the randomly selected
  row produces exceptions in ArrayOperations2D.*/
  public static void displayLowestInRow()
  {
    //Generate random row number
    int subscript = ThreadLocalRandom.current().nextInt(MAX_LENGTH);
    //Display the lowest integer value contained in the row
    try
    {
      int rowLowest = ArrayOperations2D.getLowestInRow(testArray, subscript);
      System.out.println("Lowest element in row " + (subscript + 1) +
      ": " + rowLowest);
    }
    //If the row does not exist in the array, notify the user
    catch(IllegalArgumentException e)
    {
      System.out.println("The requested row number, (row " +
    (subscript + 1) + "), does not exist in the array. There is therefore " +
    "no element in the row with a lowest value.");
    }
    //If the row is empty, notify the user
    catch(Exception e)
    {
      System.out.println("The requested row number, (row " +
      (subscript + 1) + "), is empty. There is therefore no element in the " +
      "row with a lowest value.");
    }
  }
}
