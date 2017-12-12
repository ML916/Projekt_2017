package sample;

import java.util.ArrayList;
import java.util.List;

public class Perception {
    CorridorMap corridorMap;
    private double x, y;
    private List<Pedestrian> pedestrians;
    private double size;
    
    public Perception(double x, double y){
        this.x = x;
        this.y = y;
        this.size = 20;
        this.pedestrians = new ArrayList<>();
    }

    public void updatePerception(double x, double y){
        this.x = x;
        this.y = y;
        this.pedestrians.clear();
        for (Pedestrian pedestrian: corridorMap.pedestrians) {
            //Om pedestrian inom radien, lägg till på listan av pedestrians
            if((pedestrian.getX() < this.x + size || pedestrian.getX() > this.x - size) && (pedestrian.getY() < this.y + size || pedestrian.getY() > this.y - size) ){
                this.pedestrians.add(pedestrian);
            }
        }
    }

    public CorridorMap getCorridorMap(){
        return this.corridorMap;
    }

    public List<Pedestrian> getPedestrians(){
        return this.pedestrians;
    }
}
