package com.javaproject2017_server;

import sample.CorridorMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimulationThread extends Thread{
    private List<SimulationClientListenerThread> clientThreadList;

    public SimulationThread(CorridorMap corridorMap) {
        clientThreadList = Collections.synchronizedList(new ArrayList<SimulationClientListenerThread>());
    }


}
