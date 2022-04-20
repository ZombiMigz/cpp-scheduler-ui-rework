import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class Settings {
  private Pane root;

  public Settings() {
    root = new Pane(new Label(
        "Settings"));
  }

  public Pane getView() {
    return root;
  }
}
