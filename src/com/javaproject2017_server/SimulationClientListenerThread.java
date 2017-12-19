package com.javaproject2017_server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SimulationClientListenerThread extends Thread {
    Socket clientSocket;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private CorridorMap corridorMap;
    public boolean connectionActive = true;

    @Override
    public void run(){
        while(connectionActive){
            ObjectInputStream in = null;
            ObjectOutputStream out = null;
            try {
                out = new ObjectOutputStream(clientSocket.getOutputStream());
                in = new ObjectInputStream(clientSocket.getInputStream());
                /*Pedestrian p1 = new Pedestrian(2,4);
                Pedestrian p2 = new Pedestrian(6,6);
                ArrayList<Pedestrian> pedestrians = new ArrayList<>();
                pedestrians.add(p1);
                pedestrians.add(p2);
                */

                //TODO: Simulering implementeras här innanför på något sätt

                out.writeObject(corridorMap);
                out.flush();
                System.out.println("Object sent");
                corridorMap = (CorridorMap) in.readObject();


            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
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
