package streeksoft;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class StudentController {
    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField age;

    @FXML
    private TextField studentno;

    @FXML
    private Button button;

    private Student currentStudent;


    public Student getCurrentStudent() {
        return currentStudent;
    }

    public void setCurrentStudent(Student currentStudent) {
        this.currentStudent = currentStudent;
        this.setFormData();
    }

    public void setFormData() {
        this.firstName.setText(this.currentStudent.getFirstName());
        this.lastName.setText(this.currentStudent.getLastName());
        // Hieronder zetten we een int om naar een String door middel van de statische methode valueOf van de class String
        this.age.setText(String.valueOf(this.currentStudent.getAge()));
        this.studentno.setText(String.valueOf(this.currentStudent.getStudentNo()));

    }


}
