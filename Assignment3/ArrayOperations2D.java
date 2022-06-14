class ArrayOperations2D
{

  public static int getTotal(int[][] array)
  {
    if(array.length == 0)
    {
      throw new Exception("Array argument is empty.");
    }
    //return the total of all values in the array
    int total = 0;
    try
    {
      for(int i = 0; i < array.length; i++)
      {
        for(int j = 0; j < array[i].length; j++)
        {
          total += testArray[i][j];
        }
      }
    }
    return total;
  }



}
