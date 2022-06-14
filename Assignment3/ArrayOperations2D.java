import java.util.concurrent.ThreadLocalRandom;

class ArrayOperations2D
{

  private int[][] testArray;
  private int firstDLength, secondDlength;
  private final int MAX_LENGTH = 10;
  private final int MAX_VALUE = 50;

  public ArrayOperations2D()
  {
    //2D int array needs to be internally initialized, not passed as an argument
    //when the class is instantiated. In the constructor, initialize a 2D array
    //using random integers. Random elements and size.
    firstDLength = ThreadLocalRandom.current().nextInt(1, MAX_LENGTH + 1);
    secondDlength = ThreadLocalRandom.current().nextInt(1, MAX_LENGTH + 1);
    testArray = new int[firstDLength][secondDlength];

    for(int i = 0; i < firstDLength; i++)
    {
      for(int j = 0; j < secondDlength; j++)
      {
        testArray[i][j] = ThreadLocalRandom.current().nextInt(MAX_VALUE + 1);
      }
    }
  }



  public int getTotal()
  {
    //return the total of all values in the array
    int total = 0;
    try
    {
      for(int i = 0; i < firstDLength; i++)
      {
        for(int j = 0; j < secondDlength; j++)
        {
          total += testArray[i][j];
        }
      }
    }
    return total;
  }
}
