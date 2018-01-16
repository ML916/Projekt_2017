package com.javaproject2017_server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {

    Socket socket;
    public Client(){
        try {
            socket = new Socket("localhost", 11111);
            while(true) {
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                CorridorMap receivedMap = (CorridorMap) objectInputStream.readObject();
                //objectInputStream.close();
                for (Pedestrian p: receivedMap.pedestrians) {
                    p.move(receivedMap);
                }
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                objectOutputStream.writeObject(receivedMap);
                objectOutputStream.flush();
                //objectOutputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        new Client();
    }
}
