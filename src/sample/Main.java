package sample;

import controller.HeaderController;
import controller.PersonController;
import controller.PersonListController;
import dto.Header;
import dto.Person;
import dto.PersonList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
     //List<Person> persons = PersonController.getPersonList();
        PersonList personList = PersonListController.getPersonList();
        System.out.println(personList);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();



        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
