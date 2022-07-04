public class a8main extends Application
{
  private TextField minutesField;
  private RadioButton daytime;
  private RadioButton evening;
  private RadioButton offPeak;

  public static void main(String[] args)
  {
    launch(args);
  }

  @Override
  public void start(Stage stage)
  {
    Label optionsPrompt = new Label("Please select a call category.");

    daytime = new RadioButton("Daytime (6:00AM - 5:59PM)");
    evening = new RadioButton("Evening (6:00PM - 11:59PM)");
    offPeak = new RadioButton("Off-Peak (12:00AM - 5:59AM)");

    ToggleGroup rates = new ToggleGroup();
    daytime.setToggleGroup(rates);
    evening.setToggleGroup(rates);
    offPeak.setToggleGroup(rates);

    VBox options = new VBox(20, optionsPrompt, daytime, evening, offPeak);
    options.setAlignment(Pos.LEFT);

    Label minutesPrompt = new Label("How long was your phone call " +
      "(in minutes)?");
    minutesField = new TextField();
    Button calculateButton = new Button("Calculate call price");
    calculateButton.setOnAction(new CalculateButtonHandler());

    VBox callLength = new VBox(10, minutesPrompt, minutesField,
      calculateButton);
    callLength.setAlignment(Pos.RIGHT);

    HBox root = new HBox(30, options, callLength);
    root.setAlignment(Pos.CENTER);
    root.setPadding(new Insets(10));

    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.setTitle("Long Distance Call Calculator");
    stage.show();
  }

  class CalculateButtonHandler extends EventHandler<ActionEvent>
  {
    private final int DAYTIME_RATE_PER_MIN = 7;
    private final int EVENING_RATE_PER_MIN = 12;
    private final int OFF_PEAK_RATE_PER_MIN = 5;

    @Override
    public void handle(ActionEvent event)
    {
      if(daytime.isSelected())
      {
        this.calculate(DAYTIME_RATE_PER_MIN);
      }
      else if(evening.isSelected())
      {
        this.calculate(EVENING_RATE_PER_MIN);
      }
      else if(offPeak.isSelected())
      {
        this.calculate(OFF_PEAK_RATE_PER_MIN);
      }
      else
      {
        JOptionPane.showMessageDialog(null, "Please select a call category.");
      }
    }

    private void calculate(int rate)
    {
      
    }
  }
}
