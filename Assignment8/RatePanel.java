import javax.swing.*;
import java.awt.*;

/**This class creates a panel that holds the Long Distance Call Calculator's
call rate options. It provides a group of radio buttons that allow the user to
select a call option. It also contains a public method to return the value of
the user's selection.*/
public class RatePanel extends JPanel
{
  //The call rate options in cents per minute
  private final int DAYTIME_RATE_PER_MIN = 7;
  private final int EVENING_RATE_PER_MIN = 12;
  private final int OFF_PEAK_RATE_PER_MIN = 5;
  //Radio buttons
  private JRadioButton daytime;
  private JRadioButton evening;
  private JRadioButton offPeak;

  /**Constructor method to create the panel.*/
  public RatePanel()
  {
    setLayout(new GridLayout(4, 1));

    JLabel optionsPrompt = new JLabel("Please select a call category.");

    daytime = new JRadioButton("Daytime (6:00AM - 5:59PM)");
    evening = new JRadioButton("Evening (6:00PM - 11:59PM)");
    offPeak = new JRadioButton("Off-Peak (12:00AM - 5:59AM)");

    ButtonGroup rates = new ButtonGroup();
    rates.add(daytime);
    rates.add(evening);
    rates.add(offPeak);

    add(optionsPrompt);
    add(daytime);
    add(evening);
    add(offPeak);
  }

  /**Public method to return the user's selection. If no selection has been
  made, an exception is thrown.
  @return The rate of the user's call in cents per minute.*/
  public int getRate() throws Exception
  {
    if(daytime.isSelected())
    {
      return DAYTIME_RATE_PER_MIN;
    }
    else if(evening.isSelected())
    {
      return EVENING_RATE_PER_MIN;
    }
    else if(offPeak.isSelected())
    {
      return OFF_PEAK_RATE_PER_MIN;
    }
    else
    {
      throw new Exception("No rate selected");
    }
  }
}
