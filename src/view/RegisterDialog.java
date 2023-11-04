/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author PC
 */
public class RegisterDialog extends JDialog {

    private JLabel lblName;
    private JLabel lblimg;
    private JLabel lblPassword;
    private JTextField txtName;
    private JPasswordField password;
    private JButton btnOk;
    private JButton btnCancel;

    public RegisterDialog(ActionListener listener) {
        initComponents(listener);
        this.setVisible(false);
        setIconImage(new ImageIcon("./resources/icono.png").getImage());
        this.setTitle("Registrarse---Culebrita");
        this.setSize(430, 270);
        this.setLocationRelativeTo(null);
    }

    private void initComponents(ActionListener listener) {
        setLayout(null);
        lblName = new JLabel("Nombre: ");
        lblName.setBounds(100, 50, 100, 20);
        addFont(lblName, Color.BLACK, new Font("barrow-regular", Font.PLAIN, 13));
        add(lblName);
        txtName = new JTextField(10);
        txtName.setBounds(100, 70, 100, 20);
        add(txtName);
        
       
        btnOk = new JButton("Registrarse");
        btnOk.addActionListener(listener);
        btnOk.setActionCommand("ok");
        btnOk.setBounds(100, 130, 130, 30);
        btnOk.setBackground(new Color(11, 218, 81));
        add(btnOk);
        btnCancel = new JButton("Cancelar");
        btnCancel.addActionListener(listener);
        btnCancel.setActionCommand("Cancelar");
        btnCancel.setBounds(100, 160, 130, 30);
        btnCancel.setBackground(new Color(0, 108, 178));
        btnCancel.setForeground(Color.white);
        add(btnCancel);
        lblimg = new JLabel(new ImageIcon("src/resources/icono.png"));
        lblimg.setBounds(300, 0, 100, 100);
        add(lblimg);
    }

    public void openCloseWindow(boolean b) {
        setVisible(b);
    }

    public JTextField getTxtName() {
        return txtName;
    }

    public void addFont(JLabel txt, Color color, Font font) {
        txt.setForeground(color);
        txt.setFont(font);
    }

}
