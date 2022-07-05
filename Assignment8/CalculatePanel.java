import javax.swing.*;
import java.awt.event.*;

/**This class creates a panel that holds the Long Distance Call Calculator's
calculate button. It also provides an ActionEvent listener for the calculate
button, retreiving the user's selected call rate and submitted call duration,
and then calculating the price of the call.*/
public class CalculatePanel extends JPanel
{
  //Variable to hold the RatePanel object storing the user's selection
  private RatePanel ratePanel;
  //Variable to hold the MinutesPanel object storing the duration of the call
  private MinutesPanel minutesPanel;

  /**Constructor method to create the panel. It also stores the passed RatePanel
  and MinutesPanel object addresses in the class' fields.
  @param ratePanel The RatePanel object storing the user's selection
  @param minutesPanel The MinutesPanel object storing the duration of the call*/
  public CalculatePanel(RatePanel ratePanel, MinutesPanel minutesPanel)
  {
    this.ratePanel = ratePanel;
    this.minutesPanel = minutesPanel;

    JButton calculateButton = new JButton("Calculate call price");
    calculateButton.addActionListener(new CalculateButtonListener());

    add(calculateButton);
  }

  /**Private inner class to provide an ActionEvent listener for the panel's
  calculate button. It utilizes the accessor methods of the RatePanel and
  MinutesPanel objects to retreive the user's selected rate and submitted call
  duration. These values are used to calculate the price of the user's call. If
  either the call rate or the call duration have not been provided by the user,
  the user is notified and prompted again.*/
  private class CalculateButtonListener implements ActionListener
  {
    /**The action performed by the ActionEvent listener.
    @param event The event that triggered the ActionEvent listener.*/
    public void actionPerformed(ActionEvent event)
    {
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

      int minutes = 0;
      try
      {
        minutes = minutesPanel.getMinutes();
      }
      catch(Exception e)
      {
        JOptionPane.showMessageDialog(null, "Please enter the duration of the" +
          " call in minutes.");
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
