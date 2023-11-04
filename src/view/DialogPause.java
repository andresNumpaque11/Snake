package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DialogPause extends JFrame {

    private JPanel contentPane;
    private JLabel label;
    private JButton btnPause;
    private JButton btnrestart;
    private JButton btnhome;

    public DialogPause(ActionListener listener, String txtLabel, String tittle, int width, int height) {
        contentPane = new JPanel();
        initComponenets(listener);
        label.setText(tittle);
        label.setBounds(150, 10, 200, 20);
        configFont(label);

        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(null);
        setContentPane(contentPane);

        this.setTitle(tittle);
        this.setVisible(false);
        this.setSize(width, height);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
    }

    private void initComponenets(ActionListener listener) {
        label = new JLabel();
        contentPane.add(label);
        btnPause = new JButton("play");
        createButton("src/resources/play.png", btnPause, 70, 60, 70, 70);
        btnPause.addActionListener(listener);
        btnPause.setActionCommand("play");
        contentPane.add(btnPause);
        btnrestart = new JButton("reiniciar");
        btnrestart.addActionListener(listener);
        btnrestart.setActionCommand("reiniciar");
        createButton("src/resources/reset.png", btnrestart, 160, 60, 70, 70);
        contentPane.add(btnrestart);
        btnhome = new JButton("home");
        createButton("src/resources/home.png", btnhome, 250, 60, 70, 70);
        btnhome.addActionListener(listener);
        btnhome.setActionCommand("home");
        contentPane.add(btnhome);
    }

    public void createButton(String path, JButton buttonGeneric, int x, int y, int w, int h) {
        buttonGeneric.setBackground(Color.WHITE);
        buttonGeneric.setCursor(new Cursor(Cursor.HAND_CURSOR));
        buttonGeneric.setPreferredSize(new Dimension(200, 40));
       // buttonGeneric.setContentAreaFilled(false); 
        buttonGeneric.setRolloverEnabled(false);
        buttonGeneric.setBorderPainted(false);
        buttonGeneric.setFocusable(false);
        buttonGeneric.setBounds(x, y, w, h);
        ImageIcon image = new ImageIcon(path);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(buttonGeneric.getWidth(), buttonGeneric.getHeight(), Image.SCALE_DEFAULT));
        buttonGeneric.setIcon(icon);
        contentPane.add(buttonGeneric);
    }

    public void configFont(JLabel l) {
        l.setFont(new Font("Arial", Font.BOLD, 15));
    }

    public void openPause(boolean b) {
        this.setVisible(b);
    }
}
