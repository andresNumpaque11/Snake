package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class StartGame extends JFrame{

    private JButton btnStartGame;
    private JButton btnExit;
    private JButton btnAbout;
    private ImageIcon image;
    private Background fondo;
    private JComboBox comboLevel;
    private GameView game;
    
    private DialogPause dialogPause;
    private GameOverDialog dialogGameOver;
    private RegisterDialog registerDialog;
    private Results results;

    public StartGame(ActionListener listener, KeyListener kl, ArrayList list, Object [][] datas) {
        initComponents(listener, kl, list,datas);
        this.setTitle("Culebrita...");
        this.setSize(450, 450);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    private void initComponents(ActionListener listener, KeyListener kl, ArrayList list, Object[][] datas) {
        this.setLayout(null);
        btnStartGame = new JButton();
        createButton("src/resources/start.png", btnStartGame, 150, 100, 100, 50);
        btnStartGame.addActionListener(listener);
        btnStartGame.setActionCommand("iniciar Juego");
        comboLevel = new JComboBox();
        configureLevel( comboLevel);
        comboLevel.setBounds(150, 200, 100, 30);
        add(comboLevel);
        btnExit = new JButton("Exit");
        btnExit.addActionListener(listener);
        btnExit.setActionCommand("salir");
        createButton("src/resources/exit.png", btnExit, 150, 300, 100, 50);
        btnAbout = new JButton("Acerca de...");
        btnAbout.addActionListener(listener);
        btnAbout.setActionCommand("abrirAcercade");
        createButton("src/resources/info.jpg", btnAbout, 400, 0, 50, 50);
        image = new ImageIcon("src/resources/fondo2.jpg");
        Image background = image.getImage();
        fondo = new Background(background);
        fondo.setBounds(0, 0, 450, 450);
        add(fondo);
        game = new GameView(listener, kl);
        dialogPause = new DialogPause(listener, "Pause", "pause", 420, 270);
        dialogGameOver = new GameOverDialog(listener, list);
        registerDialog = new RegisterDialog(listener);
        results = new Results(datas);
    }

    public void createButton(String path, JButton buttonGeneric, int x, int y, int w, int h) {
        buttonGeneric.setBackground(Color.WHITE);
        buttonGeneric.setCursor(new Cursor(Cursor.HAND_CURSOR));
        buttonGeneric.setPreferredSize(new Dimension(200, 40));
        buttonGeneric.setBorderPainted(false);
        buttonGeneric.setFocusable(false);
        buttonGeneric.setBounds(x, y, w, h);
        ImageIcon image = new ImageIcon(path);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(buttonGeneric.getWidth(), buttonGeneric.getHeight(), Image.SCALE_DEFAULT));
        buttonGeneric.setIcon(icon);
        add(buttonGeneric);
    }

    private void configureLevel( JComboBox comboGeneric) {
        comboLevel.addItem("facil");
        comboLevel.addItem("medio");
        comboLevel.addItem("dificil");
    }
     public void showmessage(String message) {
        JOptionPane.showMessageDialog(null, message, "message", JOptionPane.ERROR_MESSAGE);
    }

    public GameView getGame() {
        return game;
    }

    public RegisterDialog getRegisterDialog() {
        return registerDialog;
    }
    
    

    public DialogPause getDialogPause() {
        return dialogPause;
    }

    public GameOverDialog getDialogGameOver() {
        return dialogGameOver;
    }

    public Results getResults() {
        return results;
    }
    
    

    public JComboBox getComboLevel() {
        return comboLevel;
    }
    
    
    

}
