import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * A JavaFX Hello World application
 */

public class Scheduler extends Application {
   public static void main(String[] args) {
      // Launch the application.
      launch(args);
   }

   public Pane getScheduler() {
      GridPane gridPane = new GridPane();
      gridPane.setPrefWidth(1);

      ColumnConstraints constraint1 = new ColumnConstraints();
      constraint1.setPercentWidth(20);
      ColumnConstraints constraint2 = new ColumnConstraints();
      constraint2.setPercentWidth(80);
      gridPane.getColumnConstraints().addAll(constraint1, constraint2);

      gridPane.add(new Settings().getView(), 0, 0);
      gridPane.add(new ScheduleDisplay().getView(), 1, 0);
      return gridPane;
   }

   public Pane getHeader() {
      Label title = new Label("CPP Scheduler");
      title.setId("title");
      HBox hbox = new HBox(title);
      Pane pane = new Pane(hbox);
      pane.setId("header");
      pane.setMinHeight(55);

      return pane;
   }

   public Scene getScene() {

      VBox app = new VBox(getHeader(), getScheduler());
      app.setFillWidth(true);

      Scene scene = new Scene(app);

      // Add css
      scene.getStylesheets().addAll("styles.css");

      return scene;
   }

   @Override
   public void start(Stage primaryStage) {

      // Add the Scene to the Stage.
      primaryStage.setScene(getScene());

      // Set the stage title.
      primaryStage.setTitle("CPP Scheduler");

      // primaryStage.setHeight(720);
      // primaryStage.setWidth(1280);

      // set fullscreen
      // primaryStage.setFullScreen(true);

      // set window to maximize
      primaryStage.setMaximized(true);

      // Show the window.
      primaryStage.show();
   }
}