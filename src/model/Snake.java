package model;

import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author USER
 */

public class Snake extends Thread{
    private ArrayList<Point> pointList = new ArrayList<Point>();
    
    private boolean rightDirection = false;
    private boolean leftDirection = false;
    private boolean upDirection = false;
    private boolean downDirection = false;
    
    public Snake() {
    }
    
    public int getLon() {
        return pointList.size();
    }
    public void setLon(int lon){
        lon+=(pointList.size()-1);
    }
    
    public ArrayList<Point> getPointList() {
        return pointList;
    }
    
    public char getTrueDirection() {
        if (rightDirection) {
            return 'R';
        } else if (leftDirection) {
            return 'L';
        } else if (upDirection) {
            return 'U';
        } else if (downDirection) {
            return 'D';
        } else {
            return 'N';
        }
    }
    
    public void add(Point point){
        pointList.add(point);
    }
    
    public void add(){
        pointList.add(pointList.get(0));
    }

    public void setRightDirection(boolean rightDirection) {
        this.rightDirection = rightDirection;
    }

    public void setLeftDirection(boolean leftDirection) {
        this.leftDirection = leftDirection;
    }

    public void setUpDirection(boolean upDirection) {
        this.upDirection = upDirection;
    }

    public void setDownDirection(boolean downDirection) {
        this.downDirection = downDirection;
    }

    public boolean isRightDirection() {
        return rightDirection;
    }

    public boolean isLeftDirection() {
        return leftDirection;
    }

    public boolean isUpDirection() {
        return upDirection;
    }

    public boolean isDownDirection() {
        return downDirection;
    }

    
    
    
    
}
