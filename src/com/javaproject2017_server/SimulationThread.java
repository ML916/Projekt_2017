package com.javaproject2017_server;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimulationThread extends Thread{
    private List<SimulationClientListenerThread> clientThreadList;
    private ObservableList<Circle> circles = FXCollections.observableArrayList();
    private CorridorMap corridorMap;

    public CorridorMap getCorridorMap() {
        return corridorMap;
    }

    public ObservableList<Circle> getCircles() {
        return circles;
    }

    public SimulationThread(CorridorMap corridorMap) {
        clientThreadList = Collections.synchronizedList(new ArrayList<SimulationClientListenerThread>());
        this.corridorMap = corridorMap;
        for (Pedestrian pedestrian : corridorMap.pedestrians) {
            circles.add(new Circle(pedestrian.getX(), pedestrian.getY(), 3.5, Color.RED));
        }
    }

    public void run(){
        try {
            this.sleep(200);
            circles.clear();
            corridorMap.pedestrians.forEach(pedestrian ->
                    circles.add(new Circle(pedestrian.getX(), pedestrian.getY(), 3.5, Color.RED)));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
