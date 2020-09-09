package streeksoft;

public class Course {
    private int courseNo;
    private String courseName;

    public Course(int courseNo, String courseName) {
        this.courseNo = courseNo;
        this.courseName = courseName;
    }

    public int getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(int courseNo) {
        this.courseNo = courseNo;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
