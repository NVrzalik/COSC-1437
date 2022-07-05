import javax.swing.*;
import java.awt.*;

/**This class creates a panel for the Long Distance Call Calculator to receive
user input to determine the duration of a call. It prompts the user for the
length of the phone call in minutes, and provides a textfield to allow the user
to submit their input. It also contains a public method to return the value of
the user's input.*/
public class MinutesPanel extends JPanel
{
  //A textfield to receive input from the user
  private JTextField minutesField;

  /**Constructor method to create the panel.*/
  public MinutesPanel()
  {
    setLayout(new GridLayout(2, 1));

    JLabel minutesPrompt = new JLabel("How long was your phone call " +
      "(in minutes)?");

    minutesField = new JTextField(10);

    add(minutesPrompt);
    add(minutesField);
  }

  /**Public method to return the user's input, rounded to the next integer. If
  no input has been provided, or if the input is not a non-negative number, an
  exception is thrown.
  @return The length of the user's call, rounded to the next integer.*/
  public int getMinutes() throws Exception
  {
    String input = minutesField.getText();
    double fractionalMinutes = 0;
    try
    {
      fractionalMinutes = Double.parseDouble(input);
    }
    catch(Exception e)
    {
      throw new Exception("Invalid input", e);
    }
    if(fractionalMinutes < 0)
    {
      throw new Exception("Negative input");
    }

    int minutes = (int)Math.ceil(fractionalMinutes);
    return minutes;
  }
}
