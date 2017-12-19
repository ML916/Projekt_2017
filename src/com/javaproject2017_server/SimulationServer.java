package com.javaproject2017_server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimulationServer extends Thread {
    private ServerSocket serverSocket;
    private boolean ServerOn = true;
    private CorridorMap corridorMap;

    @Override
    public void run(){
        System.out.println("Server is running");
        while(ServerOn){
            try
            {
                System.out.println("Waiting for connection");
                Socket clientSocket = serverSocket.accept();
                SimulationClientListenerThread simulationClientListenerThread = new SimulationClientListenerThread(clientSocket, this.corridorMap);
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

    public SimulationServer(CorridorMap corridorMap){
        super();
        this.corridorMap = corridorMap;
        try {
            serverSocket = new ServerSocket(11111);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
