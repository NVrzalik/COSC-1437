import java.util.concurrent.ThreadLocalRandom;

class a3main
{

  static int[][] testArray;
  static int firstDLength, secondDlength;
  static final int MAX_LENGTH = 10;
  static final int MAX_VALUE = 50;

  public static void main(String[] args)
  {
    firstDLength = ThreadLocalRandom.current().nextInt(1, MAX_LENGTH + 1);
    testArray = new int[firstDLength][];

    for(int i = 0; i < firstDLength; i++)
    {
      secondDlength = ThreadLocalRandom.current().nextInt(1, MAX_LENGTH + 1);
      testArray[i] = new int[secondDlength];
      
      for(int j = 0; j < secondDlength; j++)
      {
        testArray[i][j] = ThreadLocalRandom.current().nextInt(MAX_VALUE + 1);
      }
    }
  }
