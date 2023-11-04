package controller;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import model.Game;
import model.Persistent;
import model.Player;
import view.StartGame;

/**
 *
 * @author USER
 */
public class Controller implements ActionListener, KeyListener {

    private StartGame startGame;
    private Thread snakeThread;
    private Thread foodThread;
    private Thread obstacleThread;
    private Thread ScoreThread;
    private Game sl;
    private boolean isGameRunning = true;
    private boolean pause = true;

    private boolean isEat = false;
    private Point food;

    public Controller() {
        sl = new Game(Persistent.read("src/resources/config.txt"), Persistent.readPlayers("src/resources/players.dat"));
        startGame = new StartGame(this, this, sl.getPlayerList(), getDatas());

    }

    private void inicio() {
        isGameRunning = true;
        pause = true;
        snakeThread = new Thread(() -> {
            while (isGameRunning) {
                if (isEat) {
                    sl.getSnake().add(food);
                    isEat = false;
                }
                moveSnake();
                sl.checkCollisionWithWalls(1248, 640);
                checkCollisions();
                startGame.getGame().repaint();
                try {
                    Thread.sleep(sl.getLevel((String) startGame.getComboLevel().getSelectedItem()).getSpeed());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        foodThread = new Thread(() -> {
            while (isGameRunning) {
                sl.generatedFood();
                setFoodPosition();
                startGame.getGame().repaint();
                try {
                    Thread.sleep((sl.getLevel((String) startGame.getComboLevel().getSelectedItem()).getSpeedFood()));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        obstacleThread = new Thread(() -> {
            while (isGameRunning) {
                sl.generatedObstacle();
                setObstaclePosition();
                startGame.getGame().repaint();
                try {
                    Thread.sleep(sl.getLevel((String) startGame.getComboLevel().getSelectedItem()).getBoom());
                } catch (InterruptedException e) {
                    break;
                }
            }
        });
        ScoreThread = new Thread(() -> {
            while (isGameRunning) {
                startGame.getGame().getPanelGame().setScore(sl.getScore().getScore());
                startGame.getGame().repaint();

            }
        });

        snakeThread.start();
        foodThread.start();
        obstacleThread.start();
        ScoreThread.start();

    }

    public void reiniciarJuego() {
        isGameRunning = false;

        sl = new Game(Persistent.read("src/resources/config.txt"), Persistent.readPlayers("src/resources/players.dat"));
        startGame.getGame().getPanelGame().reset(this);
inicio();
    }

    private void moveSnake() {
        addScore();
        sl.move();
        startGame.getGame().getPanelGame().setSnake(sl.getSnake().getPointList());
    }

    private void checkCollisions() {
        if ( (sl.checkCollisionWithBoom())) {
            startGame.getDialogGameOver().openCloseWindow(true);
            startGame.getDialogGameOver().setLblScore(sl.getScore().getScore());
            sl.getSnake().setDownDirection(false);
            sl.getSnake().setUpDirection(false);
            sl.getSnake().setRightDirection(false);
            sl.getSnake().setLeftDirection(false);
            gameOver();
        }
    }

    public void gameOver() {
        isGameRunning = false;
    }

    private void setFoodPosition() {
        startGame.getGame().getPanelGame().setFood(sl.getFood().getPosition());
    }

    private void setObstaclePosition() {
        startGame.getGame().getPanelGame().setObstacle(sl.getObstacle().getPosition());
    }

    private void addScore() {
        food = sl.getFood().getPosition();
        isEat = sl.eatSnake();
        setFoodPosition();
    }

    private boolean isContainerPerson(String name) {
        for (int i = 0; i < sl.getPlayerList().size(); i++) {
            if (name.equals(sl.getPlayerList().get(i).getNickName())) {
                return true;
            }

        }
        return false;
    }

    public void addUser() {
        String name = startGame.getRegisterDialog().getTxtName().getText();
        if (!(isContainerPerson(name))) {
            sl.addPlayers(new Player(name, sl.getScore().getScore()));
            Persistent.writePlayers("src/resources/players.dat", sl.getPlayerList());
            startGame.getDialogGameOver().getComboPlayer().addItem(name);
            startGame.getRegisterDialog().openCloseWindow(false);
            startGame.getDialogGameOver().openCloseWindow(true);
        } else {

            startGame.showmessage("Ese Usuario ya existe");
        }
    }

    public void updatePlayerScore() {
        String name = startGame.getDialogGameOver().getComboPlayer().getSelectedItem().toString();
        int newScore = sl.getScore().getScore();

        for (Player player : sl.getPlayerList()) {
            if (player.getNickName().equals(name)) {
                int currentScore = player.getScore();
                System.out.println("current score: " + currentScore);

                if (newScore > currentScore) {
                    player.setScore(newScore);
                    Persistent.writePlayers("src/resources/players.dat", sl.getPlayerList());
                    startGame.getDialogGameOver().openCloseWindow(true);
                } else {
                    startGame.showmessage("La puntuación no supera el récord actual para " + name);
                }
                return;
            }
        }

        startGame.showmessage("Ese Usuario no existe");
    }

    private Object[][] getDatas() {
        ArrayList<Player> list = sl.getPlayerList();
        Object[][] datas = new Object[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            datas[i][0] = list.get(i).getNickName();
            datas[i][1] = list.get(i).getScore();
        }
        return datas;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "iniciar Juego":
                startGame.getGame().openCloseWindow(true);
                startGame.setVisible(false);
                reiniciarJuego();
                break;
            case "Guardar":
                updatePlayerScore();
                startGame.setVisible(true);
                startGame.getGame().openCloseWindow(false);
                break;
            case "registrarse":
                startGame.getDialogGameOver().openCloseWindow(false);
                startGame.getRegisterDialog().openCloseWindow(true);
                break;
            case "ok":

                addUser();
                break;
            case "ver":
                startGame.getResults().openCloseWindow(true);
                sl.sortUser();
                startGame.getResults().updtaeTable(getDatas());
                break;
            case "play":
                startGame.getDialogPause().openPause(false);
                this.pause = true;
                System.out.println("pause btn: " + pause);
                
                break;
            case "reiniciar":
                reiniciarJuego();
                startGame.getDialogPause().openPause(false);
                break;
            case "home":
                startGame.getGame().openCloseWindow(false);
                startGame.getDialogPause().openPause(false);
                gameOver();
                startGame.setVisible(true);

                break;
            case "salir":
                System.exit(0);
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if ((e.getKeyCode() == KeyEvent.VK_DOWN) && (!sl.getSnake().isUpDirection())) {
            sl.getSnake().setDownDirection(true);
            sl.getSnake().setLeftDirection(false);
            sl.getSnake().setRightDirection(false);
        } else if ((e.getKeyCode() == KeyEvent.VK_UP) && (!sl.getSnake().isDownDirection())) {
            sl.getSnake().setUpDirection(true);
            sl.getSnake().setLeftDirection(false);
            sl.getSnake().setRightDirection(false);
        } else if ((e.getKeyCode() == KeyEvent.VK_LEFT) && (!sl.getSnake().isRightDirection())) {
            sl.getSnake().setDownDirection(false);
            sl.getSnake().setLeftDirection(true);
            sl.getSnake().setUpDirection(false);
        } else if ((e.getKeyCode() == KeyEvent.VK_RIGHT) && ((!sl.getSnake().isLeftDirection()))) {
            sl.getSnake().setDownDirection(false);
            sl.getSnake().setUpDirection(false);
            sl.getSnake().setRightDirection(true);
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            pause = !pause;

            if (pause) {
                startGame.getDialogPause().openPause(true);
                snakeThread.interrupt();
            }
            sl.getSnake().setDownDirection(false);
            sl.getSnake().setUpDirection(false);
            sl.getSnake().setRightDirection(false);
            sl.getSnake().setLeftDirection(false);
        }

    }

    @Override
    public void keyReleased(KeyEvent e
    ) {
    }

    public static void main(String[] args) {
        new Controller();
    }

}
