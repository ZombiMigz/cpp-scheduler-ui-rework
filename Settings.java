
import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class Settings {
  private ScrollPane root;
  private VBox classList = new VBox();
  private VBox breakList = new VBox();

  public Pane getAddClass() {
    Label label = new Label("Add Class");
    label.getStyleClass().add("settingLabel");

    // Term Select
    Label termLabel = new Label("Term");
    ChoiceBox<String> termChoices = new ChoiceBox<>();
    termChoices.getItems().addAll("Fall 2021", "Spring 2022", "Fall 2022");
    // Default value
    termChoices.setValue("Fall 2022");

    // Course Select
    Label courseSelectLabel = new Label("Course");
    ChoiceBox<String> courseSelect = new ChoiceBox<>();
    courseSelect.getItems().addAll(Data.courseList);
    courseSelect.setValue(Data.courseList[0]);

    // Add Button
    Button button = new Button("Add Course");
    button.setOnAction(e -> {
      addCourse(new Course(courseSelect.getValue()));
    });

    return new VBox(label, termLabel, termChoices, courseSelectLabel, courseSelect, button);
  }

  public Pane getClassList() {
    Label label = new Label("Class List");
    label.getStyleClass().add("settingLabel");
    classList.getChildren().add(label);

    return classList;
  }

  private void addCourse(Course course) {
    VBox sectionList = new VBox();
    TitledPane coursePane = new TitledPane(course.courseName, sectionList);

    for (Data.Section section : course.sections) {
      String sectionTitle = section.section + " - " + section.instructor + " - " + section.mode + " | " + "GPA:"
          + section.avgGPA + "(" + section.totalEnrollment + ")";
      VBox sectionData = new VBox();
      TitledPane sectionPane = new TitledPane(sectionTitle, sectionData);

      sectionData.getChildren().addAll(new Label("Class Number: " + section.classNumber),
          new Label("Days: " + section.days), new Label("Time: " + section.time),
          new Label("Location: " + section.location), new Label("Units: " + section.units));
      sectionList.getChildren().add(sectionPane);
    }

    this.classList.getChildren().add(coursePane);
  }

  public Pane getAddBreak() {
    Label label = new Label("Add Break");
    label.getStyleClass().add("settingLabel");

    // Name input
    Label nameLabel = new Label("Break Name");
    TextField name = new TextField("Unnamed Break");

    // Days Select
    Label daySelectLabel = new Label("Days");
    CheckBox mo = new CheckBox("Monday");
    CheckBox tu = new CheckBox("Tuesday");
    CheckBox we = new CheckBox("Wednesday");
    CheckBox th = new CheckBox("Thursday");
    CheckBox fr = new CheckBox("Friday");

    // Time Select
    Label startLabel = new Label("Start Time");
    TextField start = new TextField();
    Label endLabel = new Label("End Time");
    TextField end = new TextField();

    // Add Button
    Button button = new Button("Add Break");
    button.setOnAction(e -> {
      String days = "";
      if (mo.isSelected())
        days += "Mo";
      if (tu.isSelected())
        days += "Tu";
      if (we.isSelected())
        days += "We";
      if (th.isSelected())
        days += "Th";
      if (fr.isSelected())
        days += "Fr";
      addBreak(new Break(name.getText(), days, start.getText() + "-" + end.getText()));
    });

    return new VBox(label, nameLabel, name, daySelectLabel, mo, tu, we, th, fr, startLabel, start, endLabel, end,
        button);

  }

  private void addBreak(Break break1) {
    VBox breakPane = new VBox();
    breakPane.getChildren().addAll(new Label(break1.name), new Label("Days: " + break1.days),
        new Label("Time: " + break1.time));
    breakPane.getStyleClass().add("break");
    breakPane.setBorder(
        new Border(new BorderStroke(Color.DARKGRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
    breakList.getChildren().add(breakPane);
  }

  public Pane getBreakList() {
    Label label = new Label("Break List");
    label.getStyleClass().add("settingLabel");
    breakList.getChildren().add(label);

    return breakList;
  }

  public Settings() {
    root = new ScrollPane(new VBox(getAddClass(), getClassList(), getAddBreak(), getBreakList()));
    root.setId("settings");
    root.setFitToHeight(true);

  }

  public ScrollPane getView() {
    return root;
  }

  private class Course {
    public Course(String courseName) {
      this.courseName = courseName;
      ArrayList<Data.Section> sections = new ArrayList<>();
      for (Data.Section section : Data.sectionList) {
        if (section.courseName.equals(courseName))
          sections.add(section);
      }
      this.sections = sections.toArray(new Data.Section[0]);
    }

    String courseName;
    Data.Section[] sections;
  }

  private class Break {

    public Break(String name, String days, String time) {
      this.name = name;
      this.days = days;
      this.time = time;
    }

    String name;
    String days;
    String time;
  }
}
