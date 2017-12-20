package com.javaproject2017_server;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

public class ServerController {

    public SimulationServer simulationServer;
    public Canvas canvas;
    public Pane pane;
    public Button startButton;
    public Button pauseButton;
    public SimulationThread simulationThread;

    private ObservableList<Circle> circles = FXCollections.observableArrayList();

    public void initModel(SimulationServer server){
        simulationServer = server;
        //simulationServer.start();
    }

    public void handleStartButton() {
        if(!simulationServer.isAlive()) {
            simulationServer.start();
        }
    }

    public void handlePauseButton(ActionEvent actionEvent) {

    }
}
