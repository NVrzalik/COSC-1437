//For use of ArrayList
import java.util.ArrayList;
/**This class translates given input from English into Pig Latin, per the
assignment specifications: essentially, the first letter of every word is moved
to the end of the word, and "ay" is appended. The class does not need to be
instantiated, and only one method is public.*/
class PigLatinator
{

  /**This private method checks an input string to verify that it isn't empty,
  and that the variable isn't a null pointer.
  @param input The input string to be checked.
  @return Returns true if the string is invalid, false if valid.*/
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

  /**Private method to parse individual words from the input string. It uses
  non-alphanumeric characters (with the exception of apostrophes) as delimiters,
  adding each resulting token (as well as the individual delimiters) to an
  ArrayList of String objects. The method does not utilize String.split(), as
  the delimiters need to be maintained for the final, translated string.
  @param input The input string.
  @return An ArrayList of String objects, containing the parsed words and
  delimiters from the input string.*/
  private static ArrayList<String> parseWords(String input)
  {
    ArrayList<String> words = new ArrayList<String>();
    int start = 0;
    for(int i = 0; i < input.length(); i++)
    {
      char ch = input.charAt(i);
      if(input.length() == 1)
      {
        words.add(String.valueOf(ch));
      }
      if(input.length() - i != 1)
      {
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
      else
      {
        if(Character.isLetterOrDigit(ch) || ch == '\'')
        {
          String word = input.substring(start);
          words.add(word);
        }
        else
        {
          String word = input.substring(start, i);
          words.add(word);
          words.add(String.valueOf(ch));
        }
      }
    }
    return words;
  }

  /**Private method to convert an individual English word into Pig Latin, per the
  specifications provided for the assignment. It contains logic to provide
  functionality in different edge cases, such as, for example, when a word is
  in all caps, or when a contraction is encountered.
  @param word The English word to be converted into Pig Latin.
  @return The converted word.*/
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
      if(word.equalsIgnoreCase("a"))
      {
        convert.append("y");
      }
      else
      {
        convert.append("ay");
      }
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
        firstLetter = Character.toLowerCase(firstLetter);
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

  /**Public method to convert English input into Pig Latin. It utilizes the
  private methods of the class to parse the input for individual words, then
  to convert them into Pig Latin. It returns the converted input as a String
  object. The method throws an error if the input is a blank or null String
  object.
  @param input The input string to be converted into Pig Latin.
  @return The converted string.*/
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
