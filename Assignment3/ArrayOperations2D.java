class ArrayOperations2D
{

  public static int getTotal(int[][] array)
  {
    //return the total of all values in the array
    int total = 0;

    for(int i = 0; i < array.length; i++)
    {
      for(int j = 0; j < array[i].length; j++)
      {
        total += testArray[i][j];
      }
    }
    return total;
  }


  public static double getAverage(int[][] array)
  {
    int total = getTotal(array);
    int count = 0;

    for(int i = 0; i < array.length; i++)
    {
      count += array[i].length;
    }

    double average = (total / 1.0) / count;
    return average;
  }
}
