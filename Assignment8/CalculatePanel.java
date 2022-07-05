import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class CalculatePanel extends JPanel
{
  private RatePanel ratePanel;
  private MinutesPanel minutesPanel;

  public CalculatePanel(RatePanel ratePanel, MinutesPanel minutesPanel)
  {
    this.ratePanel = ratePanel;
    this.minutesPanel = minutesPanel;

    JButton calculateButton = new JButton("Calculate call price");
    calculateButton.addActionListener(new CalculateButtonListener());

    add(calculateButton);
  }

  private class CalculateButtonListener implements ActionListener
  {

    public void actionPerformed(ActionEvent event)
    {
      //Get the rate
      int rate = 0;
      try
      {
        rate = ratePanel.getRate();
      }
      catch(Exception e)
      {
        JOptionPane.showMessageDialog(null, "Please select a call category.");
        return;
      }
      //Get the minutes
      int minutes = 0;
      try
      {
        minutes = minutesPanel.getMinutes();
      }
      catch(Exception e)
      {
        JOptionPane.showMessageDialog(null, "Please enter the duration of the" +
          "call in minutes.");
        return;
      }

      int cents = rate * minutes;
      double price = cents / 100.0;
      String results = String.format("The price of this call is $%,.2f.",
        price);
      JOptionPane.showMessageDialog(null, results);
    }
  }
}
