package com.javaproject2017_server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimulationServer extends Thread {
    private ServerSocket serverSocket;
    private boolean ServerOn = true;

    @Override
    public void run(){
        while(ServerOn){
            try
            {
                Socket clientSocket = serverSocket.accept();
                SimulationClientListenerThread simulationClientListenerThread = new SimulationClientListenerThread(clientSocket);
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

    public SimulationServer(){
        super();
        System.out.println("Server is running");
        try {
            serverSocket = new ServerSocket(11111);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
