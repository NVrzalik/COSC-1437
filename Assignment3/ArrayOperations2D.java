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


  public static int getRowTotal(int[][] array, int subscript) throws
  IllegalArgumentException
  {
    if(subscript !< array.length)
    {
      throw new IllegalArgumentException("Given subscript does not exist");
    }
    if(subscript < 0)
    {
      throw new IllegalArgumentException("Negative subscript")
    }

    int total = 0;
    for(int i = 0; i < array[subscript].length; i++)
    {
      total += array[subscript][i];
    }

    return total;
  }


  public static int getColumnTotal(int[][] array, int subscript) throws
  IllegalArgumentException
  {
    if(subscript < 0)
    {
      throw new IllegalArgumentException("Negative subscript")
    }

    int total = 0;
    boolean error = true;
    for(int i = 0; i < array.length; i++)
    {
      if(subscript < array[i].length)
      {
        total += array[i][subscript];
        error = false;
      }
    }

    if(error == true)
    {
      throw new IllegalArgumentException("Given subscript does not exist.");
    }

    return total;
  }


  public static int getHighestInRow(int[][] array, int subscript) throws
  IllegalArgumentException
  {
    if(subscript !< array.length)
    {
      throw new IllegalArgumentException("Given subscript does not exist");
    }
    if(subscript < 0)
    {
      throw new IllegalArgumentException("Negative subscript")
    }

    int highest = 0;
    for(int i = 0; i < array[subscript].length; i++)
    {
      if(array[subscript][i] > highest)
      {
        highest = array[subscript][i];
      }
    }
    return highest;
  }
}
