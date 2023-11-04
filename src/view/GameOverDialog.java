/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;

/**
 *
 * @author USER
 */
public class GameOverDialog extends JDialog {

    private JLabel lblName;
    private JLabel lblTittle;
    private JLabel lblimg;
    private JLabel lblScore;
    private JComboBox comboPlayer;
    private JButton btnStart;
    private JButton btnRegister;

    public GameOverDialog(ActionListener listener, ArrayList list) {
        initComponents(listener, list);
        setTitle("Game Over---Culebrita");
        setIconImage(new ImageIcon(".../icono.png").getImage());
        setSize(430, 270);
        setVisible(true);
        this.setLocationRelativeTo(null);

    }

    public void initComponents(ActionListener listener, ArrayList list) {
        setLayout(null);
        lblTittle = new JLabel("Fin del Juego");
        lblTittle.setBounds(120, 10, 150, 20);
        addFont(lblTittle, Color.BLACK, new Font("Barlow-regular", Font.PLAIN, 14));
        add(lblTittle);
        lblScore = new JLabel();
        lblScore.setBounds(100, 50, 150, 20);
        addFont(lblScore, Color.BLACK, new Font("Barlow-regular", Font.PLAIN, 14));
        add(lblScore);
        
        lblName = new JLabel("Jugador: ");
        lblName.setBounds(100, 70, 100, 20);
        addFont(lblName, Color.BLACK, new Font("Barlow-regular", Font.PLAIN, 13));
        add(lblName);
        
        comboPlayer = new JComboBox(list.toArray());
        comboPlayer.setBounds(100, 90, 100, 20);
        comboPlayer.setFont(new Font("Barlow-regular", Font.PLAIN, 13));
        add(comboPlayer);
        
        

        btnStart = new JButton("Ok");
        btnStart.addActionListener(listener);
        btnStart.setActionCommand("Guardar");
        btnStart.setBounds(100, 140, 130, 30);
        btnStart.setBackground(new Color(11, 218, 81));
        add(btnStart);
        btnRegister = new JButton("Registrarse");
        btnRegister.addActionListener(listener);
        btnRegister.setActionCommand("registrarse");
        btnRegister.setBounds(230, 140, 130, 30);
        btnRegister.setBackground(new Color(0, 108, 178));
        btnRegister.setForeground(Color.white);
        add(btnRegister);
        lblimg = new JLabel(new ImageIcon(this.getClass().getResource("/resources/icono.png")));
        lblimg.setBounds(300, 0, 100, 100);
        add(lblimg);
    }

    public void openCloseWindow(boolean b) {
        setVisible(b);
    }

    public JComboBox getComboPlayer() {
        return comboPlayer;
    }
    public void setLblScore(int score) {
        this.lblScore.setText("Puntaje: "+score);
    }
    

    public void addFont(JLabel txt, Color color, Font font) {
        txt.setForeground(color);
        txt.setFont(font);
    }

}
