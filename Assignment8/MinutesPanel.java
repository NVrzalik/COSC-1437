import javax.swing.*;
import java.awt.*;

public class MinutesPanel extends JPanel
{
  private JTextField minutesField;

  public MinutesPanel()
  {
    setLayout(new GridLayout(2, 1));

    JLabel minutesPrompt = new JLabel("How long was your phone call " +
      "(in minutes)?");

    minutesField = new JTextField(10);

    add(minutesPrompt);
    add(minutesField);
  }

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
