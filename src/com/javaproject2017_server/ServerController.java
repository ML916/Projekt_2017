package com.javaproject2017_server;

import javafx.event.ActionEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class ServerController {

    public SimulationServer simulationServer;
    public Canvas canvas;
    public Pane pane;
    public Button startButton;
    public Button pauseButton;
    public SimulationThread simulationThread;

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
