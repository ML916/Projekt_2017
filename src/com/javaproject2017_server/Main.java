package com.javaproject2017_server;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/com/javaproject2017_server/serverview.fxml"));
        Parent root = FXMLLoader.load(fxmlLoader.getLocation());
        primaryStage.setTitle("Server Window");
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.show();
    }


    public static void main(String[] args) {
        SimulationServer server = new SimulationServer();
        server.start();
        launch(args);

    }
}
