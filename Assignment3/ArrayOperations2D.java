class ArrayOperations2D
{

  public ArrayOperations2D()
  {
    //2D int array needs to be internally initialized, not passed as an argument
    //when the class is instantiated. In the constructor, initialize a 2D array
    //using random integers. Random elements and size.
  }



  public int getTotal(int[][] array)
  {
    //return the total of all values in the array
    int total = 0;
    try
    {
      for(int i = 0; i < array.length; i++)
      {
        for(int j = 0; j < array[i].length; j++)
        {
          total += array[i][j];
        }
      }
    }
    //Possible exceptions: array is null; array is 1D; array values are
    //not ints
    //Temporary catch until further refined
    catch(Exception e)
    {
      //Set error message to "Invalid array argument." until further refined
      throw new Exception("Invalid array argument.")
    }
    return total;
  }
}
