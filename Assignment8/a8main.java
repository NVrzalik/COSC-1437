import javax.swing.*;
import java.awt.*;

/**This class drives the Long Distance Call Calculator, according to assignment
specifications. This GUI program prompts the user to select a time period during
which a long distance call took place, and then for the duration of the call in
minutes. When these are provided, and the calculate button is clicked, the
program calculates the price of the phone call. If the user ever forgets to
provide the necessary input, or if the input provided is invalid, the user is
notified and prompted again.
The class provides the GUI frame for the program.*/
public class a8main extends JFrame
{

  /**Constructor method to create the frame.*/
  public a8main()
  {
    setTitle("Long Distance Call Calculator");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    RatePanel ratePanel = new RatePanel();
    MinutesPanel minutesPanel = new MinutesPanel();
    CalculatePanel calculatePanel = new CalculatePanel(ratePanel, minutesPanel);

    add(ratePanel, BorderLayout.WEST);
    add(minutesPanel, BorderLayout.EAST);
    add(calculatePanel, BorderLayout.SOUTH);

    pack();
    setVisible(true);
  }

  /**Main method.*/
  public static void main(String[] args)
  {
    new a8main();
  }
}
