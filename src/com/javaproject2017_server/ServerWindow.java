package com.javaproject2017_server;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ServerWindow extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/javaproject2017_server/serverview.fxml"));
        Parent root = fxmlLoader.load();

        ServerController controller = fxmlLoader.getController();
        ArrayList<Pedestrian> pedestrians = new ArrayList();
        Pedestrian p1 = new Pedestrian(150,50,1);
        Pedestrian p2 = new Pedestrian(40,240,2);
        Pedestrian p3 = new Pedestrian(180,70,3);
        pedestrians.add(p1);
        pedestrians.add(p2);
        pedestrians.add(p3);
        CorridorMap corridorMap = new CorridorMap(600, 200, pedestrians);
        SimulationServer simulationServer = new SimulationServer(corridorMap);
        controller.initModel(simulationServer);

        primaryStage.setTitle("Server Window");
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
