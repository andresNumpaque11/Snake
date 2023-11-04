package model;

import java.awt.Point;

/**
 *
 * @author USER
 */
public class Obstacle {
        private Point position;

    public Obstacle() {
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(int x, int y) {
        this.position = new Point(x, y);
    }
        
        

    
}
