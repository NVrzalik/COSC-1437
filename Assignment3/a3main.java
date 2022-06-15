import java.util.concurrent.ThreadLocalRandom;

class a3main
{

  static int[][] testArray;
  static int firstDLength, secondDlength;
  static final int MAX_LENGTH = 10;
  static final int MAX_VALUE = 50;

  public static void main(String[] args) throws Exception
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

    System.out.println("Total of all array elements is: " + ArrayOperations2D.getTotal(testArray));
    System.out.println("Average of all array elements is: " + ArrayOperations2D.getAverage(testArray));
    System.out.println("Total of elements in row " + 1 + ": " + ArrayOperations2D.getRowTotal(testArray, 5));
    System.out.println("Total of elements in column " + 1 + ": " + ArrayOperations2D.getColumnTotal(testArray, 5));
    System.out.println("Greatest element in row " + 1 + ": " + ArrayOperations2D.getHighestInRow(testArray, 5));
    System.out.println("Lowest element in row " + 1 + ": " + ArrayOperations2D.getLowestInRow(testArray, 5));
  }
}
