package com.javaproject2017_server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SimulationClientListenerThread extends Thread {
    Socket clientSocket;
    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;
    private CorridorMap corridorMap;
    public boolean connectionActive = true;

    @Override
    public void run(){
        while(connectionActive){
            try {
                this.sleep(200);
                corridorMap.pedestrians.forEach(pedestrian -> pedestrian.move(corridorMap));
                objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());
                objectOutputStream.writeObject(corridorMap);
                //objectOutputStream.flush();
                System.out.println("Object sent");

                objectInputStream = new ObjectInputStream(clientSocket.getInputStream());
                corridorMap = (CorridorMap) objectInputStream.readObject();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //System.out.println("Tråden rullar");
        }
        System.out.println("Client is shutting down");
    }

    public SimulationClientListenerThread(Socket socket, CorridorMap corridorMap){
        super();
        this.corridorMap = corridorMap;
        clientSocket = socket;
    }
}
