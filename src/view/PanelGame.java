package view;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author USER
 */
public class PanelGame extends JPanel {

    private final ImageIcon snakeHeadImage;
    private final ImageIcon snakeBodyImage;
    private final ImageIcon foodImage;
    private final ImageIcon obstacleImage;
    private ArrayList<Point> snake;
    private Point food;
    private Point obstacle;
     private JLabel score;
    

    public PanelGame(KeyListener kl) {
        initComponents(kl);
        snakeHeadImage = new ImageIcon("src/resources/snakeHead.png");
        snakeBodyImage = new ImageIcon("src/resources/snakeBody.png");
        foodImage = new ImageIcon("src/resources/Food.png");
        obstacleImage = new ImageIcon("src/resources/Trampa.png");
    }

    private void initComponents(KeyListener kl) {
        setLayout(null);
        addKeyListener(kl);
        setFocusable(true);
         score = new JLabel("Puntaje: ");
        score.setBounds(1110, 0, 100, 30);
        score.setFont(new Font("Arial", Font.BOLD, 16));
        add(score);

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        drawSnake(g, snake);
        drawFood(g, food);
        drawObstacle(g, obstacle);
    }

    public void drawSnake(Graphics g, ArrayList<Point> snake) {
        for (Point point : snake) {
            if (point.equals(snake.get(0))) {
                snakeHeadImage.paintIcon(this, g, (int) point.getX(), (int) point.getY());
            } else {
                snakeBodyImage.paintIcon(this, g, (int) point.getX(), (int) point.getY());
            }
        }
    }
    public void reset(KeyListener kl) {
    snake = new ArrayList<>();
    food = null;
    obstacle = null; 
    setScore(0);

    
    addKeyListener(kl);
    requestFocusInWindow();
    
}


    public void drawFood(Graphics g, Point position) {
        foodImage.paintIcon(this, g, (int) position.getX(), (int) position.getY());
    }

    public void drawObstacle(Graphics g, Point position) {
        obstacleImage.paintIcon(this, g, (int) position.getX(), (int) position.getY());
    }

    public void setFood(Point food) {
        this.food = food;
    }

    public void setSnake(ArrayList<Point> snake) {
        this.snake = snake;
    }

    public void setObstacle(Point obstacle) {
        this.obstacle = obstacle;
    }

    public void setScore(int score) {
        this.score.setText("Puntaje: "+score);
    }
    

}
