package sample;

import java.util.List;

public class Pedestrian {
    private double x, y;
    private double goalCoordinate;
    private Perception perception;
    private double defaultDirectionX;
    private double defaultDirectionY;

    public Pedestrian(double x, double y){
        this.x = x;
        this.y = y;
        this.perception = new Perception(x,y);
        defaultDirectionY = 0;
        if(this.x > this.perception.getCorridorMap().width / 2) {
            goalCoordinate = 0;
            defaultDirectionX = 4;
        }
        else if(this.x < this.perception.getCorridorMap().width / 2){
            goalCoordinate = this.perception.getCorridorMap().width;
            defaultDirectionX = -4;
        }
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public double[] calculateSocialForce(double otherX, double otherY){
        double forceXDirection = 0.0;
        double forceYDirection = 0.0;
        double distanceY = Math.abs(otherY - this.y);
        double distanceX = Math.abs(otherX - this.x);

        if(distanceX <= 4 && distanceY <= 4){
            forceXDirection = -(this.x - otherX) / 2;
            forceYDirection = -(this.y - otherY) / 2;
        }
        /*
        if(this.defaultDirectionX > 0){
            if(otherX - this.x <= 4){
                if(distanceY < 4){
                    forceYDirection = -(this.y - otherY) / 2;
                }
            }
        }
        else if(this.defaultDirectionX < 0) {
            if(this.x - otherX <= 4){
                if(distanceY < 4){
                    forceYDirection = -(this.y - otherY) / 2;
                }
            }
        }*/

        return new double[] {forceXDirection, forceYDirection};
    }

    public void move(){
        perception.updatePerception(this.x,this.y);
        List<Pedestrian> pedestrians = perception.getPedestrians();
        double directionX = defaultDirectionX;
        double directionY = defaultDirectionX;
        double[] socialForce;
        for (Pedestrian pedestrian : pedestrians) {
            socialForce = this.calculateSocialForce(pedestrian.getX(),pedestrian.getY());
            directionX += socialForce[0];
            directionY += socialForce[1];
        }
        socialForce = this.calculateSocialForce(0, 0);
        directionX += socialForce[0];
        directionY += socialForce[1];

        socialForce = this.calculateSocialForce(0,this.perception.getCorridorMap().height);
        directionX += socialForce[0];
        directionY += socialForce[1];

        this.x += directionX;
        this.y += directionY;
    }
}
