/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class Results extends JDialog {

    private JTable table;
    private DefaultTableModel tableModel;
    private JButton btnClose;
     Object[][] datas;

    public Results(Object[][] datas) {
        initComponents(datas);
        this.setVisible(false);
        this.setSize(500, 600);
    }

    private void initComponents(Object[][] datas) {
        setLayout(new BorderLayout());
        String columns[] = {"Nombre",  "Puntaje"};
        tableModel = new DefaultTableModel(datas, columns);
        table = new JTable(tableModel);
        JScrollPane jsp = new JScrollPane(table);
        add(jsp,BorderLayout.NORTH);
        btnClose = new JButton("Cerrar");
        add(btnClose,BorderLayout.SOUTH);
    }
    public void updtaeTable(Object[][] datasUpdate){
        this.datas = datasUpdate;
        table.setModel(new javax.swing.table.DefaultTableModel(
            this.datas,
            new String[] {"Nombre", "Puntaje"
            }
        ));
    }

    public void openCloseWindow(boolean b) {
        this.setVisible(b);
    }

}
