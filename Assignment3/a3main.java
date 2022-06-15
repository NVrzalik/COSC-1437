import java.util.concurrent.ThreadLocalRandom;

class a3main
{

  static int[][] testArray;
  static int firstDLength, secondDlength;
  static final int MAX_LENGTH = 10;
  static final int MAX_VALUE = 50;

  public static void main(String[] args)
  {
    firstDLength = ThreadLocalRandom.current().nextInt(MAX_LENGTH + 1);
    testArray = new int[firstDLength][];
    System.out.println("Array has " + firstDLength + " row(s).");

    for(int i = 0; i < firstDLength; i++)
    {
      secondDlength = ThreadLocalRandom.current().nextInt(MAX_LENGTH + 1);
      testArray[i] = new int[secondDlength];
      System.out.println("Row " + (i + 1) + " has " + secondDlength + " column(s).");

      for(int j = 0; j < secondDlength; j++)
      {
        testArray[i][j] = ThreadLocalRandom.current().nextInt(MAX_VALUE + 1);
        System.out.print(testArray[i][j] + " ");
        if(j + 1 == secondDlength)
        {
          System.out.println();
        }
      }
    }

    displayTotal();
    displayAverage();
    displayRowTotal();
    displayColumnTotal();
    displayHighestInRow();
    displayLowestInRow();
  }



  public static void displayTotal()
  {
    int total = ArrayOperations2D.getTotal(testArray);
    System.out.println("Total of all array elements is: " + total);
  }

  public static void displayAverage()
  {
    double average = ArrayOperations2D.getAverage(testArray);
    System.out.println("Average of all array elements is: " + average);
  }

  public static void displayRowTotal()
  {
    int subscript = ThreadLocalRandom.current().nextInt(MAX_LENGTH);
    try
    {
      int rowTotal = ArrayOperations2D.getRowTotal(testArray, subscript);
      System.out.println("Total of elements in row " + (subscript + 1) + ": " + rowTotal);
    }
    catch(IllegalArgumentException e)
    {
      System.out.println("The requested row number, (row " + (subscript + 1) + "), does not exist in the array. Therefore, the total for the elements in the row cannot be calculated.");
    }
  }


  public static void displayColumnTotal()
  {
    int subscript = ThreadLocalRandom.current().nextInt(MAX_LENGTH);
    try
    {
      int columnTotal = ArrayOperations2D.getColumnTotal(testArray, subscript);
      System.out.println("Total of elements in column " + (subscript + 1) + ": " + columnTotal);
    }
    catch(IllegalArgumentException e)
    {
      System.out.println("The requested column number, (column " + (subscript + 1) + "), does not exist in the array. Therefore, the total for the elements in the column cannot be calculated.");
    }
  }


  public static void displayHighestInRow()
  {
    int subscript = ThreadLocalRandom.current().nextInt(MAX_LENGTH);
    try
    {
      int rowHighest = ArrayOperations2D.getHighestInRow(testArray, subscript);
      System.out.println("Greatest element in row " + (subscript + 1) + ": " + rowHighest);
    }
    catch(IllegalArgumentException e)
    {
      System.out.println("The requested row number, (row " + (subscript + 1) + "), does not exist in the array. There is therefore no element in the row with a highest value.");
    }
    catch(Exception e)
    {
      System.out.println("The requested row number, (row " + (subscript + 1) + "), is empty. There is therefore no element in the row with a highest value.");
    }
  }


  public static void displayLowestInRow()
  {
    int subscript = ThreadLocalRandom.current().nextInt(MAX_LENGTH);
    try
    {
      int rowLowest = ArrayOperations2D.getLowestInRow(testArray, subscript);
      System.out.println("Lowest element in row " + (subscript + 1) + ": " + rowLowest);
    }
    catch(IllegalArgumentException e)
    {
      System.out.println("The requested row number, (row " + (subscript + 1) + "), does not exist in the array. There is therefore no element in the row with a lowest value.");
    }
    catch(Exception e)
    {
      System.out.println("The requested row number, (row " + (subscript + 1) + "), is empty. There is therefore no element in the row with a lowest value.");
    }
  }
}
