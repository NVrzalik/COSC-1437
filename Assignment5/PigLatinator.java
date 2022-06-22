import java.util.ArrayList;

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


  private static ArrayList<String> parseWords(String input)
  {
    ArrayList<String> words = new ArrayList<String>();
    int start = 0;
    for(int i = 0; i < input.length(); i++)
    {
      char ch = input.charAt(i);
      if(Character.isLetterOrDigit(ch) || ch == '\'')
      {
        continue;
      }
      else
      {
        if(i == start)
        {
          words.add(String.valueOf(ch));
          start = i + 1;
        }
        else
        {
          String word = input.substring(start, i);
          words.add(word);
          words.add(String.valueOf(ch));
          start = i + 1;
        }
      }
    }
    return words;
  }


  private static String convert(String word)
  {
    if(!Character.isLetterOrDigit(word.charAt(0)))
    {
      return word;
    }

    boolean hasNonLetters = false;
    int i = 0;
    while(!hasNonLetters && i < word.length())
    {
      char ch = word.charAt(i);
      if(Character.isLetter(ch) || ch == '\'')
      {
        i++;
        continue;
      }
      else
      {
        hasNonLetters = true;
      }
    }
    if(hasNonLetters == true)
    {
      return word;
    }

    StringBuilder convert = new StringBuilder(word);

    if(convert.length() == 1)
    {
      convert.append("ay");
      return convert.toString();
    }

    if(Character.isUpperCase(convert.charAt(0)))
    {
      boolean allcaps = true;
      i = 1;
      while(allcaps && i < convert.length())
      {
        if(Character.isUpperCase(convert.charAt(i)))
        {
          i++;
          continue;
        }
        else
        {
          allcaps = false;
        }
      }
      if(allcaps == true)
      {
        char firstLetter = convert.charAt(0);
        convert.deleteCharAt(0);
        convert.append(firstLetter);
        convert.append("AY");
        return convert.toString();
      }
      else
      {
        char firstLetter = convert.charAt(0);
        convert.deleteCharAt(0);
        convert.append(firstLetter);
        convert.append("ay");
        firstLetter = convert.charAt(0);
        firstLetter = Character.toUpperCase(firstLetter);
        convert.setCharAt(0,firstLetter);
        return convert.toString();
      }
    }

    char firstLetter = convert.charAt(0);
    convert.deleteCharAt(0);
    convert.append(firstLetter);
    convert.append("ay");
    return convert.toString();
  }



  public static String pigLatinate(String input) throws Exception
  {
    if(invalidString(input))
    {
      throw new Exception("Input string is invalid");
    }

    input = input.trim();
    ArrayList<String> words = parseWords(input);

    for(int i = 0; i < words.size(); i++)
    {
      words.set(i, convert(words.get(i)));
    }

    StringBuilder latin = new StringBuilder();
    for(int i = 0; i < words.size(); i++)
    {
      latin.append(words.get(i));
    }
    return latin.toString();
  }
}
