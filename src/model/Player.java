package model;

import java.io.Serializable;

/**
 *
 * @author USER
 */
public class Player implements Serializable{
    
    public String nickName;
    private  int Score;

    public Player() {
        this.Score = 0;
    }

    public Player(String nickName, int Score) {
        this.nickName = nickName;
        this.Score = Score;
    }

    public String getNickName() {
        return nickName;
    }


    public int getScore() {
        return Score;
    }

    

    public void setScore(int Score) {
        this.Score = Score;
    }

    @Override
    public String toString() {
        return nickName;
    }
    
    
    
    
}
