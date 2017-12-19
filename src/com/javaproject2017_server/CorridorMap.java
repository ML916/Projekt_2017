package com.javaproject2017_server;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CorridorMap implements Serializable {
    List<Pedestrian> pedestrians;
    double height;
    double width;

    public CorridorMap(double height, double width){
        this.height = height;
        this.width = width;

        pedestrians = new ArrayList<>();

    }

    public CorridorMap(double height, double width, ArrayList pedestrians)
    {
        this.height = height;
        this.width = width;
        this.pedestrians = pedestrians;
    }
    public double getHeight(){return height;}
    public double getWidth(){return width;}
}
