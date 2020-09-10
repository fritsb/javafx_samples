package streeksoft;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

    @FXML
    private Label myLabel;

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

    @FXML
    private void handleButtonAction(ActionEvent event) {
        // Try-Catch example for checking a number.
        try {
            int tempAge = Integer.parseInt(age.getText());
            //int tempAge = Integer.parseInt(age.getText());
            //Some operations with the number tempAge
            myLabel.setText("De leeftijd van de student " + currentStudent.getName() + "  is " + Integer.toString(tempAge    ) );

        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Verkeerde invoer ingevoerd");
            alert.setHeaderText("Error tijdens het verwerken van de formulier data");
            alert.setContentText("Ooooooops, there was an error! Please enter a number!!!!! ");
            alert.showAndWait();

            // remove data from textfield
            age.setText("");

            //Here for example prompt some window notifying user
            System.out.println("Error processing form data! ");
            System.out.println(e);
        }
        catch (Exception e) {

        }
        finally {
            System.out.println("Deze code wordt altijd uitgevoerd");
        }


        // code from:
        // - https://stackoverflow.com/questions/44184684/how-to-validate-textfield-if-passing-argument-is-string
        // - https://code.makery.ch/blog/javafx-dialogs-official/


    }


}
