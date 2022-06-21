class PigLatinator
{

  private static boolean invalidString(String input)
  {
    if(input == null || input.trim().isEmpty())
    {
      return true;
    }
    else
    {
      return false;
    }
  }


  private static ArrayList<String> parseWords(StringBuilder valid)
  {
    ArrayList<String> words = new ArrayList<String>();
    int start = 0;
    for(int i = 0; i < valid.length(); i++)
    {
      char ch = valid.charAt(i);
      if(Character.isLetterOrDigit(ch))
      {
        continue;
      }
      else
      {
        if(i == start)
        {
          words.add(ch);
          start = i + 1;
        }
        else
        {
          String word = valid.substring(start, i);
          words.add(word);
          words.add(ch);
          start = i + 1;
        }
      }
    }
    return words;
  }


  public static String pigLatinate(String input) throws Exception
  {
    if(invalidString())
    {
      throw new Exception("Input string is invalid");
    }

    input = input.trim();
    StringBuilder valid = new StringBuilder(input);
    ArrayList<String> words = parseWords(valid);
  }
}
