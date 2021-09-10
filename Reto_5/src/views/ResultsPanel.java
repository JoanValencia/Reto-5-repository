/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author gefry
 */
public class ResultsPanel extends JPanel{
    
    private JLabel resultados_tabla;
    
    public ResultsPanel() {
        initComponents();
    }
    
    private void initComponents() {
        
        resultados_tabla = new  JLabel("Hello");
        add(resultados_tabla);
    }
}
