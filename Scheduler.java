import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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
      Pane pane = new Pane();

      return pane;
   }

   public Pane getHeader() {
      Label title = new Label("CPP Scheduler");
      title.setId("title");
      HBox hbox = new HBox(title);
      Pane pane = new Pane(hbox);
      pane.setId("header");

      return pane;
   }

   public Scene getScene() {

      VBox app = new VBox(getHeader(), getScheduler());

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

      primaryStage.setHeight(720);
      primaryStage.setWidth(1280);

      // set fullscreen
      // primaryStage.setFullScreen(true);

      // Show the window.
      primaryStage.show();
   }
}