package view;

import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author USER
 */
public class GameView extends JFrame {

    private PanelGame panelGame;
    private ImageIcon image;
    private JMenuBar barraMenu;
    private JMenu menu;
    private JMenu menuVer;
    private JMenu menuEdit;
    private JMenuItem reiniciar;
    private JMenuItem salir;
    private JMenuItem ver;
    private Background fondo;

    public GameView(ActionListener listener, KeyListener kl) {
        initComponents(listener, kl);
        this.setSize(1264, 704);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(false);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    private void initComponents(ActionListener listener, KeyListener kl) {
        this.setLayout(null);
        image = new ImageIcon("src/resources/fondoJuego.png");
        Image background = image.getImage();
        fondo = new Background(background);
        fondo.setBounds(0, 0, 1280, 720);
        panelGame = new PanelGame(kl);
        panelGame.setBounds(0, 0, 1280, 720);
        add(panelGame);
        add(fondo);

        barraMenu = new JMenuBar();
        menu = new JMenu("Menu");
        menuVer = new JMenu("Ver");
        reiniciar = new JMenuItem("Reiniciar");
        reiniciar.addActionListener(listener);
        reiniciar.setActionCommand("reiniciar");
        menu.add(reiniciar);
        ver = new JMenuItem("Ver Estadisticas");
        ver.addActionListener(listener);
        ver.setActionCommand("ver");
        menuVer.add(ver);
        salir = new JMenuItem("Salir");
        salir.addActionListener(listener);
        salir.setActionCommand("salir");
        menu.add(salir);
        barraMenu.add(menu);
        barraMenu.add(menuVer);
        this.setJMenuBar(barraMenu);
    }

    public void openCloseWindow(boolean b) {
        this.setVisible(b);
    }

    public PanelGame getPanelGame() {
        return panelGame;
    }
}
