package model;

import java.awt.Point;

/**
 *
 * @author USER
 */
public class Food extends Thread{
    
    private Point position;
    
    public Food() {
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(int posX, int posY) {
        this.position = new Point(posX, posY);
    }

}
