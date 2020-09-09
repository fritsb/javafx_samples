package streeksoft;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * The following sources have been used:
 *  - https://riptutorial.com/javafx/example/8803/passing-data-to-fxml---accessing-existing-controller
 *  - https://docs.oracle.com/javafx/2/ui_controls/combo-box.htm
 *  - http://java-buddy.blogspot.com/2013/06/javafx-combobox-for-custom-object.html
 *  - https://stackoverflow.com/questions/27160951/javafx-open-another-fxml-in-the-another-window-with-button
 */



public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
