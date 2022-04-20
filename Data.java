public class Data {
  public static class Section {
    public Section(String term, double avgGPA, String courseLabel, String instructor, int classNumber, String days,
        String time,
        String location, String component, double units, int section) {
      this.term = term;
      this.avgGPA = avgGPA;
      this.courseLabel = courseLabel;
      this.instructor = instructor;
      this.classNumber = classNumber;
      this.days = days;
      this.time = time;
      this.location = location;
      this.component = component;
      this.units = units;
      this.section = section;
    }

    String term;
    double avgGPA;
    String courseLabel;
    String instructor;
    int classNumber;
    String days;
    String time;
    String location;
    String component;
    double units;
    int section;
  }

  public static Section[] sectionList = { new Section("Spring 2022", 3.56, "CS 2450", "Ben Steichen", 33066, "MW",
      "2:30PM-3:45PM", "Bldg 8 Rm 348", "Fully Synchronous", 3, 1),
      new Section("Spring 2022", 3.411, "CS 4250", "Ben Steichen", 33098, "MW", "4:00PM-5:15PM", "Bldg 8 Rm 302",
          "Fully Synchronous", 3, 1) };

  public static String[] courseList = { "CS 2450", "CS 4250" };
}
