import javax.swing.*;
import java.awt.*;

public class a8main extends JFrame
{
  //private JTextField minutesField;
  //private JRadioButton daytime;
  //private JRadioButton evening;
  //private JRadioButton offPeak;

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

  public static void main(String[] args)
  {
    new a8main();
  }
}
