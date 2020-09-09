package streeksoft;


import javafx.fxml.FXML;

public class Student extends Person implements Comparable<Student> {
    private int studentNo;
    private String firstName;
    private String lastName;
    private Course currentCourse;
    private int age;

    public Course getCurrentCourse() {
        return currentCourse;
    }

    public void setCurrentCourse(Course currentCourse) {
        this.currentCourse = currentCourse;
    }

    public Student(int studentNo, String firstName, String lastName, int age) {
        this.studentNo = studentNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public int getStudentNo() {
        return studentNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return this.getFirstName() + " " + this.getLastName();
    }


    public void setStudentNo(int studentNo) {
        this.studentNo = studentNo;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override // code from https://dzone.com/articles/sorting-java-arraylist
    public int compareTo(Student stud) {
        return (this.getAge() < stud.getAge() ? -1 : (this.getAge() == stud.getAge() ? 0 : 1));
    }
    // ? operator = http://tutorials.jenkov.com/java/ternary-operator.html

    // de toString()-methode is noodzakelijk voor het weergeven van data in de dropdownlist.
    public String toString() {
        return this.getName() + ", " + this.getAge();
    }
}
