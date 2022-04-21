import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class Settings {
  private VBox root;
  // private ArrayList<Course> courseList = new ArrayList<>();
  private VBox classList = new VBox();

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

  public Settings() {
    root = new VBox();
    root.setId("settings");

    Label label = new Label("Settings");
    label.setId("settingsLabel");

    root.getChildren().addAll(label, getAddClass(), getClassList());

    // Class List change listener

  }

  public Pane getView() {
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
}
