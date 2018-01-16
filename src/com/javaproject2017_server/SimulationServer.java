package com.javaproject2017_server;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimulationServer extends Thread {
    private ServerSocket serverSocket;
    private boolean ServerOn = true;
    private CorridorMap corridorMap;
    public SimulationThread simulationThread;
    public ObservableList<Circle> circles = FXCollections.observableArrayList();

    @Override
    public void run(){
        System.out.println("Server is running");
        while(ServerOn){
            try
            {
                System.out.println("Waiting for connection");
                Socket clientSocket = serverSocket.accept();
                SimulationClientListenerThread simulationClientListenerThread =
                        new SimulationClientListenerThread(clientSocket, this.corridorMap);
                simulationClientListenerThread.start();
                System.out.println("Connection received");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try
        {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public CorridorMap getCorridorMap() {
        return corridorMap;
    }

    public SimulationServer(CorridorMap corridorMap){
        super();
        this.corridorMap = corridorMap;
        //this.simulationThread = new SimulationThread(this.corridorMap);
        //this.circles = simulationThread.getCircles();
        //this.simulationThread.start();
        try {
            serverSocket = new ServerSocket(11111);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
