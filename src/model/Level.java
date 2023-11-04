package model;

/**
 *
 * @author USER
 */
public class Level {
      private String level;
    private long speed;
    private long speedFood;
    private long boom;
    private int size;

    public Level(String level, long speed,long speedFood, long boom, int size) {
        this.level = level;
        this.speed = speed;
        this.boom = boom;
        this.size = size;
        this.speedFood = speedFood;
    }

    public long getBoom() {
        return boom;
    }

    public String getLevel() {
        return level;
    }

    public long getSpeed() {
        return speed;
    }

    public int getSize() {
        return size;
    }

    public long getSpeedFood() {
        return speedFood;
    }
    

    public void setBoom(long boom) {
        this.boom = boom;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setSpeed(long speed) {
        this.speed = speed;
    }
    
    


    
    
    
}
