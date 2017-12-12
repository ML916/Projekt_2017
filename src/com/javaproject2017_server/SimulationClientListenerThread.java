package com.javaproject2017_server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SimulationClientListenerThread extends Thread {
    Socket clientSocket;
    private ObjectInputStream in;
    private ObjectOutputStream out;

    public SimulationClientListenerThread(Socket socket){
        super();
        clientSocket = socket;
        try {
            in = new ObjectInputStream(clientSocket.getInputStream());
            out = new ObjectOutputStream(clientSocket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
