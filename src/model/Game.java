package model;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author USER
 */
public class Game implements Serializable{

    private Snake snake;
    private Food food;
    private Obstacle obstacle;
    private Score score;
    private int s = 0;
    private int scale = 32;
    private Random random;
    private ArrayList<Level> levels;
    private ArrayList<Player> playerList;

    public Game(ArrayList<Level> levels,ArrayList<Player> players ) {
        snake = new Snake();
        food = new Food();
        random = new Random();
        obstacle = new Obstacle();
        score = new Score();
        this.levels = levels;
        this.playerList = players;
        generatedFood();
        generatePosSnake();
        generatedObstacle();
    }
    
    public void addPlayers(Player player){
        playerList.add(player);
    }

    public Level getLevel(String level) {
        for (int i = 0; i < levels.size(); i++) {
            if (level.equals(levels.get(i).getLevel())) {
                snake.setLon(levels.get(i).getSize());
                return levels.get(i);
            }

        }
        return null;

    }

    public void generatedObstacle() {
        int posx = (random.nextInt(1216 / 32) * 32);
        int posy = (random.nextInt(608 / 32) * 32);
        obstacle.setPosition(posx, posy);
    }

    public void generatedFood() {
        int posx = (random.nextInt(1216 / 32) * 32);
        int posy = (random.nextInt(608 / 32) * 32);
        food.setPosition(posx, posy);
    }

    public void generatePosSnake() {
        snake.add(new Point(1088, 192));
        snake.add(new Point(1088, 192));
    }

    public boolean eatSnake() {
        if (snake.getPointList().get(0).equals(food.getPosition())) {
            s++;
            score.setScore(s);
            generatedFood();
            return true;
        } else {
            return false;
        }
    }

    public void checkCollisionWithWalls(int width, int height) {
        Point head = snake.getPointList().get(0);
        int x = head.x;
        int y = head.y;
        if (x < 0) {
            x = width - 32;
        } else if (x >= width) {
            x = 0;
        }

        if (y < 0) {
            y = height - 32;
        } else if (y >= height) {
            y = 0;
        }
        snake.getPointList().get(0).setLocation(x, y);

    }

    public boolean checkCollisionWithBody() {
            if ((snake.getPointList().get(0).equals(obstacle.getPosition()))) {
                return true;
            } else {
                return false;
            }
        
    }
     public void sortUser() {
    playerList.sort((t, t1) -> Integer.compare(t1.getScore(), t.getScore()));
}



    public Food getFood() {
        return food;
    }

    public Snake getSnake() {
        return snake;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void move() {
        char direction = snake.getTrueDirection();
        Point head = snake.getPointList().get(0);
        switch (direction) {
            case 'R':
                snake.getPointList().get(0).setLocation(head.getX() + scale, head.getY());
                break;
            case 'L':
                snake.getPointList().get(0).setLocation(head.getX() - scale, head.getY());
                break;
            case 'U':
                snake.getPointList().get(0).setLocation(head.getX(), head.getY() - scale);
                break;
            case 'D':
                snake.getPointList().get(0).setLocation(head.getX(), head.getY() + scale);
                break;
            case 'N':
        }
        for (int i = snake.getLon() - 1; i > 0; i--) {
            snake.getPointList().get(i).setLocation(snake.getPointList().get(i - 1));
        }
    }

    public Score getScore() {
        return score;
    }

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }
    

}
