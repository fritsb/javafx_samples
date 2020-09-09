package streeksoft;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

public class MyAwesomeController  implements Initializable {
    private int counter = 0;
    private  String week_days[]  = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" }; // Array
    private ArrayList<Student> students;

    @FXML
    private Button myButton;
    @FXML
    private Label myLabel;
    @FXML
    private ComboBox myBox;

    @FXML
    private Button asc;

    @FXML
    private Button desc;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Student student1 = new Student(1, "Piet", "Jansen", 33);
        Student student2 = new Student(2, "Jan", "Pieterzoon", 22);
        Student student3 = new Student(3, "Kees", "Jantjes", 66);
        Student student4 = new Student(4, "Kees2", "Jantjes", 55);

        Course java = new Course(1, "Java");
        student3.setCurrentCourse(java);

        students = new ArrayList<Student>(); // ArrayList
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);


        // Added this:
        ObservableList<Student> oStudentLists = FXCollections.observableArrayList(students); // ObservableList
        myBox.setItems(oStudentLists);

        // https://stackoverflow.com/questions/41920217/what-is-the-difference-between-arraylist-and-observablelist

        /* // stukje code om met een for-loop Strings (afkomstig van de Studenten objecten) toe te voegen aan de dropdownlist
        for(int i = 0; i < students.size(); i++ ) {
            Student tempstudent = students.get(i);
            myBox.getItems().add(tempstudent.getName());
        }*/

        /* // stukje code om array toe te voegen aan de dropdownlist
        for(int i = 0; i < week_days.length; i++ ) {
            myBox.getItems().add(week_days[i]);
        }
         */
    }


    @FXML
    private void handleButtonAction(ActionEvent event) {
        /* // Stukje code om de label te vullen met Hello World & een counter
        counter++;
        myLabel.setText("Hello World " + counter);*/

        // Hier vragen we het geselecteerde student object op van de dropdownlist.
        Student stud = (Student) myBox.getSelectionModel().getSelectedItem();

        try {
            // Following lines will load the second fxml-file
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("student.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();

            // Following lines will pass data to the second controller, so we can use data from first view in second view
            StudentController controller = fxmlLoader.<StudentController>getController();
            controller.setCurrentStudent(stud);
        }
        catch(Exception e) {
            System.out.println("Exception loading fxml");
        }


    }

    @FXML
    private void handleSortButtonAction(ActionEvent event) {
        Collections.sort(students); // Sorteren van de students ArrayList door het aanroepen van de statische sort-methode van de Collections-class

        ObservableList<Student> oStudentLists = FXCollections.observableArrayList(students); // ObservableList
        myBox.setItems(oStudentLists);
    }


    @FXML
    private void handleReverseSortButtonAction(ActionEvent event) {
        Collections.sort(students, Collections.reverseOrder());  // Sorteren van de students ArrayList door het aanroepen van de statische sort-methode van de Collections-class

        ObservableList<Student> oStudentLists = FXCollections.observableArrayList(students); // ObservableList
        myBox.setItems(oStudentLists);
    }

    @FXML
    private void handleListAction(ActionEvent event) {
        // Stukje code hieronder kan de tekst van geselecteerde item overnemen en plaatsen in de label.
        //myLabel.setText(myBox.getValue().toString() );

        // Hier vragen we het geselecteerde student object op van de dropdownlist.
        Student stud = (Student) myBox.getSelectionModel().getSelectedItem();
        myLabel.setText( stud.getStudentNo() + ", " + stud.getLastName() );
    }

}
