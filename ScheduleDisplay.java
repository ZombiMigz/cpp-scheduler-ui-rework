import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class ScheduleDisplay {
  private Pane root;

  public ScheduleDisplay() {
    root = new Pane(new Label("Schedule Display"));
  }

  public Pane getView() {
    return root;
  }

}
