package com.javaproject2017_server;

import javafx.event.ActionEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class Controller {
    public Canvas canvas;
    public Pane pane;
    public Button startButton;
    public Button pauseButton;
    public SimulationThread simulationThread;

    public void handleStartButton(ActionEvent actionEvent) {
        simulationThread.run();
    }

    public void handlePauseButton(ActionEvent actionEvent) {
        try {
            simulationThread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
