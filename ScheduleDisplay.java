import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class ScheduleDisplay {
  private Pane root;
  private static String[] colors = {"#ffbfc5", "#ffc89c", "#faefbe", "#8fffff", "#baffd5", "#d3cfff", "#fac4ff"};
  private static String[] labelNames = {"Face-to-Face", "Fully Synchronous", "Hybrid Sychronous Component", "Fully Asynchronous", "Hybrid Asynchronous Component", "Bisynchronous", "Hyflex"};

  // function to create a horizontal box of legend item (color & label)
  public HBox setLegend(String color, String labelName){
    HBox hBox = new HBox();
    hBox.setSpacing(3);

    Rectangle rectangle = new Rectangle(12,12);
    rectangle.setFill(Color.web(color));

    Label label = new Label(labelName);
    label.setFont(new Font(10));

    hBox.getChildren().addAll(rectangle, label);

    return hBox;
  }

  // function that creates the schedule display
  public ScheduleDisplay() {
    // Vbox for the right column that contains the hourly-week schedule (labels, boxes and images)
    root = new VBox();
    root.setId("scheduleDisplay");

    // the title for the hourly-week schedule display
    Label label = new Label("Weekly Schedule");
    label.getStyleClass().add("scheduleLabel");
    VBox labelBox = new VBox(label);
    labelBox.setAlignment(Pos.CENTER);

    // temporary label for the pagination
    Pagination pagination = new Pagination(200);
      pagination.setMaxPageIndicatorCount(12);
      pagination.getStylesheets().add("pagination_styles.css");
      pagination.setPageFactory((pageIndex) -> {
        Image image = new Image("file:assets\\Printable-Hourly-Planner.jpg");
        ImageView schedule = new ImageView(image);
        HBox imageBox = new HBox(schedule);
        imageBox.setAlignment(Pos.CENTER);
        
        return imageBox;
    });
    HBox paginationBox = new HBox(pagination);
    paginationBox.setAlignment(Pos.CENTER);


    // creating the legend for the schedule display
    HBox legendBox = new HBox();
    System.out.println(colors.length);
    for(int i = 0; i < colors.length; i++) {
      HBox temp = setLegend(colors[i], labelNames[i]);
      legendBox.setAlignment(Pos.CENTER);
      legendBox.setSpacing(12);
      legendBox.getChildren().add(temp);
    };

    // adding all elements to the Schedule Display vertical box
    root.getChildren().addAll(labelBox, paginationBox, legendBox);
  }

  public Pane getView() {
    return root;
  }

}
