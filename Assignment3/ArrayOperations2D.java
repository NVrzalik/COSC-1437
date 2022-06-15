/**This class is intended to demonstrate various operations performed on jagged
2D integer arrays. The class need not be instantiated; all methods require a 2D
array as a parameter.*/
class ArrayOperations2D
{

  /**Method to calculate the total of all elements held within a 2D integer
  array.
  @param array A 2D integer array.
  @return The total of all the integers within the array.*/
  public static int getTotal(int[][] array)
  {
    //Accumlator to count running total of integers
    int total = 0;
    //Iterate through array and sum elements
    for(int i = 0; i < array.length; i++)
    {
      for(int j = 0; j < array[i].length; j++)
      {
        total += array[i][j];
      }
    }
    return total;
  }


  /**Method to calculate the average of all elements held within a 2D integer
  array.
  @param array A 2D integer array.
  @return The average of all the integers within the array.*/
  public static double getAverage(int[][] array)
  {
    //Call getTotal() to calculate the total sum of the array elements
    int total = getTotal(array);
    //Accumlator to count the number of elements in the array
    int count = 0;
    //Iterate through array to count total number of elements
    for(int i = 0; i < array.length; i++)
    {
      count += array[i].length;
    }
    //If there are no elements in the array, the average is 0
    if(count == 0)
    {
      return 0;
    }
    //Otherwise, calculate the average value
    else
    {
      double average = (total / 1.0) / count;
      return average;
    }
  }


  /**Method to calculate the total of all elements held within a particular row
  of a 2D integer array. Exceptions are thrown if the passed subscript is out of
  bounds or negative.
  @param array A 2D integer array.
  @param subscript The subscript of the row whose elements are to be totaled.
  @return The total of all the integers within the row.*/
  public static int getRowTotal(int[][] array, int subscript) throws
  IllegalArgumentException
  {
    //If the row doesn't exist within the array, throw exception
    if(subscript >= array.length)
    {
      throw new IllegalArgumentException("Given subscript does not exist");
    }
    //If the passed subscript is negative, throw exception
    if(subscript < 0)
    {
      throw new IllegalArgumentException("Negative subscript");
    }
    //Accumlator for running total of row
    int total = 0;
    //Iterate through array and sum elements
    for(int i = 0; i < array[subscript].length; i++)
    {
      total += array[subscript][i];
    }
    return total;
  }


  /**Method to calculate the total of all elements held within a particular
  column of a 2D integer array. Exceptions are thrown if the passed subscript is
  out of bounds or negative. The method will accept jagged arrays.
  @param array A 2D integer array.
  @param subscript The subscript of the column whose elements are to be totaled.
  @return The total of all the integers within the column.*/
  public static int getColumnTotal(int[][] array, int subscript) throws
  IllegalArgumentException
  {
    //If the passed subscript is negative, throw exception
    if(subscript < 0)
    {
      throw new IllegalArgumentException("Negative subscript");
    }
    ////Accumlator for running total of column
    int total = 0;
    /*Flag to track if the passed array has a column of the passed subscript,
    defaulted to true (for an error)*/
    boolean error = true;
    //Iterate through array and sum elements
    for(int i = 0; i < array.length; i++)
    {
      if(subscript < array[i].length)
      {
        total += array[i][subscript];
        /*If a value is added to the total, then the column exists within the
        array, and the flag is set to false (for no error)*/
        error = false;
      }
    }
    //If the column does not exist within the array, throw exception
    if(error == true)
    {
      throw new IllegalArgumentException("Given subscript does not exist.");
    }
    return total;
  }


  /**Method to return the element with the greatest value within a particular
  row of a 2D integer array. Exceptions are thrown if the passed subscript is
  out of bounds or negative, or if the selected row is empty.
  @param array A 2D integer array.
  @param subscript The subscript for the row to be searched for the highest
  value element.
  @return The highest value integer within the row.*/
  public static int getHighestInRow(int[][] array, int subscript) throws
  Exception, IllegalArgumentException
  {
    //If the row does not exist within the array, throw exception
    if(subscript >= array.length)
    {
      throw new IllegalArgumentException("Given subscript does not exist");
    }
    //If the passed subscript is negative, throw exception
    if(subscript < 0)
    {
      throw new IllegalArgumentException("Negative subscript");
    }
    //If the selected row exists, but is empty, throw exception
    if(array[subscript] == null)
    {
      throw new Exception("Selected row is empty");
    }
    /*Variable to hold the highest integer value in the row, defaulted to the
    first element*/
    int highest = array[subscript][0];
    //Iterate through row, searching for the highest value
    for(int i = 1; i < array[subscript].length; i++)
    {
      if(array[subscript][i] > highest)
      {
        highest = array[subscript][i];
      }
    }
    return highest;
  }


  /**Method to return the element with the lowest value within a particular
  row of a 2D integer array. Exceptions are thrown if the passed subscript is
  out of bounds or negative, or if the selected row is empty.
  @param array A 2D integer array.
  @param subscript The subscript for the row to be searched for the lowest
  value element.
  @return The lowest value integer within the row.*/
  public static int getLowestInRow(int[][] array, int subscript) throws
  Exception, IllegalArgumentException
  {
    //If the row does not exist within the array, throw exception
    if(subscript >= array.length)
    {
      throw new IllegalArgumentException("Given subscript does not exist");
    }
    //If the passed subscript is negative, throw exception
    if(subscript < 0)
    {
      throw new IllegalArgumentException("Negative subscript");
    }
    //If the selected row exists, but is empty, throw exception
    if(array[subscript] == null)
    {
      throw new Exception("Selected row is empty");
    }
    /*Variable to hold the highest integer value in the row, defaulted to the
    first element*/
    int lowest = array[subscript][0];
    //Iterate through row, searching for the lowest value
    for(int i = 1; i < array[subscript].length; i++)
    {
      if(array[subscript][i] < lowest)
      {
        lowest = array[subscript][i];
      }
    }
    return lowest;
  }
}
