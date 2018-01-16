package com.javaproject2017_server;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;

public class ServerController {

    public SimulationServer simulationServer;
    public Canvas canvas;
    public Pane pane;
    public Button startButton;
    public Button pauseButton;

    private ObservableList<Circle> circles = FXCollections.observableArrayList();

    public void initModel(SimulationServer server){
        simulationServer = server;
        circles.addListener((ListChangeListener<Circle>) c -> {
            while (c.next()) {
                if (c.wasAdded()) {
                    System.out.println("Item added");
                    pane.getChildren().addAll(c.getAddedSubList());
                }

                if (c.wasRemoved()) {
                    System.out.println("Item removed");
                    pane.getChildren().removeAll(c.getRemoved());
                }
            }
        });

        simulationServer.getCorridorMap().pedestrians.forEach(pedestrian ->
                circles.add(new Circle(pedestrian.getX(), pedestrian.getY(), 3.5, Color.RED)));
    }


    public void handleStartButton() {
        if(!simulationServer.isAlive()) {
            simulationServer.start();
        }
    }

    public void handlePauseButton(ActionEvent actionEvent) {

    }

}
