package edu.uchicago.umairmustafa;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class FlightMain extends Application {



    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) throws Exception {


        String fxmlFile = "/fxml/flight.fxml";
        FXMLLoader loader = new FXMLLoader();
        Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));


        Scene scene = new Scene(rootNode);
        scene.getStylesheets().add("/styles/styles.css");

        stage.setTitle("Wanderlust");
        stage.setScene(scene);
        stage.show();
    }
}
